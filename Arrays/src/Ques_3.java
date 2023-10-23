// Print all sub_arrays with 0 sum

public class Ques_3 {
    public static int findSum_of_Sub_array(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    System.out.println("subarray [" + i + "..." + j + "]" );
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, 3, 4, -7, 3, 1, -2, -4,};
        System.out.println(findSum_of_Sub_array(arr));
    }
}
