def gcd(a, b):
    return a if b == 0 else gcd(b, a % b)

a = 66528
b = 52920
print(gcd(a, b))
