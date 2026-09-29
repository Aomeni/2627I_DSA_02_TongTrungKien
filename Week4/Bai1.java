package Week4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 * Bài 1 - Khảo sát thuật toán Insertion Sort (Sắp xếp chèn)
 * Môn học: Cấu trúc dữ liệu & Giải thuật
 * Tác giả: Tống Trung Kiên
 */
public class Bai1 {

    /**
     * Thuật toán sắp xếp chèn (Insertion Sort) cho mảng số nguyên.
     * @param a Mảng cần sắp xếp
     */
    public static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    /**
     * Kiểm tra mảng đã được sắp xếp tăng dần hay chưa.
     */
    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) return false;
        }
        return true;
    }

    /**
     * Đo thời gian thực thi (tính theo miligiây ms) của 1 lần chạy Insertion Sort trên mảng a.
     */
    public static double timeOneRun(int[] a) {
        int[] copy = a.clone();
        long start = System.nanoTime();
        insertionSort(copy);
        long end = System.nanoTime();

        if (!isSorted(copy)) {
            throw new RuntimeException("Lỗi: Mảng chưa được sắp xếp đúng!");
        }
        return (end - start) / 1_000_000.0; // đổi sang ms
    }

    /**
     * Sinh mảng ngẫu nhiên kích thước N.
     */
    public static int[] generateRandomArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-1000000, 1000000);
        }
        return a;
    }

    /**
     * Sinh mảng đã sắp xếp xuôi (tăng dần) kích thước N.
     */
    public static int[] generateSortedArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        return a;
    }

    /**
     * Sinh mảng sắp xếp ngược (giảm dần) kích thước N.
     */
    public static int[] generateReverseArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = n - i;
        }
        return a;
    }

    /**
     * Sinh mảng toàn các giá trị bằng nhau kích thước N.
     */
    public static int[] generateEqualArray(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 42);
        return a;
    }

    /**
     * Đọc mảng từ file dữ liệu test bằng thư viện algs4 (In).
     */
    public static int[] readFromFile(String filename) {
        In in = new In(filename);
        return in.readAllInts();
    }

    public static void main(String[] args) {
        StdOut.println("=========================================================================================");
        StdOut.println("                      KHẢO SÁT THỜI GIAN CHẠY CỦA INSERTION SORT                         ");
        StdOut.println("=========================================================================================");

        // Warmup JVM để tránh nhiễu do JIT compilation
        StdOut.print("Đang khởi động (Warmup JVM)... ");
        for (int i = 0; i < 5; i++) {
            insertionSort(generateRandomArray(2000));
        }
        StdOut.println("Hoàn thành!\n");

        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000};
        String[] fileNames = {
            "Week4/data/1Kints.txt",
            "Week4/data/2Kints.txt",
            "Week4/data/4Kints.txt",
            "Week4/data/8Kints.txt",
            "Week4/data/16Kints.txt",
            "Week4/data/32Kints.txt"
        };

        // --- 1. KHẢO SÁT DỮ LIỆU FILE TEST (Trung bình >= 3 lần) ---
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.println("1. KHẢO SÁT DỮ LIỆU TỪ FILE TEST (1Kints.txt -> 32Kints.txt) [Trung bình 3 lần]");
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.printf("%-15s %-15s %-20s\n", "Tên File", "Kích thước (N)", "Thời gian trung bình (ms)");
        for (String file : fileNames) {
            try {
                int[] a = readFromFile(file);
                int n = a.length;
                double totalMs = 0;
                int runs = 3;
                for (int r = 0; r < runs; r++) {
                    totalMs += timeOneRun(a);
                }
                double avgMs = totalMs / runs;
                StdOut.printf("%-15s %-15d %-20.4f\n", file.substring(file.lastIndexOf('/') + 1), n, avgMs);
            } catch (Exception e) {
                StdOut.printf("%-15s %-15s Lỗi: %s\n", file, "N/A", e.getMessage());
            }
        }
        StdOut.println();

        // --- 2. KHẢO SÁT DỮ LIỆU NGẪU NHIÊN (Trung bình >= 5 lần) ---
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.println("2. KHẢO SÁT DỮ LIỆU NGẪU NHIÊN (RANDOM) [Trung bình 5 lần]");
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.printf("%-15s %-20s %-20s\n", "Kích thước (N)", "Thời gian trung bình (ms)", "Tỷ lệ T(2N)/T(N)");
        double prevRandomTime = 0;
        for (int n : sizes) {
            double totalMs = 0;
            int runs = 5;
            for (int r = 0; r < runs; r++) {
                int[] a = generateRandomArray(n);
                totalMs += timeOneRun(a);
            }
            double avgMs = totalMs / runs;
            String ratioStr = (prevRandomTime > 0) ? String.format("%.2f x", avgMs / prevRandomTime) : "-";
            StdOut.printf("%-15d %-20.4f %-20s\n", n, avgMs, ratioStr);
            prevRandomTime = avgMs;
        }
        StdOut.println();

        // --- 3. KHẢO SÁT DỮ LIỆU ĐÃ SẮP XẾP XUÔI (BEST CASE - Trung bình >= 3 lần) ---
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.println("3. KHẢO SÁT DỮ LIỆU ĐÃ SẮP XẾP XUÔI (BEST CASE) [Trung bình 3 lần]");
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.printf("%-15s %-20s %-20s\n", "Kích thước (N)", "Thời gian trung bình (ms)", "Tỷ lệ T(2N)/T(N)");
        double prevSortedTime = 0;
        for (int n : sizes) {
            int[] a = generateSortedArray(n);
            double totalMs = 0;
            int runs = 3;
            for (int r = 0; r < runs; r++) {
                totalMs += timeOneRun(a);
            }
            double avgMs = totalMs / runs;
            String ratioStr = (prevSortedTime > 0) ? String.format("%.2f x", avgMs / prevSortedTime) : "-";
            StdOut.printf("%-15d %-20.4f %-20s\n", n, avgMs, ratioStr);
            prevSortedTime = avgMs;
        }
        StdOut.println();

        // --- 4. KHẢO SÁT DỮ LIỆU SẮP XẾP NGƯỢC (WORST CASE - Trung bình >= 3 lần) ---
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.println("4. KHẢO SÁT DỮ LIỆU SẮP XẾP NGƯỢC (WORST CASE) [Trung bình 3 lần]");
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.printf("%-15s %-20s %-20s\n", "Kích thước (N)", "Thời gian trung bình (ms)", "Tỷ lệ T(2N)/T(N)");
        double prevReverseTime = 0;
        for (int n : sizes) {
            int[] a = generateReverseArray(n);
            double totalMs = 0;
            int runs = 3;
            for (int r = 0; r < runs; r++) {
                totalMs += timeOneRun(a);
            }
            double avgMs = totalMs / runs;
            String ratioStr = (prevReverseTime > 0) ? String.format("%.2f x", avgMs / prevReverseTime) : "-";
            StdOut.printf("%-15d %-20.4f %-20s\n", n, avgMs, ratioStr);
            prevReverseTime = avgMs;
        }
        StdOut.println();

        // --- 5. KHẢO SÁT DỮ LIỆU TOÀN GIÁ TRỊ BẰNG NHAU (BEST CASE - Trung bình >= 3 lần) ---
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.println("5. KHẢO SÁT DỮ LIỆU TOÀN GIÁ TRỊ BẰNG NHAU (ALL EQUAL) [Trung bình 3 lần]");
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.printf("%-15s %-20s %-20s\n", "Kích thước (N)", "Thời gian trung bình (ms)", "Tỷ lệ T(2N)/T(N)");
        double prevEqualTime = 0;
        for (int n : sizes) {
            int[] a = generateEqualArray(n);
            double totalMs = 0;
            int runs = 3;
            for (int r = 0; r < runs; r++) {
                totalMs += timeOneRun(a);
            }
            double avgMs = totalMs / runs;
            String ratioStr = (prevEqualTime > 0) ? String.format("%.2f x", avgMs / prevEqualTime) : "-";
            StdOut.printf("%-15d %-20.4f %-20s\n", n, avgMs, ratioStr);
            prevEqualTime = avgMs;
        }
        StdOut.println();
    }
}
