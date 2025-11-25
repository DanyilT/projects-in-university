#!/usr/bin/env python3
"""
ECB Pattern Viewer
Creates multiple visualizations to see the encrypted patterns clearly.
Handles encrypted BMP headers by using calculated dimensions.
"""

import sys
from collections import Counter
from PIL import Image
import numpy as np

def read_encrypted_bmp(filename):
    """Read and parse encrypted BMP file."""
    with open(filename, 'rb') as f:
        data = f.read()

    # BMP header is 54 bytes (but it's encrypted!)
    header = data[:54]
    pixel_data = data[54:]

    return header, pixel_data

def calculate_dimensions(pixel_data_size):
    """
    Calculate likely dimensions based on pixel data size.
    For 24-bit BMP with padding.
    """
    # Common dimensions to try
    common_dims = [
        (640, 480),
        (800, 600),
        (1024, 768),
        (512, 512),
        (320, 240),
        (256, 256),
    ]

    for width, height in common_dims:
        bytes_per_pixel = 3
        row_size = ((width * bytes_per_pixel * 8 + 31) // 32) * 4
        expected_size = row_size * height

        if abs(expected_size - pixel_data_size) < 100:
            return width, height

    # Default to 640x480 if nothing matches
    return 640, 480

def create_pattern_image(pixel_data, width, height, output_file):
    """
    Create an image where each unique 16-byte block is mapped to a unique grayscale value.
    This reveals the structure without decrypting.
    """
    print(f"\n[+] Creating pattern visualization: {output_file}")

    # Split into 16-byte blocks
    block_size = 16
    blocks = []
    for i in range(0, len(pixel_data), block_size):
        block = pixel_data[i:i+block_size]
        if len(block) == block_size:
            blocks.append(block)

    print(f"    Total blocks: {len(blocks)}")

    # Count block frequencies
    block_counter = Counter(blocks)
    unique_blocks = list(block_counter.keys())
    print(f"    Unique blocks: {len(unique_blocks)}")

    # Sort blocks by frequency (most common first)
    sorted_blocks = sorted(block_counter.items(), key=lambda x: x[1], reverse=True)

    # Map each unique block to a grayscale value
    block_to_color = {}

    # Most common block (likely background) = white
    most_common_block = sorted_blocks[0][0]
    block_to_color[most_common_block] = 255

    # Other blocks get darker shades based on frequency
    for i, (block, count) in enumerate(sorted_blocks[1:], 1):
        # Gradient from 254 down to 0
        gray_value = max(0, 254 - int((i / len(sorted_blocks)) * 254))
        block_to_color[block] = gray_value

    print(f"    Most common block: {most_common_block.hex()[:32]}... (count: {sorted_blocks[0][1]})")
    print(f"    Mapped to: WHITE (background)")

    # Create image array
    bytes_per_pixel = 3
    row_size = ((width * bytes_per_pixel * 8 + 31) // 32) * 4

    img_array = np.full((height, width), 0, dtype=np.uint8)

    # Process blocks and map to pixels
    for y in range(height):
        for x in range(width):
            # Calculate which block this pixel belongs to
            row_start = y * row_size
            pixel_byte_pos = row_start + (x * bytes_per_pixel)
            block_num = pixel_byte_pos // block_size

            if block_num < len(blocks):
                block = blocks[block_num]
                gray = block_to_color.get(block, 128)
                # BMP is stored bottom-up, so flip
                img_array[height - 1 - y, x] = gray

    # Save as image
    img = Image.fromarray(img_array, mode='L')
    img.save(output_file)
    print(f"    [✓] Saved: {output_file}")

    return img

def create_block_frequency_image(pixel_data, width, height, output_file):
    """
    Create an image where brightness represents block frequency.
    Most common blocks = white (background), rare blocks = black (foreground).
    """
    print(f"\n[+] Creating frequency-based visualization: {output_file}")

    block_size = 16
    blocks = []
    for i in range(0, len(pixel_data), block_size):
        block = pixel_data[i:i+block_size]
        if len(block) == block_size:
            blocks.append(block)

    # Count frequencies
    block_counter = Counter(blocks)
    max_freq = max(block_counter.values())

    print(f"    Max block frequency: {max_freq}")

    # Create image where brightness = frequency
    bytes_per_pixel = 3
    row_size = ((width * bytes_per_pixel * 8 + 31) // 32) * 4

    img_array = np.zeros((height, width), dtype=np.uint8)

    for y in range(height):
        row_start = y * row_size
        for x in range(width):
            pixel_pos = row_start + (x * bytes_per_pixel)
            block_num = pixel_pos // block_size

            if block_num < len(blocks):
                block = blocks[block_num]
                freq = block_counter[block]
                # Common blocks = white, rare blocks = black
                brightness = int(255 * (freq / max_freq))
                img_array[height - 1 - y, x] = brightness

    img = Image.fromarray(img_array, mode='L')
    img.save(output_file)
    print(f"    [✓] Saved: {output_file}")

    return img

def create_direct_visualization(pixel_data, width, height, output_file):
    """
    Directly visualize the encrypted data as an image.
    Even though encrypted, patterns should be visible due to ECB.
    """
    print(f"\n[+] Creating direct encrypted visualization: {output_file}")

    bytes_per_pixel = 3
    row_size = ((width * bytes_per_pixel * 8 + 31) // 32) * 4
    expected_size = row_size * height

    print(f"    Expected pixel data size: {expected_size}")
    print(f"    Actual pixel data size: {len(pixel_data)}")

    # Adjust pixel data if needed
    if len(pixel_data) < expected_size:
        pixel_data = pixel_data + b'\x00' * (expected_size - len(pixel_data))
    elif len(pixel_data) > expected_size:
        pixel_data = pixel_data[:expected_size]

    # Create image array (RGB)
    img_array = np.zeros((height, width, 3), dtype=np.uint8)

    for y in range(height):
        row_start = y * row_size
        for x in range(width):
            pixel_start = row_start + (x * bytes_per_pixel)
            if pixel_start + 2 < len(pixel_data):
                # BMP stores as BGR
                b = pixel_data[pixel_start]
                g = pixel_data[pixel_start + 1]
                r = pixel_data[pixel_start + 2]
                # Convert to RGB and flip vertically (BMP is bottom-up)
                img_array[height - 1 - y, x] = [r, g, b]

    img = Image.fromarray(img_array, mode='RGB')
    img.save(output_file)
    print(f"    [✓] Saved: {output_file}")

    return img

def create_simple_block_map(pixel_data, width, height, output_file):
    """
    Simplest possible visualization: map each unique block to a unique color.
    """
    print(f"\n[+] Creating simple block map: {output_file}")

    block_size = 16
    blocks = []
    for i in range(0, len(pixel_data), block_size):
        block = pixel_data[i:i+block_size]
        if len(block) == block_size:
            blocks.append(block)

    # Get unique blocks
    unique_blocks = list(set(blocks))
    print(f"    Unique blocks: {len(unique_blocks)}")

    # Create color palette
    block_to_id = {block: i for i, block in enumerate(unique_blocks)}

    # Create indexed image
    bytes_per_pixel = 3
    row_size = ((width * bytes_per_pixel * 8 + 31) // 32) * 4

    img_array = np.zeros((height, width), dtype=np.uint8)

    for y in range(height):
        row_start = y * row_size
        for x in range(width):
            pixel_pos = row_start + (x * bytes_per_pixel)
            block_num = pixel_pos // block_size

            if block_num < len(blocks):
                block = blocks[block_num]
                block_id = block_to_id[block]
                # Map to 0-255 range
                color = int((block_id / len(unique_blocks)) * 255)
                img_array[height - 1 - y, x] = color

    img = Image.fromarray(img_array, mode='L')
    img.save(output_file)
    print(f"    [✓] Saved: {output_file}")

    return img

def main():
    print("="*80)
    print("ECB PATTERN VIEWER")
    print("="*80)

    if len(sys.argv) < 2:
        print("\nUsage: python3 ecb_pattern_viewer.py <encrypted_bmp_file> [width] [height]")
        print("\nExample:")
        print("  python3 ecb_pattern_viewer.py aes.bmp.enc")
        print("  python3 ecb_pattern_viewer.py aes.bmp.enc 640 480")
        sys.exit(1)

    input_file = sys.argv[1]

    # Read encrypted file
    print(f"\n[+] Reading: {input_file}")
    header, pixel_data = read_encrypted_bmp(input_file)

    print(f"[+] Header size: {len(header)} bytes (encrypted)")
    print(f"[+] Pixel data size: {len(pixel_data)} bytes")

    # Get dimensions from command line or calculate
    if len(sys.argv) >= 4:
        width = int(sys.argv[2])
        height = int(sys.argv[3])
        print(f"[+] Using provided dimensions: {width}x{height}")
    else:
        width, height = calculate_dimensions(len(pixel_data))
        print(f"[+] Calculated dimensions: {width}x{height}")

    # Create multiple visualizations
    base_name = input_file.replace('.enc', '').replace('.bmp', '')

    try:
        # Visualization 1: Pattern-based (recommended)
        pattern_output = f"{base_name}_pattern.png"
        create_pattern_image(pixel_data, width, height, pattern_output)

        # Visualization 2: Frequency-based
        freq_output = f"{base_name}_frequency.png"
        create_block_frequency_image(pixel_data, width, height, freq_output)

        # Visualization 3: Direct visualization
        direct_output = f"{base_name}_direct.png"
        create_direct_visualization(pixel_data, width, height, direct_output)

        # Visualization 4: Simple block map
        simple_output = f"{base_name}_simple.png"
        create_simple_block_map(pixel_data, width, height, simple_output)

        print("\n" + "="*80)
        print("VISUALIZATION COMPLETE")
        print("="*80)
        print("\n[+] Generated files:")
        print(f"    1. {pattern_output} - Pattern-based")
        print(f"    2. {freq_output} - Frequency-based")
        print(f"    3. {direct_output} - Direct encrypted view")
        print(f"    4. {simple_output} - Simple block mapping")
        print("\n[+] Open these PNG files to see the ECB patterns!")
        print("    The original image structure should be clearly visible.")

    except Exception as e:
        print(f"\n[!] Error creating visualizations: {e}")
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    main()
