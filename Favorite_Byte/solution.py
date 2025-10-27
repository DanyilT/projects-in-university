from pwn import xor

# Given:
ciphertext = '73626960647f6b206821204f21254f7d694f7624662065622127234f726927756d'

# Check every possible single-byte XOR key
for key in range(256):
    # XOR the ciphertext with the key
    plaintext = xor(bytes.fromhex(ciphertext), bytes([key]))
    # Check if the result is printable ASCII & and starts 'crypto{'
    if all(32 <= b < 127 for b in plaintext) and plaintext.startswith(b'crypto{'):
        print(f'key: {key}, plaintext: {plaintext.decode()}')
