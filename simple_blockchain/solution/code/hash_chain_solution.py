#!/usr/bin/env python3
"""
Simple Blockchain Challenge - Solution

Challenge Description:
    You registered for an online service that uses hash chains for authentication.
    Your (my) account (nOOB) was given seed: 654e1c2ac6312d8c6441282f155c8ce9

Challenge:
    Find X such that hash(X) = c89aa2ffb9edcc6604005196b5f0e0e4

Solution Approach:
    1. Identified hash function as MD5 (32 hex characters)
    2. Realized each user has their own seed and hash chain
    3. Discovered ECSC's seed is "ecsc" (lowercase)
    4. Generated ECSC's hash chain to find X at position 1100

Solution:
    X = 6fe9b4d366668a1f8a964a72cbc912c8
"""

import hashlib

def hash_function(value):
    """MD5 hash function."""
    return hashlib.md5(value.encode('utf-8')).hexdigest()

def find_predecessor(target_hash, seed, max_iterations=10000):
    """
    Find X such that hash(X) = target_hash. 

    Returns: (predecessor, position) or (None, -1)
    """
    current = seed

    for i in range(max_iterations):
        next_hash = hash_function(current)

        if next_hash == target_hash:
            return current, i

        if (i + 1) % 1000 == 0:
            print(f"  Checked {i+1:,} iterations...")

        current = next_hash

    return None, -1

def main():
    print("="*80)
    print("SIMPLE BLOCKCHAIN SOLUTION - HASH CHAIN AUTHENTICATION")
    print("="*80)

    # Challenge parameters
    YOUR_ACCOUNT = "nOOB"  # my account
    TARGET_ACCOUNT = "ECSC"  # target account
    YOUR_SEED = "654e1c2ac6312d8c6441282f155c8ce9"  # my seed (nOOB)
    TARGET_HASH = "c89aa2ffb9edcc6604005196b5f0e0e4"  # ECSC's target hash 

    print(f"\n[+] Given:")
    print(f"    Your (my) seed ({YOUR_ACCOUNT}):  {YOUR_SEED}")
    print(f"    Target ({TARGET_ACCOUNT}):          {TARGET_HASH}")
    print(f"    Goal: Find X where MD5(X) = target")

    # Possible seeds related to ECSC
    potential_seeds = [
        YOUR_ACCOUNT,  # my account
        YOUR_ACCOUNT.lower(),  # my account lowercase
        hashlib.md5(YOUR_ACCOUNT.encode('utf-8')).hexdigest(),  # my account MD5
        hashlib.md5(YOUR_ACCOUNT.lower().encode('utf-8')).hexdigest(),  # my account lowercase MD5
        YOUR_SEED,  # my seed
        TARGET_ACCOUNT,  # ECSC account
        TARGET_ACCOUNT.lower(),  # ECSC account lowercase
        hashlib.md5(TARGET_ACCOUNT.encode('utf-8')).hexdigest(),  # ECSC account MD5
        hashlib.md5(TARGET_ACCOUNT.lower().encode('utf-8')).hexdigest(),  # ECSC account lowercase MD5
        TARGET_HASH,  # Target itself as seed
    ]

    # Test all potential seeds
    for seed in potential_seeds:
        print(f"\n[+] Testing seed: '{seed}'")
        x, pos = find_predecessor(TARGET_HASH, seed, max_iterations=2000)

        if x:
            print(f"    ✓ Found at position {pos}!")
            print(f"    Seed: {seed}")
            print(f"    X = {x}")

            # Verification
            computed = hash_function(x)
            print(f"\n[+] Verification")
            print(f"    MD5(X) = {computed}")
            print(f"    Target = {TARGET_HASH}")
            print(f"    Match: {computed == TARGET_HASH}")
            print(f"      Self-check: Verify the md5 hash running md5 command on your machine: $ echo -n '{x}' | md5")

            if computed == TARGET_HASH:
                print(f"\n    ✓✓✓ VERIFIED ✓✓✓")

            # Show chain context
            print(f"\n[+] Hash Chain Context:")
            print(f"    Seed: '{seed}'")
            print(f"    Position {pos}: {x} ← X (solution)")
            print(f"    Position {pos+1}: {computed} ← Target")

            # Final answer
            print(f"\n" + "="*80)
            print("SOLUTION")
            print("="*80)
            print(f"\nX = {x}\n")
            print("="*80)

            # Save to file
            import sys
            if '--save' in sys.argv:
                output_file = 'solution.txt'
                if sys.argv.index('--save') + 1 < len(sys.argv):
                    output_file = sys.argv[sys.argv.index('--save') + 1]
                with open(output_file, 'w') as f:
                    f.write(f"X = {x}\n")
                print(f"\n[+] Saved to: {output_file}")

            return x
        else:
            print(f"    ✗ Not found in this chain.")

if __name__ == "__main__":
    main()
