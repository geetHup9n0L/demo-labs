Following the guide in Vulnerbility_Test_Guide.md inside `insecurebankdemo` folder.

## OWASP MASVS Vulnerability Test

### 1. Local Storage:

SharedPreferences:
![img](images/IBdemo-storage1.png)

### 2. Backup enabled:

![img](images/IBdemo-backup1.png)

![img](images/IBdemo-backup2.png)
`python3 -c "import zlib; f=open('backup.ab','rb'); f.seek(24); open('backup.tar','wb').write(zlib.decompress(f.read()))"`

![img](images/IBdemo-backup3.png)

![img](images/IBdemo-backup4.png)

![img](images/IBdemo-backup5.png)

![img](images/IBdemo-backup6.png)

### 3. Crypto:

`Decrypted message: admin:1780818471993`

### 4. IPC/Exported:


