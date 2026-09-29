package Week4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 * Bài 2 - Khảo sát thuật toán Selection Sort và so sánh với Insertion Sort
 * Môn học: Cấu trúc dữ liệu & Giải thuật
 * Tác giả: Tống Trung Kiên
 */
public class Bai2 {

    /**
     * Thuật toán sắp xếp chọn (Selection Sort).
     */
    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    /**
     * Thuật toán sắp xếp chèn (Insertion Sort).
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

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) return false;
        }
        return true;
    }

    public static double timeSelectionSort(int[] a) {
        int[] copy = a.clone();
        long start = System.nanoTime();
        selectionSort(copy);
        long end = System.nanoTime();
        if (!isSorted(copy)) throw new RuntimeException("Selection Sort bị lỗi!");
        return (end - start) / 1_000_000.0;
    }

    public static double timeInsertionSort(int[] a) {
        int[] copy = a.clone();
        long start = System.nanoTime();
        insertionSort(copy);
        long end = System.nanoTime();
        if (!isSorted(copy)) throw new RuntimeException("Insertion Sort bị lỗi!");
        return (end - start) / 1_000_000.0;
    }

    public static int[] generateRandomArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-1000000, 1000000);
        }
        return a;
    }

    public static int[] generateSortedArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        return a;
    }

    public static int[] generateReverseArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = n - i;
        return a;
    }

    public static int[] generateEqualArray(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 42);
        return a;
    }

    public static int[] readFromFile(String filename) {
        In in = new In(filename);
        return in.readAllInts();
    }

    public static void main(String[] args) {
        StdOut.println("=========================================================================================");
        StdOut.println("               KHẢO SÁT SELECTION SORT VÀ SO SÁNH VỚI INSERTION SORT                     ");
        StdOut.println("=========================================================================================");

        // Warmup
        StdOut.print("Đang khởi động (Warmup JVM)... ");
        for (int i = 0; i < 5; i++) {
            int[] test = generateRandomArray(2000);
            selectionSort(test);
            insertionSort(test);
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

        // --- 1. DỮ LIỆU FILE TEST ---
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.println("1. KHẢO SÁT & SO SÁNH TRÊN DỮ LIỆU FILE TEST (Trung bình 3 lần)");
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.printf("%-15s %-8s %-20s %-20s %-15s\n", "File", "N", "Selection (ms)", "Insertion (ms)", "Nhanh hơn");
        for (String file : fileNames) {
            try {
                int[] a = readFromFile(file);
                int n = a.length;
                double sumSel = 0, sumIns = 0;
                int runs = 3;
                for (int r = 0; r < runs; r++) {
                    sumSel += timeSelectionSort(a);
                    sumIns += timeInsertionSort(a);
                }
                double avgSel = sumSel / runs;
                double avgIns = sumIns / runs;
                String winner = (avgIns < avgSel) ? String.format("Insertion (%.2fx)", avgSel / avgIns) : String.format("Selection (%.2fx)", avgIns / avgSel);
                StdOut.printf("%-15s %-8d %-20.4f %-20.4f %-15s\n", file.substring(file.lastIndexOf('/') + 1), n, avgSel, avgIns, winner);
            } catch (Exception e) {
                StdOut.printf("%-15s Lỗi: %s\n", file, e.getMessage());
            }
        }
        StdOut.println();

        // --- 2. DỮ LIỆU NGẪU NHIÊN ---
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.println("2. KHẢO SÁT & SO SÁNH TRÊN DỮ LIỆU NGẪU NHIÊN (RANDOM) [Trung bình 5 lần]");
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.printf("%-10s %-20s %-20s %-18s %-15s\n", "N", "Selection (ms)", "Insertion (ms)", "T(2N)/T(N) Sel", "Nhanh hơn");
        double prevSelRandom = 0;
        for (int n : sizes) {
            double sumSel = 0, sumIns = 0;
            int runs = 5;
            for (int r = 0; r < runs; r++) {
                int[] a = generateRandomArray(n);
                sumSel += timeSelectionSort(a);
                sumIns += timeInsertionSort(a);
            }
            double avgSel = sumSel / runs;
            double avgIns = sumIns / runs;
            String ratioSel = (prevSelRandom > 0) ? String.format("%.2fx", avgSel / prevSelRandom) : "-";
            String winner = (avgIns < avgSel) ? String.format("Insertion (%.2fx)", avgSel / avgIns) : String.format("Selection (%.2fx)", avgIns / avgSel);
            StdOut.printf("%-10d %-20.4f %-20.4f %-18s %-15s\n", n, avgSel, avgIns, ratioSel, winner);
            prevSelRandom = avgSel;
        }
        StdOut.println();

        // --- 3. DỮ LIỆU ĐÃ SẮP XẾP XUÔI ---
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.println("3. KHẢO SÁT & SO SÁNH TRÊN DỮ LIỆU ĐÃ SẮP XẾP XUÔI (BEST CASE) [Trung bình 3 lần]");
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.printf("%-10s %-20s %-20s %-18s %-15s\n", "N", "Selection (ms)", "Insertion (ms)", "T(2N)/T(N) Sel", "Nhanh hơn");
        double prevSelSorted = 0;
        for (int n : sizes) {
            int[] a = generateSortedArray(n);
            double sumSel = 0, sumIns = 0;
            int runs = 3;
            for (int r = 0; r < runs; r++) {
                sumSel += timeSelectionSort(a);
                sumIns += timeInsertionSort(a);
            }
            double avgSel = sumSel / runs;
            double avgIns = sumIns / runs;
            String ratioSel = (prevSelSorted > 0) ? String.format("%.2fx", avgSel / prevSelSorted) : "-";
            String winner = (avgIns < avgSel) ? String.format("Insertion (%.2fx)", avgSel / avgIns) : String.format("Selection (%.2fx)", avgIns / avgSel);
            StdOut.printf("%-10d %-20.4f %-20.4f %-18s %-15s\n", n, avgSel, avgIns, ratioSel, winner);
            prevSelSorted = avgSel;
        }
        StdOut.println();

        // --- 4. DỮ LIỆU SẮP XẾP NGƯỢC ---
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.println("4. KHẢO SÁT & SO SÁNH TRÊN DỮ LIỆU SẮP XẾP NGƯỢC (WORST CASE) [Trung bình 3 lần]");
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.printf("%-10s %-20s %-20s %-18s %-15s\n", "N", "Selection (ms)", "Insertion (ms)", "T(2N)/T(N) Sel", "Nhanh hơn");
        double prevSelReverse = 0;
        for (int n : sizes) {
            int[] a = generateReverseArray(n);
            double sumSel = 0, sumIns = 0;
            int runs = 3;
            for (int r = 0; r < runs; r++) {
                sumSel += timeSelectionSort(a);
                sumIns += timeInsertionSort(a);
            }
            double avgSel = sumSel / runs;
            double avgIns = sumIns / runs;
            String ratioSel = (prevSelReverse > 0) ? String.format("%.2fx", avgSel / prevSelReverse) : "-";
            String winner = (avgIns < avgSel) ? String.format("Insertion (%.2fx)", avgSel / avgIns) : String.format("Selection (%.2fx)", avgIns / avgSel);
            StdOut.printf("%-10d %-20.4f %-20.4f %-18s %-15s\n", n, avgSel, avgIns, ratioSel, winner);
            prevSelReverse = avgSel;
        }
        StdOut.println();

        // --- 5. DỮ LIỆU TOÀN GIÁ TRỊ BẰNG NHAU ---
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.println("5. KHẢO SÁT & SO SÁNH TRÊN DỮ LIỆU TOÀN GIÁ TRỊ BẰNG NHAU (ALL EQUAL) [Trung bình 3 lần]");
        StdOut.println("-----------------------------------------------------------------------------------------");
        StdOut.printf("%-10s %-20s %-20s %-18s %-15s\n", "N", "Selection (ms)", "Insertion (ms)", "T(2N)/T(N) Sel", "Nhanh hơn");
        double prevSelEqual = 0;
        for (int n : sizes) {
            int[] a = generateEqualArray(n);
            double sumSel = 0, sumIns = 0;
            int runs = 3;
            for (int r = 0; r < runs; r++) {
                sumSel += timeSelectionSort(a);
                sumIns += timeInsertionSort(a);
            }
            double avgSel = sumSel / runs;
            double avgIns = sumIns / runs;
            String ratioSel = (prevSelEqual > 0) ? String.format("%.2fx", avgSel / prevSelEqual) : "-";
            String winner = (avgIns < avgSel) ? String.format("Insertion (%.2fx)", avgSel / avgIns) : String.format("Selection (%.2fx)", avgIns / avgSel);
            StdOut.printf("%-10d %-20.4f %-20.4f %-18s %-15s\n", n, avgSel, avgIns, ratioSel, winner);
            prevSelEqual = avgSel;
        }
        StdOut.println();
    }
}
