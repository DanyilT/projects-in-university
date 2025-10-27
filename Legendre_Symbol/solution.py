# Get p and the list of integers from output.txt
with open("output.txt") as f:
    p = int(f.readline().split('=')[1])
    f.readline()  # skip the blank line
    ints = eval(f.readline().split('=')[1])

# Find which integer is a quadratic residue using Legendre Symbol
for a in ints:
    if pow(a, (p - 1) // 2, p) == 1:  # Legendre Symbol check
        r = pow(a, (p + 1) // 4, p)   # square root since p ≡ 3 mod 4
        print(max(r, p - r))          # larger root = flag
        break
