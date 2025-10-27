from Crypto.PublicKey import RSA    # pip install pycryptodome

# Load the PEM file
pem = open("privacy_enhanced_mail.pem", "rb").read()
key = RSA.import_key(pem)

# Prints d as a decimal integer
print(key.d)

# Save d to a file (optional)
with open("d_decimal.txt", "w") as f:
    f.write(str(key.d))
