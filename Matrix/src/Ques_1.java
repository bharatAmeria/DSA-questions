// Print matrix in spiral order

public class Ques_1 {
    private static void printSpiral(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return;
        }
        int top = 0, bottom = mat.length - 1;
        int left = 0, right = mat[0].length -1;

        while (true) {
            if (left > right) {
                break;
            }
            for (int i = left; i <= right; i++) {
                System.out.println(mat[top][i] + " ");
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i < bottom; i++) {
                System.out.println(mat[i][right] + " ");
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                System.out.println(mat[bottom][i] + " ");
            }
            bottom--;
            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                System.out.print(mat[i][left] + " ");
            }
            left++;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        printSpiral(mat);
    }
}
