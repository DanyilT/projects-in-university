from pwn import xor

# Given:
key1 = 'a6c8b6733c9b22de7bc0253266a3867df55acde8635e19c73313'
key1_key2 = '37dcb292030faa90d07eec17e3b1c6d8daf94c35d4c9191a5e1e'
key2_key3 = 'c1545756687e7573db23aa1c3452a098b71a7fbf0fddddde5fc1'
flag_key1_key2_key3 = '04ee9855208a2cd59091d04767ae47963170d1660df7f56f5faf'

# Unknowns:
key2 = None
key3 = None
flag = None

# Steps to find the flag:
# 1. Find key2 using key1 and key1_key2
key2 = xor(bytes.fromhex(key1), bytes.fromhex(key1_key2)).hex()
print(f'key2: {key2}')

# 2. Find key3 using key2 and key2_key3
key3 = xor(bytes.fromhex(key2), bytes.fromhex(key2_key3)).hex()
print(f'key3: {key3}')

# 3. Find flag using key1, key2, key3
flag = xor(bytes.fromhex(key1), bytes.fromhex(key2), bytes.fromhex(key3), bytes.fromhex(flag_key1_key2_key3)).decode()
print(f'flag: {flag}')
