#!/usr/bin/env python3

"""
Mathematical Strong Pseudoprime Generator
Based on advanced number theory - uses Legendre symbols and CRT
Author: DanyilT
Date: 2025-10-26
"""

from Crypto.Util.number import *
import itertools
from tqdm import tqdm
from pwn import *
import json

context.log_level = 'info'

def main():
    log.info("="*60)
    log.info("Mathematical Strong Pseudoprime Generator")
    log.info("Author: DanyilT")
    log.info("Date: 2025-10-26")
    log.info("Challenge: CryptoHack - Prime and Prejudice")
    log.info("="*60 + "\n")

    log.info("Using advanced number theory (Legendre symbols + CRT)")
    log.info("This is MUCH faster than brute force!")
    log.info("-"*60 + "\n")

    # Generate pseudoprime
    n, factors = generate_pseudoprime()

    if n is None:
        log.error("Generation failed!")
        return

    # Save to file (if command line argument provided: --save)
    if '--save' in sys.argv:
        # If after --save there is a file name, use it; otherwise use default
        file_name = sys.argv[sys.argv.index('--save') + 1] if len(sys.argv) > sys.argv.index('--save') + 1 else 'my_mathematical_pseudoprime.txt'
        import time
        timestamp = time.strftime('%Y-%m-%d %H:%M:%S', time.gmtime())
        with open(file_name, 'w') as f:
            f.write(f"# Strong Pseudoprime - Mathematical Construction\n")
            f.write(f"# Author: DanyilT\n")
            f.write(f"# Date: {timestamp} UTC\n")
            f.write(f"# Method: Legendre symbols + Chinese Remainder Theorem\n\n")
            f.write(f"n = {n}\n")
            f.write(f"bits = {n.bit_length()}\n\n")
            f.write(f"# Prime factors:\n")
            for idx, fac in enumerate(factors):
                f.write(f"p{idx+1} = {fac}  # {fac.bit_length()} bits\n")
            f.write(f"\n# Verification: n = {' * '.join([f'p{i+1}' for i in range(len(factors))])}\n")

        log.success(f"Saved to {file_name}\n")
    log.info("-"*60 + "\n")

    # Solve challenge
    flag = solve_challenge(n, factors)

    if flag:
        log.success(f"{'='*60}")
        log.success(f"🎉 FLAG: {flag}")
        log.success(f"{'='*60}\n")

        # Save complete solution to file
        if '--save' in sys.argv:
            with open(file_name, 'a') as f:
                f.write(f"\n# Solution:\n")
                f.write(f"flag = '{flag}'\n")

            log.success("Complete solution saved!")
    else:
        log.error("Could not extract flag")


# Generate strong pseudoprime
def generate_pseudoprime():
    """Generate strong pseudoprime using mathematical construction"""

    log.info("Generating strong pseudoprime using number theory...")
    log.info("Step 1: Computing Legendre symbol constraints...")

    primes = generate_basis(64)
    log.info(f"Testing against {len(primes)} prime bases")

    # Build constraints using Legendre symbols
    fool = []
    h = 3  # Number of prime factors

    for p in primes:
        f = set()
        for i in generate_basis(200 * p)[1:]:
            if legendre(p, i) == i - 1:
                f.add(i % (4 * p))
        fool.append(list(f))

    log.info("Step 2: Computing CRT constraints...")

    # Choose constants for construction
    ks = [1, 998244353, 233]

    fool2 = []
    for idx, f in enumerate(fool):
        prime = primes[idx]
        m = prime * 4
        cur_set = set(f)

        for i in range(1, h):
            new_set = set()
            for ff in f:
                if ((ff + ks[i] - 1) * inverse(ks[i], m)) % 4 == 3:
                    new_set.add(((ff + ks[i] - 1) * inverse(ks[i], m)) % m)
            cur_set = cur_set.intersection(new_set)

        fool2.append(cur_set)

    # Count possible combinations
    total_combinations = 1
    for a in fool2:
        total_combinations *= len(a)

    log.info(f"Total combinations to test: {total_combinations:,}")
    log.info("Step 3: Searching for valid pseudoprime...")

    # Try each combination
    for tup in itertools.product(*fool2):
        residues = []
        modulos = []

        for i, t in enumerate(tup):
            residues.append(t)
            modulos.append(primes[i] * 4)

        residues.append(ks[1] - inverse(ks[2], ks[1]))
        modulos.append(ks[1])
        residues.append(ks[2] - inverse(ks[1], ks[2]))
        modulos.append(ks[2])

        # Solve using CRT
        sol, modul = crt_solve(residues, modulos)

        if sol == -1:
            continue

        # Search for prime starting from solution
        cur_t = 2**73 * modul + sol

        for i in tqdm(range(100000), desc="Testing candidates", leave=False):
            if isPrime(cur_t):
                # Build the pseudoprime
                facs = [cur_t]
                fin = cur_t

                for j in range(1, h):
                    factor = ks[j] * (cur_t - 1) + 1
                    facs.append(factor)
                    fin *= factor

                # Check if it passes Miller-Rabin
                if miller_rabin(fin, 64):
                    bits = fin.bit_length()

                    # Check bit length requirement
                    if 600 <= bits <= 900:
                        log.success(f"{'='*60}")
                        log.success(f"FOUND STRONG PSEUDOPRIME!")
                        log.success(f"{'='*60}")
                        log.info(f"n = {fin}")
                        log.info(f"Bits: {bits}")
                        log.info(f"Prime factors:")
                        for idx, fac in enumerate(facs):
                            log.info(f"  p{idx+1} = {fac} ({fac.bit_length()} bits)")

                        return fin, facs

            cur_t += modul

    return None, None


# Utility functions
def generate_basis(n):
    """Generate all primes < n using sieve"""
    basis = [True] * n
    for i in range(3, int(n**0.5)+1, 2):
        if basis[i]:
            basis[i*i::2*i] = [False]*((n-i*i-1)//(2*i)+1)
    return [2] + [i for i in range(3, n, 2) if basis[i]]

def legendre(a, p):
    """Legendre symbol (a/p)"""
    return pow(a, (p-1)//2, p)

def xgcd(a, b):
    """Extended GCD"""
    s, t, r = 0, 1, b
    s1, t1, r1 = 1, 0, a
    while r != 0:
        q = r1 // r
        r1, r = r, r1 - q * r
        s1, s = s, s1 - q * s
        t1, t = t, t1 - q * t
    return (r1, s1, t1)

def crt_solve(residues, modulos):
    """Chinese Remainder Theorem solver"""
    rm = list(zip(residues, modulos))
    cur_res, cur_mod = rm[0]

    for r, m in rm[1:]:
        g = GCD(cur_mod, m)

        if not r % g == cur_res % g:
            return -1, -1

        r1, s, t = xgcd(m//g, cur_mod//g)
        cur_res = cur_res * m//g * s + r * cur_mod//g * t
        cur_mod *= m//g
        cur_res %= cur_mod
    
    return cur_res, cur_mod

def miller_rabin(n, b):
    """Miller Rabin test with all prime bases < b"""
    basis = generate_basis(b)
    if n == 2 or n == 3:
        return True
    if n % 2 == 0:
        return False

    r, s = 0, n - 1
    while s % 2 == 0:
        r += 1
        s //= 2

    for b in basis:
        x = pow(b, s, n)
        if x == 1 or x == n - 1:
            continue
        for _ in range(r - 1):
            x = pow(x, 2, n)
            if x == n - 1:
                break
        else:
            return False
    return True


# Get flag from CryptoHack server
def solve_challenge(n, factors):
    """Solve the CryptoHack challenge"""

    # Submit to server
    log.info("="*60)
    log.info("Submitting to CryptoHack server...")
    log.info("="*60)

    conn = remote("socket.cryptohack.org", 13385)
    conn.sendline(json.dumps({
        "prime": n,
        "base": factors[0]
    }).encode())

    conn.readline()
    response = conn.readline().decode()

    log.info("="*60)
    log.info("SERVER RESPONSE:")
    log.info(response)
    log.info("="*60 + "\n")

    conn.close()

    # Extract flag
    if "flag:" in response:
        flag = json.loads(response)["Response"].split("flag: ")[1]
        return flag

    return None


if __name__ == "__main__":
    main()
