import java.util.Arrays;

public class Ques_4 {
    public static void changeRowCol (int[][] mat, int M, int N, int x, int y) {
        for (int i = 0; i < M; i++) {
            if (mat[i][y] != 0) {
                mat[i][y] = -1;
            }
        }
        for (int j = 0; j < N; j++) {
            if (mat[x][j] != 0) {
                mat[x][j] = -1;
            }
        }
    }
    public static void convert(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return;
        }
        int M = mat.length;
        int N = mat[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    changeRowCol(mat,M,N,i,j);
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1 }
        };
        convert(mat);
        for (var r: mat) {
            System.out.println(Arrays.toString(r));
        }
    }
}