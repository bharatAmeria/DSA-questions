import java.util.Arrays;

public class Ques_7 {
    private static final int[] row = {-1,-1,-1,0,0,1,1,1};
    private static final int[] col = {-1,0,1,-1,1,-1,0,1};
    private static boolean isValid(int x, int y, int M, int N) {
        return (x >= 0 && x < M && y >= 0 && y < N);
    }
    private static void DFS(int[][] mat, int x, int y) {
        int M = mat.length;
        int N = mat[0].length;
        mat[x][y] = 1;

        for (int k = 0; k < 8; k++) {
            int i = x + row[k];
            int j = y + col[k];

            if (isValid(i,j,M,N) && mat[i][j] == 0) {
                DFS(mat, i, j);
            }
        }
    }
    private static void replaceZeros(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return;
        }
        int M = mat.length;
        int N = mat[0].length;

        for (int i = 0; i < M; i++) {
            if (mat[i][0] == 0) {
                DFS(mat, i, 0);
            }
            if (mat[i][N - 1] == 0) {
                DFS(mat, i, N -1);
            }
        }
        for (int j = 0; j < N - 1; j++) {
            if (mat[0][j] == 0) {
                DFS(mat, 0, j);
            }
            if (mat[M - 1][j] == 0) {
                DFS(mat, M - 1, j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 1, 1, 1, 0, 0, 1, 1, 0, 1 },
                { 1, 0, 0, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 0, 0, 0, 1, 0, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 0, 1, 0, 1 },
                { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
        };
        replaceZeros(mat);

        for (var r: mat) {
            System.out.println(Arrays.toString(r));
        }
    }
}
