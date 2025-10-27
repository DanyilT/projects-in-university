from math import gcd

# data.txt: N = 14905.....\n e1 = 12886.....\n e2 = 12110.....\n c1 = 14010.....\n c2 = 14386.....
with open("data.txt") as f:
    N = int(f.readline().strip().split(' = ')[1])
    e1 = int(f.readline().strip().split(' = ')[1])
    e2 = int(f.readline().strip().split(' = ')[1])
    c1 = int(f.readline().strip().split(' = ')[1])
    c2 = int(f.readline().strip().split(' = ')[1])

# N=p*q
# c1=(a1*p+b1*q)^e1 mod N
# c1=(2*p+3*q)^e1 mod N
# c2=(a2*p+b2*q)^e2 mod N
# c2=(5*p+7*q)^e2 mod N

a1, b1 = 2, 3
a2, b2 = 5, 7

q = gcd(pow(a2,(-e2 * e1),N) * pow(c2, e1, N) - pow(a1, (-e1 * e2), N) * pow(c1, e2, N), N)
p = N // q  # do the same for p

print(f'crypto{{{p},{q}}}')
