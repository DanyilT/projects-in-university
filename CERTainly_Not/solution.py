from Crypto.PublicKey import RSA    # pip install pycryptodome

# Load the DER-encoded RSA certificate
der = open("2048b-rsa-example-cert.der", "rb").read()
key = RSA.import_key(der)

# Prints n as a decimal integer
print(key.n)

# Save n to a file (optional)
with open("n_decimal.txt", "w") as f:
    f.write(str(key.n))
