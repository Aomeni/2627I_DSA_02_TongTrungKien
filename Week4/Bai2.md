# BÀI 2: KHẢO SÁT SELECTION SORT VÀ SO SÁNH VỚI INSERTION SORT

**Môn học:** Cấu trúc dữ liệu và Giải thuật (DSA)  
**Thư mục:** `Week4/`  
**Mã nguồn chương trình:** [`Bai2.java`](file:///c:/Users/admin/2627I_DSA_02_TongTrungKien/Week4/Bai2.java)

---

## 1. Yêu cầu bài toán

1. Cài đặt và khảo sát thuật toán **Selection Sort (Sắp xếp chọn)** trên cùng bộ dữ liệu thử nghiệm của Bài 1.
2. Đo thời gian thực thi của Selection Sort trên **5 loại dữ liệu**:
   - **(1) File dữ liệu test:** `1Kints.txt`, `2Kints.txt`, `4Kints.txt`, `8Kints.txt`, `16Kints.txt`, `32Kints.txt` (Trung bình $\ge 3$ lần chạy).
   - **(2) Dữ liệu sinh ngẫu nhiên (Random):** Mảng các số nguyên ngẫu nhiên (Trung bình $\ge 5$ lần chạy).
   - **(3) Dữ liệu đã sắp xếp xuôi (Sorted):** Mảng $0, 1, 2, \dots, N-1$ (Trung bình $\ge 3$ lần chạy).
   - **(4) Dữ liệu sắp xếp ngược (Reversely Sorted):** Mảng $N-1, N-2, \dots, 0$ (Trung bình $\ge 3$ lần chạy).
   - **(5) Dữ liệu toàn các giá trị bằng nhau (All Equal):** Mảng gồm $N$ phần tử bằng nhau (Trung bình $\ge 3$ lần chạy).
3. So sánh trực tiếp thời gian chạy giữa **Selection Sort** và **Insertion Sort** trên từng loại dữ liệu và kích thước dữ liệu $N \in \{1000, 2000, 4000, 8000, 16000, 32000, 64000\}$.
4. Đánh giá và nhận xét sự khác biệt giữa hai thuật toán dựa trên độ phức tạp lý thuyết và kết quả thực nghiệm.

---

## 2. Kết quả khảo sát thực nghiệm & So sánh trực tiếp

Tất cả các phép đo được thực hiện đồng thời trên cùng một mảng dữ liệu (sử dụng clone mảng) với đơn vị miligiây (ms).

### 2.1. Loại 1: Dữ liệu từ File Test (Đọc từ `algs4.In`) - Trung bình 3 lần chạy

| Tên File | Kích thước ($N$) | Selection Sort (ms) | Insertion Sort (ms) | Thuật toán nhanh hơn |
| :--- | :--- | :--- | :--- | :--- |
| `1Kints.txt` | 1,000 | 0.4499 ms | 1.1034 ms | **Selection Sort (2.45x)** |
| `2Kints.txt` | 2,000 | 1.7712 ms | 3.1181 ms | **Selection Sort (1.76x)** |
| `4Kints.txt` | 4,000 | 6.0395 ms | 1.8409 ms | **Insertion Sort (3.28x)** |
| `8Kints.txt` | 8,000 | 10.8859 ms | 6.5473 ms | **Insertion Sort (1.66x)** |
| `16Kints.txt` | 16,000 | 37.6637 ms | 23.2992 ms | **Insertion Sort (1.62x)** |
| `32Kints.txt` | 32,000 | 153.1051 ms | 107.8335 ms | **Insertion Sort (1.42x)** |

---

### 2.2. Loại 2: Dữ liệu Sinh Ngẫu Nhiên (Random) - Trung bình 5 lần chạy

| Kích thước ($N$) | Selection Sort (ms) | Insertion Sort (ms) | $T(2N)/T(N)$ Selection | Thuật toán nhanh hơn |
| :--- | :--- | :--- | :--- | :--- |
| 1,000 | 0.2530 ms | 0.1363 ms | - | **Insertion Sort (1.86x)** |
| 2,000 | 0.8738 ms | 0.5139 ms | 3.45x | **Insertion Sort (1.70x)** |
| 4,000 | 3.2614 ms | 1.8972 ms | 3.73x | **Insertion Sort (1.72x)** |
| 8,000 | 12.1290 ms | 7.3380 ms | 3.72x | **Insertion Sort (1.65x)** |
| 16,000 | 77.2016 ms | 41.4021 ms | 6.37x | **Insertion Sort (1.86x)** |
| 32,000 | 163.8785 ms | 95.6073 ms | 2.12x | **Insertion Sort (1.71x)** |
| 64,000 | 577.3380 ms | 387.8892 ms | 3.52x | **Insertion Sort (1.49x)** |

> **Nhận xét:** Trên dữ liệu ngẫu nhiên, **Insertion Sort luôn nhanh hơn Selection Sort khoảng 1.5 - 1.8 lần**. Lý do: Insertion Sort trung bình chỉ tốn $\sim N^2/4$ phép so sánh, trong khi Selection Sort luôn phải thực hiện $\sim N^2/2$ phép so sánh.

---

### 2.3. Loại 3: Dữ liệu Đã Sắp Xếp Xuôi (Best Case của Insertion Sort) - Trung bình 3 lần chạy

| Kích thước ($N$) | Selection Sort (ms) | Insertion Sort (ms) | $T(2N)/T(N)$ Selection | Thuật toán nhanh hơn |
| :--- | :--- | :--- | :--- | :--- |
| 1,000 | 0.1445 ms | 0.0005 ms | - | **Insertion Sort (270x)** |
| 2,000 | 0.5554 ms | 0.0009 ms | 3.84x | **Insertion Sort (640x)** |
| 4,000 | 2.2298 ms | 0.0019 ms | 4.01x | **Insertion Sort (1194x)** |
| 8,000 | 8.9082 ms | 0.0037 ms | 4.00x | **Insertion Sort (2429x)** |
| 16,000 | 36.7323 ms | 0.0071 ms | 4.12x | **Insertion Sort (5173x)** |
| 32,000 | 155.7297 ms | 0.0122 ms | 4.24x | **Insertion Sort (12729x)** |
| 64,000 | 561.3990 ms | 0.0253 ms | 3.60x | **Insertion Sort (22160x)** |

> **Nhận xét:** Khi dữ liệu đã được sắp xếp xuôi, **Insertion Sort nhanh vượt trội hơn Selection Sort tới hơn 22,000 lần** ở $N = 64,000$. Insertion Sort đạt $O(N)$ trong khi Selection Sort vẫn chịu độ phức tạp $O(N^2)$.

---

### 2.4. Loại 4: Dữ liệu Sắp Xếp Ngược (Worst Case của Insertion Sort) - Trung bình 3 lần chạy

| Kích thước ($N$) | Selection Sort (ms) | Insertion Sort (ms) | $T(2N)/T(N)$ Selection | Thuật toán nhanh hơn |
| :--- | :--- | :--- | :--- | :--- |
| 1,000 | 0.1542 ms | 0.1710 ms | - | **Selection Sort (1.11x)** |
| 2,000 | 0.5941 ms | 0.7513 ms | 3.85x | **Selection Sort (1.26x)** |
| 4,000 | 2.2926 ms | 2.9895 ms | 3.86x | **Selection Sort (1.30x)** |
| 8,000 | 9.1656 ms | 11.3303 ms | 4.00x | **Selection Sort (1.24x)** |
| 16,000 | 36.0961 ms | 44.9834 ms | 3.94x | **Selection Sort (1.25x)** |
| 32,000 | 144.4972 ms | 183.0148 ms | 4.00x | **Selection Sort (1.27x)** |
| 64,000 | 584.5088 ms | 750.6596 ms | 4.05x | **Selection Sort (1.28x)** |

> **Nhận xét:** Khi mảng bị sắp xếp ngược hoàn toàn, **Selection Sort lại nhanh hơn Insertion Sort khoảng 1.25 - 1.30 lần**. Lý do: Trong trường hợp này, Insertion Sort phải tốn $\sim N^2/2$ phép đổi chỗ (swaps), mỗi swap tốn 3 phép gán. Trong khi đó, Selection Sort chỉ tốn tối đa $N$ phép đổi chỗ.

---

### 2.5. Loại 5: Dữ liệu Toàn Giá Trị Bằng Nhau (All Equal) - Trung bình 3 lần chạy

| Kích thước ($N$) | Selection Sort (ms) | Insertion Sort (ms) | $T(2N)/T(N)$ Selection | Thuật toán nhanh hơn |
| :--- | :--- | :--- | :--- | :--- |
| 1,000 | 0.1401 ms | 0.0005 ms | - | **Insertion Sort (280x)** |
| 2,000 | 0.7722 ms | 0.0013 ms | 5.51x | **Insertion Sort (593x)** |
| 4,000 | 2.3420 ms | 0.0017 ms | 3.03x | **Insertion Sort (1377x)** |
| 8,000 | 8.4881 ms | 0.0035 ms | 3.62x | **Insertion Sort (2402x)** |
| 16,000 | 34.3895 ms | 0.0061 ms | 4.05x | **Insertion Sort (5606x)** |
| 32,000 | 138.1008 ms | 0.0123 ms | 4.02x | **Insertion Sort (11197x)** |
| 64,000 | 571.1545 ms | 0.0236 ms | 4.14x | **Insertion Sort (24235x)** |

> **Nhận xét:** Tương tự Best Case, trên dữ liệu có các phần tử bằng nhau, Insertion Sort đạt $O(N)$ và nhanh hơn Selection Sort hơn **24,000 lần**.

---

## 3. Phân tích & So sánh Lý thuyết vs Thực nghiệm

### 3.1. Bảng so sánh đặc tính lý thuyết

| Tiêu chí | Selection Sort (Sắp xếp chọn) | Insertion Sort (Sắp xếp chèn) |
| :--- | :--- | :--- |
| **Độ phức tạp Best Case** | $\Theta(N^2)$ | $O(N)$ |
| **Độ phức tạp Average Case** | $\Theta(N^2)$ | $O(N^2)$ |
| **Độ phức tạp Worst Case** | $\Theta(N^2)$ | $O(N^2)$ |
| **Số phép so sánh (Comparisons)** | Luôn $\frac{N(N-1)}{2} \approx \frac{N^2}{2}$ | Best: $N-1$<br>Average: $\sim \frac{N^2}{4}$<br>Worst: $\frac{N(N-1)}{2} \approx \frac{N^2}{2}$ |
| **Số phép đổi chỗ (Swaps)** | Tối đa $N-1$ (rất ít) | Best: $0$<br>Average: $\sim \frac{N^2}{4}$<br>Worst: $\frac{N(N-1)}{2}$ |
| **Tính nhạy cảm với dữ liệu** | **Không nhạy cảm** (Thời gian chạy như nhau trên mọi dạng dữ liệu) | **Rất nhạy cảm** (Tốc độ thay đổi cực lớn tùy vào độ sắp xếp của dữ liệu) |
| **Tính ổn định (Stable)** | Không ổn định (Unstable) | Ổn định (Stable) |

### 3.2. Điểm đặc trưng của Selection Sort chứng minh qua thực nghiệm

1. **Thời gian chạy không đổi giữa các loại dữ liệu:**
   - Với $N = 64,000$, thời gian chạy của Selection Sort ở cả 4 kịch bản (Random, Sorted, Reverse, All Equal) luôn giữ cố định ở khoảng **$560 \text{ ms} - 585 \text{ ms}$**.
   - Điều này thực nghiệm hóa kết luận lý thuyết: **Selection Sort có độ phức tạp $\Theta(N^2)$ trong TẤT CẢ các trường hợp**.
2. **Khi nào Selection Sort thắng Insertion Sort?**
   - Chỉ khi dữ liệu bị **sắp xếp ngược hoàn toàn (Worst Case của Insertion Sort)**, Selection Sort mới nhỉnh hơn khoảng $25 - 30\%$. Lý do là số phép swap của Selection Sort chỉ là $N$ lần, nhỏ hơn nhiều so với $\sim N^2/2$ lần swap của Insertion Sort.
3. **Khi nào Insertion Sort thắng Selection Sort?**
   - Trong **mọi trường hợp còn lại** (Random, Xuôi, All Equal, Partially Sorted), Insertion Sort luôn chiến thắng:
     - Trên mảng Random/File test: Nhanh hơn khoảng $1.5 \to 1.8$ lần (do số phép so sánh ít hơn một nửa).
     - Trên mảng Xuôi / Bằng nhau: Nhanh hơn đến **24,000 lần** (do đạt độ phức tạp $O(N)$).

---

## 4. Kết luận chung cho Bài 1 và Bài 2

- **Insertion Sort** thích hợp cho dữ liệu nhỏ hoặc dữ liệu đã gần như được sắp xếp (partially sorted data). Đây là thuật toán cơ sở được dùng trong các thuật toán lai hiện đại như Timsort hay IntroSort.
- **Selection Sort** chỉ có lợi thế duy nhất là số lần ghi bộ nhớ (swaps) tối thiểu ($\le N$), nhưng hiệu năng tổng thể yếu hơn Insertion Sort do không biết tận dụng cấu trúc có sẵn của dữ liệu đầu vào.
