// a. Chứa 1 thành phần liên thông, các phần từ đều được liên kết với 
nhau qua 0
// b. với mỗi union(0, x) sẽ chạy O(n) lần, -> với n - 1 lần union thì 
cần n(n-1)/2 ~ O(n^2) lần cập nhật mảng
//Mỗi union(0,k) gắn root(0) hiện tại làm con của k, tạo thành chuỗi 0→1→2→...→(n-1)
(một đường thẳng, không rút gọn đường đi).
+)find(0) cuối cùng phải đi qua toàn bộ chuỗi → Θ(n) lần truy cập mảng (khoảng n bước).
// d. Do 0 là root gốc của tất cả các val nên dừng ngay tại find(0)
chỉ sau 1 lần truy cập mảng