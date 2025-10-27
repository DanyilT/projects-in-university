from pwn import xor
from PIL import Image

# Load the two images
lemur = Image.open('lemur.png')
flag = Image.open('flag.png')

# Perform XOR operation, and convert the result back to an image
flag.frombytes(data=xor(lemur.tobytes(), flag.tobytes()))
# Save the resulting image
flag.save('flag.png')
