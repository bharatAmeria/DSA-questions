// Sort an array of 0’s, 1’s, and 2’s (Dutch National Flag Problem)

import java.util.Arrays;

public class Ques_9 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0};
        threeWayPartition(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void threeWayPartition(int[] arr) {
        int start = 0;
        int  mid = 0;
        int pivot  = 1;
        int end = arr.length - 1;

        while (mid <= end) {
            if (arr[mid] < pivot ) {
                swap(arr, start, mid);
                ++start;
                ++mid;
            } else if (arr[mid] > pivot) {
                swap(arr, mid, end);
                --end;
            }
            else {
                ++mid;
            }
        }
    }
}
