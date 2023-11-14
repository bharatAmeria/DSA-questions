public class Ques_5 {
    public static void printMaxDiagonally(int[][] mat) {
        if(mat == null || mat.length == 0) {
            return;
        }
        int M = mat.length;
        int N = mat[0].length;

        for (int r = 0; r < M; r++) {
            for (int i = r, j = 0; i < N && i >= 0; i--, j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print(System.lineSeparator());
        }
        for (int c = 1; c < N; c++) {
            for (int i = M - 1, j = c; j < N && i >= 0; i--, j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print(System.lineSeparator());
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3, 4, 5 },
                { 2, 3, 4, 5, 6 },
                { 3, 4, 5, 6, 7 },
                { 4, 5, 6, 7, 8 },
                { 5, 6, 7, 8, 9 }
        };
        printMaxDiagonally(mat);
    }
}
