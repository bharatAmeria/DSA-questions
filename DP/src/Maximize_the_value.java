import java.util.Arrays;

public class Maximize_the_value {
    public static void main(String[] args) {
        int[] A = { 3, 9, 10, 1, 30, 40 };

        System.out.println(maximizeExpression(A));
    }
    public static int maximizeExpression(int[] arr) {
        if(arr.length < 4) {
            System.exit(-1);
        }
        int[] first = new int[arr.length +1];
        Arrays.fill(first, Integer.MIN_VALUE);

        int[] second = new int[arr.length];
        Arrays.fill(second, Integer.MIN_VALUE);

        int[] third = new int[arr.length - 1];
        Arrays.fill(third, Integer.MIN_VALUE);

        int[] fourth = new int[arr.length - 2];
        Arrays.fill(fourth, Integer.MIN_VALUE);

        for (int i = arr.length - 1; i >= 0; i--) {
            first[i] = Integer.max(first[i + 1], arr[i]);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            second[i] = Integer.max(second[i + 1], first[i + 1] - arr[i]);
        }
        for (int i = arr.length - 3; i >= 0; i--) {
            third[i] = Integer.max(third[i + 1], second[i + 1] + arr[i]);
        }
        for (int i = arr.length - 4; i >= 0; i--) {
            fourth[i] = Integer.max(fourth[i + 1], third[i + 1] - arr[i]);
        }
        return fourth[0];
    }
}
