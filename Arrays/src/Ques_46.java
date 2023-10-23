// Find pairs with difference `k` in an array | Constant Space Solution

import java.util.Arrays;

public class Ques_46 {
    public static void findPair(int[]arr, int diff) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            while (i<arr.length - 1 && arr[i] == arr[i+1]) {
                i++;
            }
            if (Arrays.binarySearch(arr,arr[i] - diff) >= 0) {
                System.out.println("(" + arr[i] + ", " + (arr[i] - diff) + ")");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 2, 2, 2, 5, 5, 4};
        int diff = 3;

        findPair(arr, diff);
    }
}
