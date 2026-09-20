import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai14 {

    public static List<List<Integer>> fourSum(int[] a, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (a == null || a.length < 4) {
            return result;
        }

        // Buoc 1: Sap xep mang mat O(N log N)
        Arrays.sort(a);
        int n = a.length;

        // Buoc 2: Dung 2 vong lap va ky thuat hai con tro -> Tot nhat O(N^3)
        for (int i = 0; i < n - 3; i++) {
            // Bo qua gia tri trung lap cho so thu nhat
            if (i > 0 && a[i] == a[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Bo qua gia tri trung lap cho so thu hai
                if (j > i + 1 && a[j] == a[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) a[i] + a[j] + a[left] + a[right];

                    if (sum == target) {
                        result.add(Arrays.asList(a[i], a[j], a[left], a[right]));

                        // Bo qua cac gia tri trung lap cho so thu ba va thu tu
                        while (left < right && a[left] == a[left + 1]) left++;
                        while (left < right && a[right] == a[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> pairs = fourSum(a, target);

        System.out.println("Cac bo 4 so co tong bang " + target + " la:");
        for (List<Integer> group : pairs) {
            System.out.println(group);
        }
    }
}
