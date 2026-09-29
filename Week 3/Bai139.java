import java.util.Scanner;
import java.util.Stack;

public class Bai139 {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String s = scanner.next();
                
                if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                    ops.push(s);
                } else if (s.equals(")")) {
                    String op = ops.pop();
                    String v2 = vals.pop();
                    String v1 = vals.pop();
                    String subExpr = "( " + v1 + " " + op + " " + v2 + " )";
                    vals.push(subExpr);
                } else {
                    vals.push(s);
                }
            }
        }

        if (!vals.isEmpty()) {
            System.out.println(vals.pop());
        }
    }
}
