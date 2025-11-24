**Encrypted Evidence**  
It looks like your services have been called upon again to decode some encrypted messages that the Garda believe may be relevant to an ongoing investigation. They intercepted what appears to be an encrypted message, sent from a suspect’s machine just before the computer was seized.

Some files were partially damaged or lost, but the forensics team recovered parts of the code they think was used to encrypt the message. Unfortunately, the recovered program appears to be an encryption routine (which understandably worries the forensics team), so they’ve asked for your help to determine whether the intercepted output can be decrypted.

**Useful information provided by the Garda:**
- They supplied a copy of the suspected encryption program and a copy of the intercepted ciphertext.
- The program appears to be written in Python, so you will need to analyse the code to understand how the message was produced.
- Parts of the original program are damaged or missing; you may need to repair or infer the missing sections.
- On Kali you can run the code with the command: python encryptme.py.
- The Garda’s priority is recovering the decoded message; they do not require a specific method — you may write your own code, work manually, or use any other reasonable technique.
