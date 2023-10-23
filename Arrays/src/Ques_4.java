//Sort binary array in linear time

import java.util.Arrays;

public class Ques_4 {
    public static void sort(int[] arr) {
        int zeros = 0;
        for (int value: arr) {
            if (value == 0) {
                zeros++;
            }
        }
        int k = 0;
        while (zeros-- != 0) {
            arr[k++] = 0;
        }

        // fill all remaining elements by 1
        while (k < arr.length) {
            arr[k++] = 1;
        }
    }
    public static void main (String[] args)
    {
        int[] A = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };

        sort(A);

        // print the rearranged array
        System.out.println(Arrays.toString(A));
    }

    public static void sortM_2(int[] A)
    {
        // `k` stores index of next available position
        int k = 0;

        // do for each element
        for (int i: A)
        {
            // if the current element is zero, put 0 at the next free
            // position in the array
            if (i == 0) {
                A[k++] = 0;
            }
        }

        // fill all remaining indices by 1
        for (int i = k; i < A.length; i++) {
            A[k++] = 1;
        }
    }

}

