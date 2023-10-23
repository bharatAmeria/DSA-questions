// Rearrange array such that `A[A[i]]` is set to `i` for every element `A[i]`

import java.util.Arrays;

class Ques_50 {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,0};
        rearrange(arr);
        reArrange_2(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));
    }
    public static void rearrange(int[] arr) {
        int[] aux = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            aux[arr[i]] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = aux[i];
        }
    }
//    method_2 O(n) time
public static void reArrange_2(int[]arr) {
        int n = arr.length;
    for (int i = 0; i < n; i++) {
        arr[arr[i] % n] += i*n;
    }
    for (int i = 0; i < n; i++) {
        arr[i] = arr[i] / n;
    }
}
}

