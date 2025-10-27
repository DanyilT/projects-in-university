def tonelli_shanks(a, p):
    """Find a square root of a modulo prime p (Tonelli-Shanks)"""
    # Simple cases
    if pow(a, (p - 1) // 2, p) != 1:
        return None  # no solution
    if p % 4 == 3:
        r = pow(a, (p + 1) // 4, p)
        return r, p - r

    # Factor out powers of 2 from p-1
    q = p - 1
    s = 0
    while q % 2 == 0:
        q //= 2
        s += 1

    # Find a quadratic non-residue z
    z = 2
    while pow(z, (p - 1) // 2, p) != p - 1:
        z += 1

    # Initialize variables
    c = pow(z, q, p)
    r = pow(a, (q + 1) // 2, p)
    t = pow(a, q, p)
    m = s

    while t != 1:
        # Find smallest i such that t^(2^i) ≡ 1
        i = 1
        temp = pow(t, 2, p)
        while temp != 1:
            temp = pow(temp, 2, p)
            i += 1
        b = pow(c, 2 ** (m - i - 1), p)
        r = (r * b) % p
        t = (t * b * b) % p
        c = (b * b) % p
        m = i

    return r, p - r


# Read file
with open("output.txt") as f:
    a = int(f.readline().split('=')[1])
    p = int(f.readline().split('=')[1])

print(min(tonelli_shanks(a, p)))  # smaller root
