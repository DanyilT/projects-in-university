#!/usr/bin/env python3
"""
Decryption tool for the intercepted message
Reverses the encryption steps from encryptme.py
"""

import sys
import string
from base64 import b64decode

def reverse_step1(s):
    """Reverse step1: Same transformation (it's symmetric)"""
    _step1 = str.maketrans("zyxwvutsrqponZYXWVUTSRQPONmlkjihgfedcbaMLKJIHGFEDCBA", "mlkjihgfedcbaMLKJIHGFEDCBAzyxwvutsrqponZYXWVUTSRQPON")
    return s.translate(_step1)

def reverse_step2(s):
    """Reverse step2: Base64 decode"""
    return b64decode(s).decode('utf-8', errors='ignore')

def reverse_step3(ciphertext, shift=4):
    """Reverse step3: Caesar cipher shift back by 4"""
    loweralpha = string.ascii_lowercase
    # To reverse shift of 4, shift back by 4 (same as forward by 22)
    shifted_string = loweralpha[-shift:] + loweralpha[:-shift]
    converted = str.maketrans(loweralpha, shifted_string)
    return ciphertext.translate(converted)

def decrypt_message(encrypted):
    """Decrypt the intercepted message by reversing the steps"""
    print("="*80)
    print("DECRYPTING INTERCEPTED MESSAGE")
    print("="*80)

    current = encrypted.strip()
    step_count = 0

    print(f"\n[+] Original encrypted message:")
    print(f"    Length: {len(current)} characters")
    print(f"    First 100 chars: {current[:100]}...")

    print("\n[+] Decryption steps:")

    # Keep removing steps until we hit '2' at start
    while current and current[0] in '123':
        step_num = current[0]
        current = current[1:]  # Remove step number
        step_count += 1

        print(f"\n    Step {step_count}: Reversing step{step_num}")
        print(f"    Length before: {len(current)}")

        # Apply appropriate reverse transformation
        if step_num == '1':
            current = reverse_step1(current)
        elif step_num == '2':
            current = reverse_step2(current)
        elif step_num == '3':
            current = reverse_step3(current)

        print(f"    Length after: {len(current)}")
        print(f"    Preview: {current[:80]} {'...' if len(current) > 80 else ''}")

    # If there is no '123' prefix, assume already decoded
    print(f"\n" + "="*80)
    print("DECRYPTED MESSAGE - SUCCESS!")
    print("="*80)
    print(f"\n{current}\n")
    print("="*80)
    return current

def main():
    print("="*80)
    print("ENCRYPTED EVIDENCE DECODER")
    print("="*80)

    # Read intercepted message
    try:
        input_file = "intercepted.txt"
        if sys.argv[1:]:
            input_file = sys.argv[1]

        with open(input_file, 'r') as f:
            encrypted = f.read().strip()
        print(f"\n[+] Loaded {input_file}")
        print(f"    Size: {len(encrypted)} bytes")

        # Decrypt
        result = decrypt_message(encrypted)

        if result:
            out_file = 'decrypted.txt'
            if '-o' in sys.argv and sys.argv.index('-o') + 1 < len(sys.argv):
                out_file = sys.argv[sys.argv.index('-o') + 1]

            # Save result
            with open(out_file, 'w') as f:
                f.write(result)
            print(f"\n[+] Decrypted message saved to: {out_file}")

            if '-d' in sys.argv:
                decoded_out_file = 'decoded_evidence.txt'
                if sys.argv.index('-d') + 1 < len(sys.argv):
                    decoded_out_file = sys.argv[sys.argv.index('-d') + 1]

                # Also create decoded file
                with open(decoded_out_file, 'w') as f:
                    f.write("="*80 + "\n")
                    f.write("DECODED EVIDENCE - Encrypted Evidence Challenge\n")
                    f.write("="*80 + "\n\n")
                    f.write("DECRYPTED MESSAGE:\n")
                    f.write("-"*80 + "\n")
                    f.write(result + "\n")
                    f.write("-"*80 + "\n")
                print(f"[+] Decoded file saved to: {decoded_out_file}")

    except FileNotFoundError:
        print(f"\n[!] Error: {input_file} not found")
        return
    except Exception as e:
        print(f"\n[!] Error: {e}")
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    main()
