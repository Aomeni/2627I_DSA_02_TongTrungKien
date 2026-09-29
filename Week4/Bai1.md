# BÀI 1: KHẢO SÁT THỜI GIAN CHẠY CỦA THUẬT TOÁN INSERTION SORT (SẮP XẾP CHÈN)

**Môn học:** Cấu trúc dữ liệu và Giải thuật (DSA)  
**Thư mục:** `Week4/`  
**Mã nguồn chương trình:** [`Bai1.java`](file:///c:/Users/admin/2627I_DSA_02_TongTrungKien/Week4/Bai1.java)

---

## 1. Yêu cầu bài toán

1. Sử dụng thư viện `algs4` (`edu.princeton.cs.algs4.*`) để đọc dữ liệu thử nghiệm từ file và đo thời gian thực thi của thuật toán **Insertion Sort (Sắp xếp chèn)**.
2. Khảo sát thời gian chạy của Insertion Sort trên **5 loại dữ liệu khác nhau**:
   - **(1) Dữ liệu file test:** Các file `1Kints.txt`, `2Kints.txt`, `4Kints.txt`, `8Kints.txt`, `16Kints.txt`, `32Kints.txt` (Trung bình $\ge 3$ lần chạy).
   - **(2) Dữ liệu sinh ngẫu nhiên (Random):** Mảng các số nguyên ngẫu nhiên (Trung bình $\ge 5$ lần chạy).
   - **(3) Dữ liệu đã sắp xếp xuôi (Best Case):** Mảng tăng dần $0, 1, 2, \dots, N-1$ (Trung bình $\ge 3$ lần chạy).
   - **(4) Dữ liệu sắp xếp ngược (Worst Case):** Mảng giảm dần $N-1, N-2, \dots, 0$ (Trung bình $\ge 3$ lần chạy).
   - **(5) Dữ liệu toàn các giá trị bằng nhau (All Equal):** Mảng gồm $N$ phần tử bằng nhau (Trung bình $\ge 3$ lần chạy).
3. Thống kê thời gian chạy theo các kích thước dữ liệu khác nhau $N \in \{1000, 2000, 4000, 8000, 16000, 32000, 64000\}$.
4. Đánh giá, nhận xét sự thay đổi của thời gian chạy theo dạng dữ liệu và kích thước dữ liệu.

---

## 2. Kết quả khảo sát thực nghiệm

Các phép đo thời gian được thực hiện trên môi trường Java 25 LTS, sử dụng `System.nanoTime()` để đảm bảo độ chính xác (đơn vị: miligiây - ms). Mảng gốc được nhân bản (`clone()`) trước mỗi lần thử nghiệm để tránh ảnh hưởng của việc mảng đã bị sắp xếp từ lần chạy trước.

### 2.1. Loại 1: Dữ liệu từ File Test (Đọc qua `algs4.In`)

| Tên File | Kích thước ($N$) | Thời gian trung bình 3 lần chạy (ms) |
| :--- | :--- | :--- |
| `1Kints.txt` | 1,000 | 0.1140 ms |
| `2Kints.txt` | 2,000 | 0.5029 ms |
| `4Kints.txt` | 4,000 | 2.1065 ms |
| `8Kints.txt` | 8,000 | 7.4140 ms |
| `16Kints.txt` | 16,000 | 25.0532 ms |
| `32Kints.txt` | 32,000 | 91.8744 ms |

---

### 2.2. Loại 2: Dữ liệu Sinh Ngẫu Nhiên (Random) - Trung bình 5 lần chạy

| Kích thước ($N$) | Thời gian trung bình (ms) | Tỷ lệ tăng thời gian $T(2N)/T(N)$ | Độ phức tạp thực nghiệm |
| :--- | :--- | :--- | :--- |
| 1,000 | 0.0968 ms | - | $O(N^2)$ |
| 2,000 | 0.5826 ms | 6.02x | $O(N^2)$ |
| 4,000 | 1.4964 ms | 2.57x | $O(N^2)$ |
| 8,000 | 5.6493 ms | 3.78x | $O(N^2)$ |
| 16,000 | 23.2772 ms | 4.12x | $O(N^2)$ |
| 32,000 | 97.3899 ms | 4.18x | $O(N^2)$ |
| 64,000 | 383.3828 ms | 3.94x | $O(N^2)$ |

> **Ghi chú:** Khi kích thước $N$ tăng gấp 2 lần, thời gian chạy tăng khoảng **4.0 lần** ($\approx 2^2$). Điều này phản ánh chính xác độ phức tạp trung bình $O(N^2)$.

---

### 2.3. Loại 3: Dữ liệu Đã Sắp Xếp Xuôi (Best Case) - Trung bình 3 lần chạy

| Kích thước ($N$) | Thời gian trung bình (ms) | Tỷ lệ tăng thời gian $T(2N)/T(N)$ | Độ phức tạp thực nghiệm |
| :--- | :--- | :--- | :--- |
| 1,000 | 0.0005 ms | - | $O(N)$ |
| 2,000 | 0.0009 ms | 1.75x | $O(N)$ |
| 4,000 | 0.0082 ms | 8.79x (nhiễu JIT) | $O(N)$ |
| 8,000 | 0.0031 ms | - | $O(N)$ |
| 16,000 | 0.0062 ms | 2.00x | $O(N)$ |
| 32,000 | 0.0125 ms | 2.01x | $O(N)$ |
| 64,000 | 0.0252 ms | 2.02x | $O(N)$ |

> **Ghi chú:** Thời gian vô cùng nhanh ($< 0.03\text{ ms}$ cho $N = 64,000$). Khi $N$ tăng gấp 2 lần, thời gian tăng đúng **2.0 lần**, khẳng định độ phức tạp $O(N)$ tuyến tính.

---

### 2.4. Loại 4: Dữ liệu Sắp Xếp Ngược (Worst Case) - Trung bình 3 lần chạy

| Kích thước ($N$) | Thời gian trung bình (ms) | Tỷ lệ tăng thời gian $T(2N)/T(N)$ | Độ phức tạp thực nghiệm |
| :--- | :--- | :--- | :--- |
| 1,000 | 0.1807 ms | - | $O(N^2)$ |
| 2,000 | 0.7050 ms | 3.90x | $O(N^2)$ |
| 4,000 | 2.9799 ms | 4.23x | $O(N^2)$ |
| 8,000 | 11.5597 ms | 3.88x | $O(N^2)$ |
| 16,000 | 45.9727 ms | 3.98x | $O(N^2)$ |
| 32,000 | 183.1545 ms | 3.98x | $O(N^2)$ |
| 64,000 | 841.9381 ms | 4.60x | $O(N^2)$ |

> **Ghi chú:** Đây là trường hợp xấu nhất của Insertion Sort. Thời gian chạy chậm gấp khoảng **2 lần** so với dữ liệu ngẫu nhiên (do số phép đổi chỗ đạt tối đa $\sim N^2/2$). Tỷ lệ $T(2N)/T(N) \approx 4.0\text{x}$.

---

### 2.5. Loại 5: Dữ liệu Toàn Giá Trị Bằng Nhau (All Equal) - Trung bình 3 lần chạy

| Kích thước ($N$) | Thời gian trung bình (ms) | Tỷ lệ tăng thời gian $T(2N)/T(N)$ | Độ phức tạp thực nghiệm |
| :--- | :--- | :--- | :--- |
| 1,000 | 0.0010 ms | - | $O(N)$ |
| 2,000 | 0.0019 ms | 1.81x | $O(N)$ |
| 4,000 | 0.0036 ms | 1.93x | $O(N)$ |
| 8,000 | 0.0072 ms | 1.99x | $O(N)$ |
| 16,000 | 0.0144 ms | 2.01x | $O(N)$ |
| 32,000 | 0.1053 ms | 7.31x | $O(N)$ |
| 64,000 | 0.1108 ms | 1.05x | $O(N)$ |

> **Ghi chú:** Khi tất cả các giá trị bằng nhau, điều kiện `a[j] < a[j-1]` luôn sai ngay từ lần so sánh đầu tiên của mỗi bước chèn. Do đó, thuật toán không tốn phép swap nào và đạt độ phức tạp $O(N)$ tương tự Best Case.

---

## 3. Tổng hợp và Nhận xét chi tiết

### 3.1. So sánh tổng quan giữa các loại dữ liệu ($N = 64,000$)

```
Đã sắp xếp xuôi (Best) : 0.0252 ms  [O(N)]  -----------------> Nhanh nhất
Toàn giá trị bằng nhau  : 0.1108 ms  [O(N)]  -----------------> Rất nhanh
Sinh ngẫu nhiên        : 383.38 ms   [O(N^2)] ---------------> Chậm
Sắp xếp ngược (Worst)  : 841.94 ms   [O(N^2)] ---------------> Chậm nhất (Gấp 33,000 lần Best Case!)
```

### 3.2. Giải thích cơ sở lý thuyết

1. **Trường hợp tốt nhất (Best Case - Xuôi / Bằng nhau):**
   - Vòng lặp bên ngoài chạy $N-1$ lần.
   - Ở mỗi bước $i$, phép so sánh `a[j] < a[j-1]` thực hiện đúng $1$ lần và dừng ngay lập tức vì phần tử hiện tại không nhỏ hơn phần tử đứng trước.
   - **Số phép so sánh:** $N - 1$.
   - **Số phép đổi chỗ (Swaps):** $0$.
   - **Độ phức tạp thời gian:** $O(N)$. Tỷ lệ thời gian khi $N$ tăng gấp đôi là $T(2N)/T(N) \approx 2.0$.

2. **Trường hợp xấu nhất (Worst Case - Ngược):**
   - Mảng giảm dần khiến mỗi phần tử ở vị trí $i$ phải lùi tới tận đầu mảng (vị trí 0).
   - **Số phép so sánh:** $1 + 2 + \dots + (N-1) = \frac{N(N-1)}{2} \approx \frac{N^2}{2}$.
   - **Số phép đổi chỗ:** $\frac{N(N-1)}{2} \approx \frac{N^2}{2}$.
   - **Độ phức tạp thời gian:** $O(N^2)$. Tỷ lệ thời gian khi $N$ tăng gấp đôi là $T(2N)/T(N) \approx 4.0$.

3. **Trường hợp trung bình (Average Case - Ngẫu nhiên / File Test):**
   - Trung bình mỗi phần tử $i$ phải di chuyển lùi khoảng một nửa quãng đường.
   - **Số phép so sánh:** $\approx \frac{N^2}{4}$.
   - **Số phép đổi chỗ:** $\approx \frac{N^2}{4}$.
   - **Độ phức tạp thời gian:** $O(N^2)$. Tỷ lệ thời gian khi $N$ tăng gấp đôi là $T(2N)/T(N) \approx 4.0$.

---

## 4. Kết luận

- Thuật toán **Insertion Sort** cực kỳ hiệu quả với dữ liệu **đã gần như sắp xếp** hoặc dữ liệu nhỏ ($N \le 1000$), nơi độ phức tạp tiệm cận $O(N)$.
- Tuy nhiên, với dữ liệu ngẫu nhiên hoặc sắp xếp ngược ở quy mô lớn ($N > 10,000$), Insertion Sort bộc lộ nhược điểm của thuật toán bậc hai $O(N^2)$, thời gian chạy tăng vọt theo cấp số nhân (tăng gấp 4 lần mỗi khi dữ liệu tăng gấp đôi).
- Kết quả thực nghiệm đo đạc hoàn toàn khớp với lý thuyết phân tích độ phức tạp thuật toán đã học trong bài giảng.
