// Move all zeros present in an array to the end

import java.util.Arrays;

public class Ques_18 {
    public static void reorder(int[] arr) {
        int k = 0;
        for (int i : arr) {
            if (i != 0) {
                arr[k++] = i;
            }
        }
        for (int i = k; i < arr.length; i++) {

        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 0, 8, 2, 3, 0, 4, 0, 1};
        reorder(arr);
//        partition(arr);
        System.out.println(Arrays.toString(arr));
    }
//  Method_2

    public static void swap(int[]arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void partition(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }
    }
}

