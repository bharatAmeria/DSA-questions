// Find the maximum product of two integers in an array

public class Ques_8 {
    public static void findMaxProduct(int[] num) {
        if (num.length < 2) {
            return;
        }
        int max = Integer.MAX_VALUE;
        int max_i = -1, max_j = -1;

        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (max < num[i]* num[j]) {
                    max = num[i]*num[j];
                    max_i = i;
                    max_j = j;
                }
            }
        }
        System.out.print("Pair is (" + num[max_i] + ", " + num[max_j] + ")");
    }

    public static void main(String[] args) {
        int[] num = {-10, -3, 5, 6, -2};
        findMaxProduct(num);
    }
}
