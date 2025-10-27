from Crypto.PublicKey import RSA    # pip install pycryptodome

# Load the SSH RSA public key
pub = open("bruce_rsa.pub", "r").read()
key = RSA.import_key(pub)

# Prints n as a decimal integer
print(key.n)

# Save n to a file (optional)
with open("n_decimal.txt", "w") as f:
    f.write(str(key.n))
