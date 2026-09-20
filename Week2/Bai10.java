public class Bai10 {

    public static int findFirstIndex(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        int result = -1; // Mac dinh la -1 neu khong tim thay

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] == key) {
                result = mid;       // Ghi nhan vi tri tim thay
                right = mid - 1;   // Tiep tuc tim kiem ben trai de tim chi so nho hon
            } else if (a[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 3, 4, 5};
        int key = 2;

        int index = findFirstIndex(a, key);

        if (index != -1) {
            System.out.println("Chi so nho nhat cua gia tri " + key + " la: " + index);
        } else {
            System.out.println("Khong tim thay " + key + " trong mang.");
        }
    }
}
