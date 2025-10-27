# Certificate Transparency — public key → subdomain

## Goal
Find the `cryptohack.org` subdomain whose TLS certificate uses the given RSA public key, then visit it to retrieve the flag.

---

## Command (produce SPKI DER and SHA‑256 with OpenSSL)
```bash
openssl pkey -pubin -in transparency.pem -outform DER | openssl dgst -sha256
```

### Output
```
SHA2-256(stdin)= 29ab37df0a4e4d252f0cf12ad854bede59038fdd9cd652cbc5c222edd26d77d2
```

## Search Certificate Transparency logs (crt.sh)
```
https://crt.sh/?spkisha256=<SHA256-sum>
```
[https://crt.sh/?spkisha256=29ab37df0a4e4d252f0cf12ad854bede59038fdd9cd652cbc5c222edd26d77d2](https://crt.sh/?spkisha256=29ab37df0a4e4d252f0cf12ad854bede59038fdd9cd652cbc5c222edd26d77d2
)

> [!NOTE]
> From the [`crt.sh`](https://crt.sh) entry we obtained crt.sh ID: `3347792120`
> 
> We can search `cryptohack.org` on [`crt.sh`](https://crt.sh) and look for that ID:
> [https://crt.sh/?q=cryptohack.org](https://crt.sh/?q=cryptohack.org)

### Result — matching subdomain
The certificate using that public key is for the subdomain:

[`thetransparencyflagishere.cryptohack.org`](thetransparencyflagishere.cryptohack.org)

## Flag
```crypto{thx_redpwn_for_inspiration}```
