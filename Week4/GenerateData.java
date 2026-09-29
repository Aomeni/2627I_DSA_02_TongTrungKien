package Week4;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateData {
    public static void main(String[] args) {
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000};
        Random rand = new Random(42); // fixed seed for reproducibility

        for (int n : sizes) {
            String filename = "Week4/data/" + (n / 1000) + "Kints.txt";
            try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
                for (int i = 0; i < n; i++) {
                    out.println(rand.nextInt(2000000) - 1000000);
                }
                System.out.println("Generated " + filename + " (" + n + " elements)");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
