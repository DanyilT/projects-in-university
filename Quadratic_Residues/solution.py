p = 29
ints = [14, 6, 11]

print(min([a for a in range(p) if (a * a) % p in ints]))
