
## Get this website's IPs (and save in a file (`-o` param))
```bash
subfiner -d <website> -o <output.txt>
```
```bash
subfiner -d fisglobal.com -o fis_subs.txt
```
![command run](./screenshots/`subfiner%20-d%20fisglobal.com%20-o%20fis_subs.txt`.png)

## Check IPs in use
```bash
cat <file.txt> | httpx -sc -cl -title -location
```
```bash
cat fis_subs.txt | httpx -sc -cl -title -location
```
![command run](./screenshots/`cat%20fis_subs.txt%20|%20httpx%20-sc%20-cl%20-title%20-location`.png)

> [!NOTE]  
> Look for some suspicios hosts and try to find something useful


> [!TIP]  
> seclists (brut-force)