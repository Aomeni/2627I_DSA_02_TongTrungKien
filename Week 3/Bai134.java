import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Bai134 {

    // Phương thức kiểm tra chuỗi ngoặc có cân bằng hay không
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Nếu là ngoặc mở -> push vào stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // Nếu là ngoặc đóng
            else if (c == ')' || c == ']' || c == '}') {
                // Stack rỗng nghĩa là có ngoặc đóng nhưng không có ngoặc mở tương ứng
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Kiểm tra xem ngoặc đóng có khớp với ngoặc mở ở đỉnh stack không
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // Nếu duyệt xong mà stack trống -> cân bằng (true)
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Đọc toàn bộ chuỗi từ input chuẩn (StdIn)
        String s = StdIn.readAll().trim();
        
        // In ra true hoặc false
        StdOut.println(isBalanced(s));
    }
}