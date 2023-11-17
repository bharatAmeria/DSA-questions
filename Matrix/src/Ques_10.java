public class Ques_10 {
    public static void findElement(int[][] mat, int key) {
        if (mat == null || mat.length == 0) {
            return;
        }
        int M = mat.length;
        int N = mat[0].length;

        int i = 0, j = N -1;
        while (i <= M -1 && j >= 0) {
            if (mat[i][j] < key) {
                i++;
            } else if (mat[i][j] > key) {
                j--;
            }else {
                System.out.println(key + "(" + i + "," + j + ")");
                i++;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = {
                { -4, -3, -1, 3, 5 },
                { -3, -2, 2, 4, 6 },
                { -1, 1, 3, 5, 8 },
                { 3, 4, 7, 8, 9 }
        };
        int key = 3;
        findElement(mat, key);
    }
}
