from pwn import xor

# Given:
ciphertext = '0e0b213f26041e480b26217f27342e175d0e070a3c5b103e2526217f27342e175d0e077e263451150104'

# We know the flag format is crypto{...}
# So we can XOR the start of the ciphertext with 'crypto{' to get the start of the key
key = xor(bytes.fromhex(ciphertext), 'crypto{'.encode())[:7].decode()
print(f'start of key: {key}') # looks like the key starts with ['myXORke'], We can guess the key is 'myXORkey'
key = 'myXORkey'
print(f'key: {key}') # complete the key

flag = xor(bytes.fromhex(ciphertext), key.encode()).decode()
print(f'flag: {flag}')
