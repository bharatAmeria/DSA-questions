// Longest Bitonic Subarray Problem

public class Ques_20 {
    public static void findBitonic(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int[] I = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            I[i] = 1;
            if (arr[i-1] < arr[i]) {
                I[i] = I[i - 1] + 1;
            }
        }
        int[] D = new int[arr.length];
        D[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            D[i] = 1;
            if (arr[i] > arr[i + 1]) {
                D[i] = D[i + 1] + 1;
            }
        }
        int lbs_len = 1;
        int beg = 0,end = 0;

        for (int i = 0; i < arr.length; i++) {
            int len = I[i] +D[i]-1;
            if (lbs_len < len)
            {
                lbs_len = len;
                beg = i - I[i] + 1;
                end = i + D[i] - 1;
            }
        }
        System.out.println("The length of the longest bitonic subarray is " + lbs_len);
        System.out.printf("The longest bitonic subarray indices is [%d, %d]", beg, end);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4 };

        findBitonic(arr);
    }


}
