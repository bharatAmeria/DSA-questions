// Sort an array in one swap whose two elements are swapped

import java.util.Arrays;

public class Ques_40 {
    private static void sortArr(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int x = -1, y = -1;
        int prev = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (prev > arr[i]) {
                if (x == -1) {
                    x = i -1;
                    y = i;
                }else {
                    y=i;
                }
            }
            prev = arr[i];
        }
        swap(arr,x,y);
    }
    private static void swap(int[]arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] arr = { 3, 5, 6, 9, 8, 7 };

        sortArr(arr);
        System.out.println(Arrays.toString(arr));
    }
}
