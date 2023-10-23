import java.util.ArrayList;
import java.util.List;

public class MAx_length_snake_seq {
    public static List<pair> constructPath(int[][] L, int[][] grid, pair tail) {
        List<pair> path = new ArrayList<>();
        path.add(tail);
        
        int i = tail.first;
        int j = tail.second;
        
        while (L[i][j] != 0) {
            if (i-1 >= 0 && L[i][j] - L[i-1][j] == 1
            && Math.abs(grid[i-1][j] - grid[i][j])== 1) {
                path.add(new pair(i-1,j));
                i--;
            } else if (j - 1 >= 0 && (L[i][j] - L[i][j - 1] == 1)
            && Math.abs(grid[i][j-1] - grid[i][j]) == 1) {

                path.add(new pair(i, j-1));
                i--;
            }
        }
        return path;
    }

    public static List<pair> findMaxLengthSnakeSeq(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
        int[][] L = new int[grid.length][grid.length];
        int maxTillNow = 0;
        pair tail = null;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                L[i][j] = 0;

                if (i-1 >= 0 && Math.abs(grid[i-1][j] - grid[i][j]) == 1) {
                    L[i][j] = L[i][j-1] + 1;

                    if (maxTillNow < L[i][j]) {
                        maxTillNow  = L[i][j];
                        tail = new pair(i,j);
                    }
                }
                if (j-1 >= 0 && Math.abs(grid[i][j-1] - grid[i][j]) == 1 ) {
                    L[i][j] = Integer.max(L[i][j], L[i][j-1] + 1);

                    if (maxTillNow < L[i][j]) {
                        maxTillNow = L[i][j];
                        tail = new pair(i,j);
                    }
                }
            }
        }
        return constructPath(L,grid,tail);
    }
    public static void printSnakeSeq(int[][] grid, List<pair> path) {
        if (path == null || path.size() == 0) {
            return;
        }
        System.out.println("the max length");

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.println(grid[path.get(i).first][path.get(i).second]);
            if (i != 0) {
                System.out.println(" -- ");
            }
        }
        System.out.println("|n the length is " + (path.size() - 1));
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 7, 5, 2, 3, 1 },
                { 3, 4, 1, 4, 4 },
                { 1, 5, 6, 7, 8 },
                { 3, 4, 5, 8, 9 },
                { 3, 2, 2, 7, 6 }
        };
        List<pair> path
                 = findMaxLengthSnakeSeq(grid);
        printSnakeSeq(grid, path);
    }
}
class pair{
    int first, second;

    public pair(int first,int second) {
        this.first = first;
        this.second = second;
    }
}
