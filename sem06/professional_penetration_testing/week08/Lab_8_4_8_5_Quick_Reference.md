# Lab 8.4 & 8.5: Quick Command Reference

## Section 8.4: SAM/Windows Password Extraction & Cracking

### Extract Hashes from SAM + SYSTEM Files
```bash
# Basic extraction
samdump2 SYSTEM SAM > sam_dump.txt

# View the dump
cat sam_dump.txt

# Extract only NTLM hashes (skip disabled accounts)
grep -v "aad3b435b51404eeaad3b435b51404ee:aad3b435b51404eeaad3b435b51404ee" \
  sam_dump.txt | cut -d: -f1,4 > ntlm_hashes.txt

# Format: username:hash
cat ntlm_hashes.txt
```

### Crack LM Hashes (Legacy - Very Fast)
```bash
# Method 1: John the Ripper
john --format=lm lm_hashes.txt
john --show lm_hashes.txt

# Method 2: Online (instant)
# Visit https://crackstation.net/ and paste hash
```

### Crack NTLM Hashes with John
```bash
# Prepare hashes (format: username:hash)
john --format=nt ntlm_hashes.txt --wordlist=/usr/share/wordlists/rockyou.txt

# Using different wordlist
john --format=nt ntlm_hashes.txt --wordlist=/path/to/custom/wordlist.txt

# Incremental mode (no wordlist - brute force)
john --format=nt ntlm_hashes.txt --incremental

# View cracked passwords
john --show ntlm_hashes.txt

# Check only specific user
john --show --users=Administrator ntlm_hashes.txt

# Verify a specific hash
echo "Administrator:8846f7eaee8fb117ad06bdd830b7586c" | \
  john --format=nt --wordlist=/usr/share/wordlists/rockyou.txt -
```

### Common NTLM Test Hashes (for practice)
```bash
# Create a test file
cat > test_ntlm.txt << 'EOF'
TestUser:31d6cfe0d16ae931b73c59d7e0c089c0
Admin:5f4dcc3b5aa765d61d8327deb882cf99
Guest:209c6174da490caeb422f3fa5a7ae634
EOF

# Crack them
john --format=nt test_ntlm.txt --wordlist=/usr/share/wordlists/rockyou.txt

# These should resolve to:
# TestUser: (empty password)
# Admin: password
# Guest: admin
```

---

## Section 8.5: Hashcat Fundamentals

### Installation & Verification
```bash
# Check if installed
hashcat --version

# Check hash type support
hashcat --help | grep -i "ntlm"
# Should show: NTLM | 1000

# Check GPU devices (if applicable)
hashcat --query=device
```

### Basic Hashcat Syntax
```bash
# Universal formula
hashcat -m [hash_type] -a [attack_mode] [hashfile] [wordlist/mask]

# For NTLM (hash type = 1000)
# Attack mode: 0 = wordlist, 3 = brute force mask, 6 = hybrid
```

---

## NTLM Cracking with Hashcat

### Prepare Hashes
```bash
# Option 1: Just hashes (one per line)
cat > hashes.txt << 'EOF'
8846f7eaee8fb117ad06bdd830b7586c
5f4dcc3b5aa765d61d8327deb882cf99
31d6cfe0d16ae931b73c59d7e0c089c0
EOF

# Option 2: With usernames (hashcat ignores usernames)
cat > hashes.txt << 'EOF'
Administrator:8846f7eaee8fb117ad06bdd830b7586c
User1:5f4dcc3b5aa765d61d8327deb882cf99
TestUser:31d6cfe0d16ae931b73c59d7e0c089c0
EOF
```

### Attack 1: Wordlist (Dictionary) Attack
```bash
# Basic wordlist attack
hashcat -m 1000 -a 0 hashes.txt /usr/share/wordlists/rockyou.txt

# With username display
hashcat -m 1000 -a 0 hashes.txt /usr/share/wordlists/rockyou.txt --username

# Show results
hashcat -m 1000 hashes.txt --show

# Show results with usernames
hashcat -m 1000 hashes.txt --show --username
```

### Attack 2: Brute Force (Mask Attack)
```bash
# 6-character lowercase: aaaaaa to zzzzzz
hashcat -m 1000 -a 3 hashes.txt ?l?l?l?l?l?l

# 8-character: lowercase + numbers (e.g., password0, test1234)
hashcat -m 1000 -a 3 hashes.txt ?l?l?l?l?l?l?l?l

# 4-character: uppercase, lowercase, numbers (e.g., Pas5)
hashcat -m 1000 -a 3 hashes.txt ?u?l?l?d

# All printable characters, 6 chars (SLOW but comprehensive)
hashcat -m 1000 -a 3 hashes.txt ?a?a?a?a?a?a

# Pattern: number-word-number (e.g., 5-password-2)
hashcat -m 1000 -a 3 hashes.txt ?d-?l?l?l?l?l?l-?d
```

### Attack 3: Hybrid (Wordlist + Mask)
```bash
# Dictionary + 2 digits suffix (e.g., password00, test99)
hashcat -m 1000 -a 6 hashes.txt /usr/share/wordlists/rockyou.txt ?d?d

# Dictionary + special character (e.g., password!, test#)
hashcat -m 1000 -a 6 hashes.txt /usr/share/wordlists/rockyou.txt ?s

# Prefix + dictionary (mask prepended)
# -a 7 = mask + wordlist
hashcat -m 1000 -a 7 hashes.txt ?d?d /usr/share/wordlists/rockyou.txt
```

### Attack 4: Wordlist + Rules
```bash
# Apply transformations (capitalize, special chars, etc.)
hashcat -m 1000 -a 0 hashes.txt /usr/share/wordlists/rockyou.txt \
  -r /usr/share/hashcat/rules/best64.rule

# Multiple rules
hashcat -m 1000 -a 0 hashes.txt /usr/share/wordlists/rockyou.txt \
  -r /usr/share/hashcat/rules/best64.rule \
  -r /usr/share/hashcat/rules/toggles1.rule

# List available rules
ls /usr/share/hashcat/rules/

# Common rules:
# best64.rule - Best 64 rules
# toggles1.rule - Toggle cases
# d3ad0001.rule - Dean Rules
```

---

## Hashcat Mask Patterns Reference

```
?l = lowercase letters [a-z]
?u = uppercase letters [A-Z]
?d = digits [0-9]
?s = special chars [!@#$%^&*()...]
?a = all printable [0-9a-zA-Z!@#$...]
?h = lowercase hex [0-9a-f]
?H = uppercase hex [0-9A-F]
?x = combined hex [0-9a-fA-F]

Examples:
?l?l?l?l         = 4-char lowercase (aaaa to zzzz)
?u?l?l?l         = 4-char (Aaaa to Zzzz)
?d?d?d?d         = 4-digit number (0000 to 9999)
?l?l?l?d?d       = 5-char (aaa00 to zzz99)
Passw?d          = Literal "Passw" + any digit (Passw0 to Passw9)
?a?a?a?a?a?a     = 6-char all printable (very slow!)
```

---

## Performance & Progress Monitoring

### Monitor Active Session
```bash
# Shows speed, progress, ETA
hashcat -m 1000 -a 0 hashes.txt rockyou.txt --status

# Benchmark your system
hashcat -m 1000 -a 3 --benchmark

# Benchmark with mask
hashcat -m 1000 -a 3 ?l?l?l?l --benchmark
```

### Control Execution
```bash
# Interactive controls during hashcat run:
# [s] = show status
# [p] = pause
# [r] = resume
# [c] = check output
# [q] = quit

# Resume interrupted session
hashcat --restore

# Clear session
hashcat --flush
```

### Workload Profiles (Performance Tuning)
```bash
# -w option controls GPU usage:
# 1 = low power (laptop mode)
# 2 = default
# 3 = high performance
# 4 = nightmare (max speed, 100% usage)

hashcat -m 1000 -a 0 -w 4 hashes.txt rockyou.txt
```

---

## From SAM to Crack (Complete Workflow)

```bash
# Step 1: Extract hashes from SAM/SYSTEM
samdump2 SYSTEM SAM > sam_dump.txt

# Step 2: Parse out NTLM hashes
grep -v "aad3b435b51404eeaad3b435b51404ee:aad3b435b51404eeaad3b435b51404ee" \
  sam_dump.txt | cut -d: -f1,4 > ntlm.txt

# Step 3: Crack with Hashcat (wordlist)
hashcat -m 1000 -a 0 ntlm.txt /usr/share/wordlists/rockyou.txt --username

# Step 4: View results
hashcat -m 1000 ntlm.txt --show --username

# Step 5: Export to file for documentation
hashcat -m 1000 ntlm.txt --show --username > CRACKED_PASSWORDS.txt
```

---

## Troubleshooting

| Problem | Solution |
|---------|----------|
| `Hashcat: No hashes loaded` | Check format: one per line, no extra spaces |
| `Hash type 1000 not supported` | Reinstall: `sudo apt-get install --reinstall hashcat` |
| `Permission denied` | Run as sudo or check user in /etc/groups |
| Very slow cracking | Use GPU (`hashcat -d 1`), try smaller mask, reduce workload |
| Out of memory | Reduce workload: `-w 1` or use CPU instead |
| Unsure of hash format? | `hashcat --identify hashes.txt` (newer versions) |

---

## Expected Results for Test Hashes

```
Hash: 31d6cfe0d16ae931b73c59d7e0c089c0  →  (empty password)
Hash: 5f4dcc3b5aa765d61d8327deb882cf99  →  password
Hash: 209c6174da490caeb422f3fa5a7ae634  →  admin
Hash: a0ecde5c5e7fd5ed9bedb27d88f0f06a  →  P@ssw0rd
Hash: 4f81f1769ca0d6c1d8f3f1f8e5c2b1a9  →  SecurePass123 (harder to crack)
```

---

## Lab Submission Checklist

- [ ] SAM hashes successfully extracted with samdump2
- [ ] Identified admin account RID (should be 500)
- [ ] Cracked at least 3 NTLM hashes with John
- [ ] Documented which wordlist worked best
- [ ] Compared John vs Hashcat execution times
- [ ] Successfully cracked same hashes with Hashcat
- [ ] Noted speed differences (Hashcat should be faster)
- [ ] Attempted mask-based brute force with Hashcat
- [ ] Document any lessons learned about password strength

---
