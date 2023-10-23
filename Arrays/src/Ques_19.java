// Replace every array element with the product of every other element without using a division operator

import java.util.Arrays;

public class Ques_19 {
    public static void findProduct(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return;
        }
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = arr[i - 1] * left[i - 1];
        }
        right[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            right[j] = arr[j + 1] * right[j+1];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = left[i] * right[i];
         }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 2, 6, 8};
        findProduct(arr);
        System.out.println(Arrays.toString(arr));
    }
}
