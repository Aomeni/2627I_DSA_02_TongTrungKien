import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bai8 {

    public static long countEqualPairs(int[] a) {
        if (a == null || a.length < 2) {
            return 0;
        }

        // Sap xep mang mat O(N log N)
        Arrays.sort(a);

        long totalPairs = 0;
        long currentCount = 1;

        // Duyet qua mang da sap xep mat O(N)
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                currentCount++;
            } else {
                totalPairs += currentCount * (currentCount - 1) / 2;
                currentCount = 1;
            }
        }

        // Cong so cap cua nhom cuoi cung
        totalPairs += currentCount * (currentCount - 1) / 2;

        return totalPairs;
    }

    public static void main(String[] args) {
        String fileName = "file.txt"; // Doc file trong thu muc du an
        List<Integer> list = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
            return;
        }

        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }

        long pairs = countEqualPairs(a);
        System.out.println("So cap so bang nhau la: " + pairs);
    }
}