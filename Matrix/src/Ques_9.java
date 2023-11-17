public class Ques_9 {
    public static int count(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return 0;
        }
        int M = mat.length;
        int N = mat[0].length;

        int negative  = 0;
        int i = 0, j = N - 1;
        while (i <= M -1 && j >= 0) {
            if (mat[i][j] < 0) {
                negative += j+1;
                i++;
            }else {
                j--;
            }
        }
        return negative;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { -7, -3, -1, 3, 5 },
                { -3, -2, 2, 4, 6 },
                { -1, 1, 3, 5, 8 },
                { 3, 4, 7, 8, 9 }
        };
        System.out.println(count(mat));
    }
}
