#!/usr/bin/env python3
"""
Salt Finder for Hashcat
Creates test files to find the salt using Hashcat efficiently.

Since we don't know the salt, we'll:
1. Pick one user with likely weak password (pre-May 2019 = digits only)
2. Generate hash:salt combinations for all possible salts
3. Use Hashcat to test against digit passwords
4. Once we find ONE match, we know the salt!
"""

from datetime import datetime

# User database
users = [
    {"username": "Sparky", "hash": "c277243d2d39de474f3070d5c673ed492cea1b9e", "pass_modified": "2020-01-09", "policy": "alphanumeric"},
    {"username": "Mark123", "hash": "7a1d64ffa965a52b420570aa4f4c6aa450870fea", "pass_modified": "2019-06-03", "policy": "alphanumeric"},
    {"username": "superman", "hash": "3450fd71d9702d3a7b835a1536a9ad2650eff209", "pass_modified": "2019-10-01", "policy": "alphanumeric"},
    {"username": "security", "hash": "0f295b9e67f362f1be3cd7d0b30d4f4007f88a0e", "pass_modified": "2019-04-11", "policy": "digits_only"},
    {"username": "Tomtom", "hash": "d71b12c1eb8bf31ca6d19344e2504b0d2916635e", "pass_modified": "2018-01-03", "policy": "digits_only"},
    {"username": "JillC", "hash": "335bcd081c21b75a3866262fc45545c880786054", "pass_modified": "2019-12-20", "policy": "alphanumeric"},
]

def is_pre_may_2019(pass_modified):
    """Check if password policy is digits-only."""
    date = datetime.strptime(pass_modified, "%Y-%m-%d")
    cutoff = datetime(2019, 5, 1)
    return date < cutoff

def create_hashcat_files():
    """Create optimized files for Hashcat salt finding."""

    print("="*80)
    print("HASHCAT SALT FINDER - FILE GENERATOR")
    print("="*80)

    # Update policy based on date
    for user in users:
        if is_pre_may_2019(user['pass_modified']):
            user['policy'] = 'digits_only'
        else:
            user['policy'] = 'alphanumeric'
    print("\n[+] User Analysis:")
    for user in users:
        print(f"    {user['username']:12s} | Modified: {user['pass_modified']} | Policy: {user['policy']}")

    # Strategy: Focus on digits-only users first (easier to crack)
    digits_users = [u for u in users if u['policy'] == 'digits_only']
    print(f"\n[+] Digits-only users (easiest to crack): {len(digits_users)}")
    print("    We'll focus on these to find the salt!")

    # Pick the best target user (Tomtom - oldest password, likely weakest)
    target_user = next(u for u in users if u['username'] == 'Tomtom')
    print(f"\n[+] Target user for salt discovery: {target_user['username']}")
    print(f"    Hash: {target_user['hash']}")
    print(f"    Modified: {target_user['pass_modified']} (very old, likely weak)")

    # Create hash file with all possible salts for target user
    print("\n[+] Creating hash:salt file for all possible salts (00000-99999)...")
    hash_salt_file = f"hashcat_{target_user['username']}_all_salts.txt"
    with open(hash_salt_file, 'w') as f:
        for salt in range(100000):
            salt_str = f"{salt:05d}"
            f.write(f"{target_user['hash']}:{salt_str}\n")
    print(f"    Created: {hash_salt_file} (100,000 lines)")

    # Create separate files for each user (standard format)
    all_users_file = "hashcat_all_users.txt"
    with open(all_users_file, 'w') as f:
        for user in users:
            f.write(f"{user['hash']}:SALT_HERE\n")
    print(f"    Created: {all_users_file} (template)")

    print("\n" + "="*80)
    print("NEXT STEP: RUN THIS COMMAND")
    print("="*80)
    print(f"\nhashcat -m 120 -a 3 {hash_salt_file} '?d?d?d?d?d'\n")
    print("This will find the salt in ~1-5 minutes!")
    print(f"\nThen run: hashcat -m 120 {hash_salt_file} --show")
    print("="*80 + "\n")

if __name__ == "__main__":
    create_hashcat_files()
