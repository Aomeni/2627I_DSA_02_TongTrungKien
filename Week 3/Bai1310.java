import java.util.Scanner;
import java.util.Stack;

public class Bai1310 {

    /**
     * Chuyển đổi biểu thức trung tố (Infix) thành hậu tố (Postfix)
     * @param infix Chuỗi chứa biểu thức trung tố (các phần tử cách nhau bởi khoảng trắng)
     * @return Chuỗi biểu thức hậu tố
     */
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<String> ops = new Stack<>();
        
        // Tách biểu thức thành các token bằng khoảng trắng
        String[] tokens = infix.trim().split("\\s+");

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            // 1. Nếu là toán hạng (số hoặc biến), đưa trực tiếp vào kết quả
            if (isOperand(token)) {
                postfix.append(token).append(" ");
            } 
            // 2. Nếu là dấu mở ngoặc '(', đưa vào stack
            else if (token.equals("(")) {
                ops.push(token);
            } 
            // 3. Nếu là dấu đóng ngoặc ')', lấy các toán tử ra khỏi stack cho đến khi gặp '('
            else if (token.equals(")")) {
                while (!ops.isEmpty() && !ops.peek().equals("(")) {
                    postfix.append(ops.pop()).append(" ");
                }
                if (!ops.isEmpty() && ops.peek().equals("(")) {
                    ops.pop(); // Loại bỏ dấu '('
                }
            } 
            // 4. Nếu là toán tử (+, -, *, /, ^)
            else if (isOperator(token)) {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(token)) {
                    postfix.append(ops.pop()).append(" ");
                }
                ops.push(token);
            }
        }

        // Lấy tất cả toán tử còn lại trong stack đưa vào kết quả
        while (!ops.isEmpty()) {
            postfix.append(ops.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    // Kiểm tra xem token có phải là toán tử không
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
    }

    // Kiểm tra xem token có phải là toán hạng không (không phải toán tử và ngoặc)
    private static boolean isOperand(String token) {
        return !isOperator(token) && !token.equals("(") && !token.equals(")");
    }

    // Xác định độ ưu tiên của toán tử
    private static int precedence(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        // Sử dụng try-with-resources để tự động đóng Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Nhap bieu thuc trung to (Infix) - cac phan tu cach nhau boi khoang trang:");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (!input.trim().isEmpty()) {
                    String result = infixToPostfix(input);
                    System.out.println("Bieu thuc hau to (Postfix):");
                    System.out.println(result);
                }
            }
        }
    }
}
