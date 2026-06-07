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

![img](images/IBdemo-crypto-decrypt1.png)

![img](images/IBdemo-crypto-decrypt2.png)

`Decrypted message: admin:1780818471993`

reverse engineer the apk file with jadx:

![img](images/IBdemo-jadx1.png)

![img](images/IBdemo-crypto-jadx2.png)

![img](images/IBdemo-crypto-jadx.png)

### 4. IPC/Exported:

![img](images/IBdemo-ipc1.png)

![img](images/IBdemo-ipc2.png)

