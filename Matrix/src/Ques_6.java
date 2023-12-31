import java.util.Stack;

public class Ques_6 {
    public static void findPath(int[][] mat, Stack<Integer> path , int i, int j) {
        if (mat == null || mat.length == 0) {
            return;
        }
        int M = mat.length;
        int N = mat[0].length;

        if (i == M - 1 && j == N - 1) {
            path.add(mat[i][j]);
            System.out.println(path);
            path.pop();

            return;
        }
        path.add(mat[i][j]);

        if (j + 1 < N) {
            findPath(mat, path, i, j + 1);
        }
        if (i + 1 < M && j < N) {
            findPath(mat, path, i + 1, j);
        }
        path.pop();
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        Stack<Integer> path = new Stack<>();
        int x = 0, y = 0;
        findPath(mat, path, x, y);
    }
}
