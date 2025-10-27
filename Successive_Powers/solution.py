from math import gcd
from functools import reduce
from Crypto.Util.number import inverse

powers = [588, 665, 216, 113, 642, 4, 836, 114, 851, 492, 819, 237]

# Compute determinants x[k]*x[k+2] - x[k+1]^2
determinants = [powers[i]*powers[i+2] - powers[i+1]**2 for i in range(len(powers)-2)]

# The prime p divides all determinants, so gcd gives p
p = abs(reduce(gcd, determinants))

# Compute x using first two powers
x = (powers[1] * inverse(powers[0], p)) % p

print(f'crypto{{{p},{x}}}')
