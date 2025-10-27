def mod(a, m):
    return a % m

a, m1 = 11, 6
b, m2 = 8146798528947, 17

print(mod(a, m1) if mod(a, m1) < mod(b, m2) else mod(b, m2))
