import java.util.Arrays;

public class multiple_partition_prob {
    public static boolean subsetSum(int[] arr, int n, int a, int b, int c) {
        if(a==0 && b==0 && c==0) {
            return true;
        }
        if(n<0) {
            return false;
        }
        boolean A = false;
        if (a - arr[n] >= 0) {
            A = subsetSum(arr, n-1, a-arr[n],b,c);
        }
        boolean B = false;
        if (!A && (b - arr[n] >= 0)) {
            B = subsetSum(arr, n-1, a,b-arr[n],c);
        }
        boolean C = false;
        if (!A && !B && (c - arr[n] >= 0)) {
            C = subsetSum(arr, n-1, a,b,c-arr[n]);
        }
        return A || B || C;
    }
    public static boolean partition(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        return (sum%3) == 0 && subsetSum(arr,arr.length-1, sum/3,sum/3,sum/3);
    }

    public static void main(String[] args) {
        int[] S = { 7, 3, 2, 1, 5, 4, 8 };

        if (partition(S)) {
            System.out.println("Set can be partitioned");
        }
        else {
            System.out.println("Set cannot be partitioned");
        }
    }
}
