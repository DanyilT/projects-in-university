#!/usr/bin/env python3
"""
ECB Block Analyzer
Provides detailed analysis of block patterns in ECB-encrypted data.
"""

import sys
from collections import Counter
import matplotlib
matplotlib.use('Agg')  # Non-interactive backend
import matplotlib.pyplot as plt

def analyze_ecb_file(filename):
    """Perform comprehensive ECB analysis."""

    print("="*80)
    print("ECB BLOCK PATTERN ANALYZER")
    print("="*80)

    # Read file
    with open(filename, 'rb') as f:
        data = f.read()

    print(f"\n[+] File: {filename}")
    print(f"[+] Size: {len(data)} bytes")

    # Skip BMP header (54 bytes)
    header_size = 54
    pixel_data = data[header_size:]

    # Split into 16-byte blocks
    block_size = 16
    blocks = []
    for i in range(0, len(pixel_data), block_size):
        block = pixel_data[i:i+block_size]
        if len(block) == block_size:
            blocks.append(block)

    print(f"\n[+] Analysis:")
    print(f"    Block size: {block_size} bytes")
    print(f"    Total blocks: {len(blocks)}")

    # Frequency analysis
    block_counter = Counter(blocks)
    unique_blocks = len(block_counter)

    print(f"    Unique blocks: {unique_blocks}")
    print(f"    Duplicate blocks: {len(blocks) - unique_blocks}")
    print(f"    Uniqueness ratio: {(unique_blocks/len(blocks)*100):.2f}%")

    # Most common blocks
    print(f"\n[+] Top 20 most common blocks:")
    for i, (block, count) in enumerate(block_counter.most_common(20), 1):
        percentage = (count / len(blocks)) * 100
        print(f"    {i:2d}. Count: {count:4d} ({percentage:5.2f}%) | Hex: {block.hex()[:32]}...")

    # Distribution analysis
    counts = list(block_counter.values())
    print(f"\n[+] Block repetition statistics:")
    print(f"    Min repetitions: {min(counts)}")
    print(f"    Max repetitions: {max(counts)}")
    print(f"    Avg repetitions: {sum(counts)/len(counts):.2f}")

    # Plot distribution
    try:
        plt.figure(figsize=(12, 6))

        # Histogram of block frequencies
        plt.subplot(1, 2, 1)
        plt.hist(counts, bins=50, edgecolor='black')
        plt.xlabel('Number of Repetitions')
        plt.ylabel('Number of Blocks')
        plt.title('Distribution of Block Repetitions')
        plt.yscale('log')

        # Most common blocks bar chart
        plt.subplot(1, 2, 2)
        top_20 = block_counter.most_common(20)
        labels = [f"Block {i}" for i in range(1, 21)]
        values = [count for _, count in top_20]
        plt.bar(labels, values)
        plt.xlabel('Block ID')
        plt.ylabel('Frequency')
        plt.title('Top 20 Most Common Blocks')
        plt.xticks(rotation=45)

        plt.tight_layout()
        output_plot = filename.replace('.enc', '_analysis.png')
        plt.savefig(output_plot, dpi=150)
        print(f"\n[+] Saved analysis plot: {output_plot}")
    except Exception as e:
        print(f"\n[!] Could not create plot: {e}")

    return block_counter

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python3 ecb_block_analyzer.py <encrypted_file>")
        sys.exit(1)

    analyze_ecb_file(sys.argv[1])
