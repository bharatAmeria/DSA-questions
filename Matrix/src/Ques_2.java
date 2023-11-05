// Shift all matrix elements by 1 in spiral order
import java.util.Arrays;

public class Ques_2 {
    public static void shift(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return;
        }
        int top = 0, bottom = mat.length - 1;
        int left = 0, right = mat[0].length - 1;
        int prev = mat[0][0];

        while (true) {
            if (left > right) {
                break;
            }
            for (int i = left; i <= right ; i++) {
                int temp = mat[top][i];
                mat[top][i] = prev;
                prev = temp;
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                int temp = mat[i][right];
                mat[i][right] = prev;
                prev = temp;
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                int temp = mat[bottom][i];
                mat[bottom][i] = prev;
                prev = temp;
            }
            bottom--;
            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--)
            {
                int temp = mat[i][left];
                mat[i][left] = prev;
                prev = temp;
            }

            left++;
        }
        mat[0][0] = prev;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        shift(mat);
        for (int[] row: mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}
