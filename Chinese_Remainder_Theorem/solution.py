# Given congruences
congruences = [
    (2, 5),
    (3, 11),
    (5, 17)
]

# Start with the largest modulus
a, p = max(congruences, key=lambda x: x[1])

for a_i, p_i in sorted(congruences, key=lambda x: -x[1])[1:]:
    # Solve a ≡ a_i mod p_i
    # Find k such that a + k*p ≡ a_i mod p_i
    k = ((a_i - a) * pow(p, -1, p_i)) % p_i
    a = a + k * p
    p *= p_i  # update modulus

print(a)
