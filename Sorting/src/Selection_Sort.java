import java.util.Arrays;

public class Selection_Sort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,5,8,4,1,9,-2};

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
