 class Longest_path_of_consecutive_Char {
    private static int[] row = {-1,-1,-1,0,0,1,1,1};
    private static int[] col = {-1,-1,-1,0,0,1,1,1};

    private static boolean isValid(int x, int y, char[][] mat) {
        return (x >= 0 && x < mat.length) && (y >= 0 && y < mat[0].length);
    }

    public static int findMaxLength(char[][] mat, int x, int y, char previous) {

        if (!isValid(x,y,mat) || previous + 1 != mat[x][y]) {
            return 0;
        }
        int max_length = 0;

        for (int k = 0; k < 8; k++) {
            int len = findMaxLength(mat, x + row[k], y + col[k], mat[x][y]);

            max_length = Math.max(max_length, 1 + len);
        }
        return max_length;
    }
    public static int findMaxLength(char[][] mat, char ch) {
        if (mat == null || mat.length == 0) {
            return 0;
        }
        int M = mat.length;
        int N = mat[0].length;

        int max_length = 0;

        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (mat[x][y] == ch) {
                    for (int k = 0; k < row.length; k++) {
                        int len = findMaxLength(mat, x + row[k], y + col[k], ch);
                        max_length = Math.max(max_length, 1 + len);
                    }
                }
            }
        }
        return max_length;
    }

     public static void main(String[] args) {
         char[][] mat =
                 {
                         { 'D', 'E', 'H', 'X', 'B' },
                         { 'A', 'O', 'G', 'P', 'E' },
                         { 'D', 'D', 'C', 'F', 'D' },
                         { 'E', 'B', 'E', 'A', 'S' },
                         { 'C', 'D', 'Y', 'E', 'N' }
                 };
         char ch = 'C';
         System.out.println( ch +    findMaxLength(mat,ch));
     }
 }
