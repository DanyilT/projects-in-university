#!/usr/bin/env python3
"""
AES-ECB Encrypted Image Recovery Tool
Exploits the deterministic nature of ECB mode to reconstruct encrypted BMP images
without knowing the encryption key.

Author: DanyilT
Date: November 24, 2025
"""

import sys
from collections import Counter

def read_file_bytes(filename):
    """Read entire file as bytes."""
    try:
        with open(filename, 'rb') as f:
            return f.read()
    except FileNotFoundError:
        print(f"[!] Error: File '{filename}' not found")
        sys.exit(1)
    except Exception as e:
        print(f"[!] Error reading file: {e}")
        sys.exit(1)

def write_file_bytes(filename, data):
    """Write bytes to file."""
    try:
        with open(filename, 'wb') as f:
            f.write(data)
        print(f"[+] Successfully wrote {len(data)} bytes to '{filename}'")
    except Exception as e:
        print(f"[!] Error writing file: {e}")
        sys.exit(1)

def split_into_blocks(data, block_size=16):
    """Split data into blocks of specified size."""
    blocks = []
    for i in range(0, len(data), block_size):
        block = data[i:i+block_size]
        # Pad last block if necessary
        if len(block) < block_size:
            block = block + b'\x00' * (block_size - len(block))
        blocks.append(block)
    return blocks

def analyze_block_frequency(blocks):
    """Analyze frequency of repeated blocks."""
    block_counter = Counter(blocks)
    total_blocks = len(blocks)
    unique_blocks = len(block_counter)

    print(f"\n[+] Block Analysis:")
    print(f"    Total blocks: {total_blocks}")
    print(f"    Unique blocks: {unique_blocks}")
    print(f"    Repeated blocks: {total_blocks - unique_blocks}")
    print(f"    Repetition rate: {((total_blocks - unique_blocks) / total_blocks * 100):.2f}%")

    # Find most common blocks
    most_common = block_counter.most_common(10)
    print(f"\n[+] Top 10 most frequent blocks:")
    for i, (block, count) in enumerate(most_common, 1):
        print(f"    {i}. Count: {count:4d} | Hex: {block.hex()[:32]}...")

    return block_counter

def create_bmp_header(width, height, bits_per_pixel=24):
    """
    Create a standard BMP header for an uncompressed RGB image.

    BMP Header Structure (54 bytes):
    - File Header (14 bytes)
    - DIB Header / Info Header (40 bytes)
    """
    # Calculate sizes
    row_size = ((bits_per_pixel * width + 31) // 32) * 4  # Row size must be multiple of 4
    pixel_data_size = row_size * height
    file_size = 54 + pixel_data_size

    # File Header (14 bytes)
    bmp_header = bytearray()
    bmp_header += b'BM'                          # Signature
    bmp_header += file_size.to_bytes(4, 'little')   # File size
    bmp_header += b'\x00\x00'                    # Reserved 1
    bmp_header += b'\x00\x00'                    # Reserved 2
    bmp_header += (54).to_bytes(4, 'little')     # Pixel data offset

    # DIB Header (40 bytes) - BITMAPINFOHEADER
    bmp_header += (40).to_bytes(4, 'little')     # Header size
    bmp_header += width.to_bytes(4, 'little')    # Width
    bmp_header += height.to_bytes(4, 'little')   # Height
    bmp_header += (1).to_bytes(2, 'little')      # Color planes
    bmp_header += bits_per_pixel.to_bytes(2, 'little')  # Bits per pixel
    bmp_header += (0).to_bytes(4, 'little')      # Compression (0 = none)
    bmp_header += pixel_data_size.to_bytes(4, 'little')  # Image size
    bmp_header += (2835).to_bytes(4, 'little')   # Horizontal resolution (72 DPI)
    bmp_header += (2835).to_bytes(4, 'little')   # Vertical resolution (72 DPI)
    bmp_header += (0).to_bytes(4, 'little')      # Colors in palette
    bmp_header += (0).to_bytes(4, 'little')      # Important colors

    return bytes(bmp_header)

def estimate_image_dimensions(file_size, header_size=54):
    """
    Estimate possible image dimensions based on file size.
    Assumes 24-bit BMP (3 bytes per pixel).
    """
    pixel_data_size = file_size - header_size

    # Common image dimensions to try
    common_dimensions = [
        (640, 480), (800, 600), (1024, 768), (1280, 720), (1920, 1080),
        (320, 240), (512, 512), (256, 256), (128, 128), (100, 100),
        (400, 300), (600, 400), (500, 500), (300, 300), (200, 200)
    ]

    possible_dimensions = []

    for width, height in common_dimensions:
        # Calculate expected row size (rows padded to 4-byte boundary)
        row_size = ((24 * width + 31) // 32) * 4
        expected_size = row_size * height

        if abs(expected_size - pixel_data_size) < 100:  # Allow small margin
            possible_dimensions.append((width, height, expected_size))

    # Also try to factor the pixel data size
    # For 24-bit BMP, each pixel is 3 bytes (but rows are padded)

    print(f"\n[+] Estimated dimensions based on file size ({file_size} bytes):")
    if possible_dimensions:
        for width, height, expected in possible_dimensions:
            print(f"    {width}x{height} (expected data: {expected} bytes)")
    else:
        print("    No standard dimensions match exactly")
        print("    Will try manual dimension input")

    return possible_dimensions

def reconstruct_ecb_image_method1(encrypted_data, output_file, width=None, height=None):
    """
    Method 1: Keep encrypted header, replace with new header.

    This method:
    1. Extracts the encrypted pixel data
    2. Creates a new valid BMP header
    3. Keeps the encrypted pixel data as-is
    4. Exploits ECB property: identical plaintext blocks → identical ciphertext blocks
    """
    print("\n" + "="*80)
    print("METHOD 1: Header Replacement")
    print("="*80)

    # BMP header is 54 bytes (always)
    header_size = 54

    if len(encrypted_data) <= header_size:
        print("[!] Error: File too small to be a valid BMP")
        return False

    # Extract encrypted pixel data (everything after header)
    encrypted_pixels = encrypted_data[header_size:]

    print(f"[+] Encrypted header size: {header_size} bytes")
    print(f"[+] Encrypted pixel data size: {len(encrypted_pixels)} bytes")

    # Estimate dimensions if not provided
    if width is None or height is None:
        possible_dims = estimate_image_dimensions(len(encrypted_data))
        if possible_dims:
            width, height, _ = possible_dims[0]
            print(f"[+] Using estimated dimensions: {width}x{height}")
        else:
            print("[!] Could not estimate dimensions automatically")
            return False

    # Create new valid BMP header
    new_header = create_bmp_header(width, height)

    print(f"[+] Created new BMP header:")
    print(f"    Dimensions: {width}x{height}")
    print(f"    Header size: {len(new_header)} bytes")

    # Combine new header with encrypted pixel data
    reconstructed = new_header + encrypted_pixels

    # Write to file
    write_file_bytes(output_file, reconstructed)

    print(f"\n[✓] Method 1 complete: {output_file}")
    print(f"    Note: Pixel data is still encrypted, but patterns should be visible!")

    return True

def reconstruct_ecb_image_method2(encrypted_data, output_file, width=None, height=None):
    """
    Method 2: Block pattern visualization.

    This method:
    1. Maps each unique encrypted block to a unique color
    2. Creates a visual representation of the block patterns
    3. Results in a "silhouette" or outline of the original image
    """
    print("\n" + "="*80)
    print("METHOD 2: Block Pattern Visualization")
    print("="*80)

    header_size = 54
    encrypted_pixels = encrypted_data[header_size:]

    # Split into 16-byte blocks
    blocks = split_into_blocks(encrypted_pixels, 16)

    print(f"[+] Total blocks: {len(blocks)}")

    # Analyze block frequency
    block_counter = analyze_block_frequency(blocks)

    # Create color mapping for unique blocks
    unique_blocks = list(block_counter.keys())
    print(f"\n[+] Creating color mapping for {len(unique_blocks)} unique blocks")

    # Assign colors: most common block = white, others gradient to black
    sorted_blocks = sorted(block_counter.items(), key=lambda x: x[1], reverse=True)

    color_map = {}
    num_colors = len(sorted_blocks)

    for i, (block, count) in enumerate(sorted_blocks):
        # Create grayscale gradient
        intensity = int(255 * (1 - i / max(num_colors - 1, 1)))
        # RGB color (all same for grayscale)
        color = bytes([intensity, intensity, intensity])
        color_map[block] = color

    # Reconstruct pixel data with color mapping
    reconstructed_pixels = bytearray()

    for block in blocks:
        color = color_map.get(block, b'\x00\x00\x00')  # Default to black
        # Each 16-byte block represents some pixels
        # For 24-bit BMP, 16 bytes = 5.33 pixels
        # We'll map each block to approximately 5 pixels
        for _ in range(5):
            reconstructed_pixels.extend(color)

    # Estimate dimensions if not provided
    if width is None or height is None:
        # Calculate based on reconstructed pixel data
        total_pixels = len(reconstructed_pixels) // 3
        # Try square-ish dimensions
        width = int(total_pixels ** 0.5)
        height = total_pixels // width
        print(f"[+] Calculated dimensions: {width}x{height}")

    # Adjust pixel data to match dimensions
    required_pixels = width * height
    required_bytes = required_pixels * 3

    if len(reconstructed_pixels) < required_bytes:
        # Pad with black pixels
        reconstructed_pixels.extend(b'\x00' * (required_bytes - len(reconstructed_pixels)))
    else:
        # Trim excess
        reconstructed_pixels = reconstructed_pixels[:required_bytes]

    # Create BMP header
    new_header = create_bmp_header(width, height)

    # Combine header and pixels
    reconstructed = new_header + bytes(reconstructed_pixels)

    # Write to file
    write_file_bytes(output_file, reconstructed)

    print(f"\n[✓] Method 2 complete: {output_file}")
    print(f"    This should show the pattern/silhouette of the original image")

    return True

def visualize_block_patterns(encrypted_data, output_prefix="block_pattern"):
    """
    Create a visual representation of how blocks repeat in the encrypted data.
    Generates a simple text-based visualization.
    """
    print("\n" + "="*80)
    print("BLOCK PATTERN ANALYSIS")
    print("="*80)

    header_size = 54
    encrypted_pixels = encrypted_data[header_size:]
    blocks = split_into_blocks(encrypted_pixels, 16)

    # Analyze patterns
    block_counter = analyze_block_frequency(blocks)

    # Create a simple visual representation
    print("\n[+] Block repetition pattern (first 200 blocks):")
    print("    '█' = unique block, '▓' = repeated 2-5x, '▒' = repeated 6-10x, '░' = repeated 11+x\n")

    seen_blocks = {}
    pattern = []

    for i, block in enumerate(blocks[:200]):
        if block not in seen_blocks:
            seen_blocks[block] = 0
        seen_blocks[block] += 1

        count = block_counter[block]
        if count == 1:
            pattern.append('█')
        elif count <= 5:
            pattern.append('▓')
        elif count <= 10:
            pattern.append('▒')
        else:
            pattern.append('░')

    # Print in rows of 50
    for i in range(0, len(pattern), 50):
        print("    " + "".join(pattern[i:i+50]))

    return True

def main():
    print("="*80)
    print("AES-ECB ENCRYPTED IMAGE RECOVERY TOOL")
    print("="*80)
    print("\nThis tool exploits the weakness of ECB mode encryption")
    print("to recover visual patterns from encrypted BMP images.\n")

    # Check command line arguments
    if len(sys.argv) < 2:
        print("Usage: python3 aes_ecb_image_recovery.py <encrypted_file> [width] [height]")
        print("\nExample:")
        print("  python3 aes_ecb_image_recovery.py aes.bmp.enc")
        print("  python3 aes_ecb_image_recovery.py aes.bmp.enc 640 480")
        sys.exit(1)

    input_file = sys.argv[1]

    # Optional dimensions
    width = int(sys.argv[2]) if len(sys.argv) > 2 else None
    height = int(sys.argv[3]) if len(sys.argv) > 3 else None

    # Read encrypted file
    print(f"[+] Reading encrypted file: {input_file}")
    encrypted_data = read_file_bytes(input_file)
    print(f"[+] File size: {len(encrypted_data)} bytes")

    # Visualize block patterns
    visualize_block_patterns(encrypted_data)

    # Method 1: Header replacement (keeps encrypted pixels)
    output1 = input_file.replace('.enc', '_method1.bmp')
    if output1 == input_file:
        output1 = 'recovered_method1.bmp'
    success1 = reconstruct_ecb_image_method1(encrypted_data, output1, width, height)

    # Method 2: Block pattern visualization
    output2 = input_file.replace('.enc', '_method2.bmp')
    if output2 == input_file:
        output2 = 'recovered_method2.bmp'
    success2 = reconstruct_ecb_image_method2(encrypted_data, output2, width, height)

    # Summary
    print("\n" + "="*80)
    print("RECOVERY COMPLETE")
    print("="*80)
    print("\n[+] Summary:")
    print(f"    Input file: {input_file}")
    if success1:
        print(f"    Method 1 output: {output1}")
        print(f"      → Should show encrypted patterns clearly")
    if success2:
        print(f"    Method 2 output: {output2}")
        print(f"      → Should show block-based silhouette")

    print("\n[+] Why this works:")
    print("    ECB mode encrypts identical plaintext blocks identically")
    print("    Patterns in the original image are preserved in ciphertext")
    print("    We can visualize these patterns without knowing the key!")

    return True

if __name__ == "__main__":
    main()
