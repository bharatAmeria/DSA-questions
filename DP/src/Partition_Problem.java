import java.util.Arrays;

public class Partition_Problem {

    public static boolean subsetSum(int[] arr, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n < 0 || sum < 0) {
            return false;
        }
        boolean include = subsetSum(arr, n - 1, sum - arr[n]);
        boolean exclude = subsetSum(arr, n - 1, sum);

        if (include) {
            return true;
        }
        return exclude;
    }
    public static boolean partition(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        return (sum & 1) == 0 && subsetSum(arr, arr.length-1, sum/2);
    }

    public static void main(String[] args) {
        int[] arr = { 7, 3, 1, 5, 4, 8 };

        if (partition(arr)) {
            System.out.println("Set can be partitioned");
        }
        else {
            System.out.println("Set cannot be partitioned");
        }
    }
}

