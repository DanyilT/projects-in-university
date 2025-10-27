p = 1007621497415251

# Read ciphertext
with open("output.txt") as f:
    ciphertext = eval(f.read())

# Legendre symbol to recover bits
bits = ['1' if pow(c, (p-1)//2, p) == 1 else '0' for c in ciphertext]

# Convert bits to bytes
flag = bytes(int(''.join(bits[i:i+8]), 2) for i in range(0, len(bits), 8)).decode()

print(flag)
