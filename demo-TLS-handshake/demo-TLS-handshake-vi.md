## Thực hiện:
* Sử dụng tool: `Wireshark` - là phần mềm/tool sử dụng để bắt các gói mạng trực tiếp trên mạng tại thời gian thực và cho phép thực hiện phân tích các gói mạng. Sẽ sử dụng tool này để ghi lại và phân tích quá trình gửi qua lại của TLS Handshake.

  Nguồn: https://www.wireshark.org/download.html

* Trên app trình duyệt bất kỳ (ở đây là Google Chrome), truy cập vào một trang web với miền uy tín (VD: google.com, github.com, youtube.com,... )
* Trên Wireshark, phân tích khoảng thời gian của quá trình bắt tay giữa máy mình và server của web.

____
## DEMO: 
### 1. Mở phần mềm Wireshark và trình duyệt Chrome:

Trong Wireshark, chọn mục kiểu Wifi đang kết nối hiện tại. Ở đây là Ethernet:
[ẢNH]

Trên Chrome, sẽ thực hiện tra/tìm kiếm đến domain của trang web là: github.com

### 2. Kiểm tra địa chỉ kết nối của client-server qua terminal:

Máy client: **ipconfig**

[ẢNH]
```
IPv4: 192.168.1.4
```
Máy server: **nslookup github.com** 

[ẢNH]
```
IPv4: 20.205.243.166
```
### 3. Kiểm tra các gói mạng chứa quá trình bắt tay TLS giữa client-server:
Chọn lọc ra các gói mạng liên quan đến thực hiện bắt tay giữa 2 bên, ở mục filter điền: tcp

Quá trình bắt tay được thực hiện ở các gói với ID: No. 20, 34-56

**Phân tích:**

Quá trình bắt tay 3 bước của TCP: 

Trước khi quá trình TLS bắt đầu, máy chủ phải thực hiện kết nối đáng tin cậy đến server của Github. Thể hiện qua các gói: 20, 34, 35

* **Gói 20**: IP máy chủ (192.168.1.4) gửi [SYN] đến server Github (20.205.243.166) yêu cầu kết nối
* **Gói 34**: Github gửi lại với [SYN, ACK] chấp nhận kết nối
* **Gói 35**: Máy chủ gửi lại [ACK] xác nhận lại

Quá trình bắt tay của TLS

Khi kết nối TCP được mở, quá trình bắt tay xác thực bắt đầu. Ở đây, quá trình sử dụng phiên bản TLSv1.3 (chỉ có 3 quy trình chính):

* **Gói 36**: Máy chủ gửi Client Hello đến server, cùng với list các Cipher Suites hỗ trợ.
(thông tin nằm ở Info, có cả SNI=github.com - định danh tên server với Server Name Indication)
			
* **Gói 48**: Github phản hồi với Server Hello
Trong bản v1.3, gói này cũng bao gồm khóa chia sẻ của Server và gửi luôn cả Change Cipher Spec để chuyển sang giao tiếp có mã hóa.

Dữ liệu gửi từ Server gửi về được mã hóa: (Application data)

* **Gói 52**: Máy chủ gửi nốt Change Cipher Spec ngược lại để đáp, đồng thời bắt đầu trao đổi dữ liệu đã được mã hóa (Application Data)


Mã hóa dữ liệu ứng dụng:

Từ các **gói 51-55**, là thông tin dữ liệu của ứng dụng được mã hóa trong quá trình trao đổi giữa client-server



____

Nguồn tham khảo: 

* Wireshark: https://www.youtube.com/watch?v=aYp29r_uOcI,

* Lý thuyết: https://viblo.asia/p/tong-quan-ve-tls-13-nhanh-hon-va-bao-mat-hon-jvEla3LDKkw

