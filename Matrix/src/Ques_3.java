import java.util.*;

// Find the shortest path from source to destination in a matrix that satisfies given constraints
class node {
    int x, y;
    node parent;
    node(int x, int y, node parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
public class Ques_3 {
    private static final int[] row = {-1,0,0,1};
    private static final int[] col = {0,-1,1,0};
    private static boolean isValid(int x, int y, int N) {
        return (x >=0 && x < N) && (y >= 0 && y < N);
    }
    private static void findPath(node node, List<String> path) {
        if (node != null) {
            findPath(node.parent, path);
            path.add(node.toString());
        }
    }
    public static List<String> findPath(int[][] matrix, int x, int y) {
        List<String> path = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return path;
        }
        int N = matrix.length;
        Queue<node> q = new ArrayDeque<>();
        node src = new node(x, y, null);
        q.add(src);

        Set<String> visited = new HashSet<>();
        String key = src.x + "," + src.y;
        visited.add(key);

        while (!q.isEmpty()) {
            node curr = q.poll();
            int i = curr.x, j = curr.y;

            if (i == N -1 && j == N - 1) {
                findPath(curr, path);
                return path;
            }
            int n = matrix[i][j];
            for (int k = 0; k < row.length; k++) {
                x = i + row[k] * n;
                y = j + col[k] * n;

                if (isValid(x,y,N)) {
                    node next = new node(x,y,curr);
                    key = next.x + "," + next.y;

                    if (!visited.contains(key)) {
                        q.add(next);
                        visited.add(key);
                    }
                }
            }
        }
        return path;
    }

    public static void main(String[] args) {
        int[][] matrix = {

                { 4, 4, 6, 5, 5, 1, 1, 1, 7, 4 },
                { 3, 6, 2, 4, 6, 5, 7, 2, 6, 6 },
                { 1, 3, 6, 1, 1, 1, 7, 1, 4, 5 },
                { 7, 5, 6, 3, 1, 3, 3, 1, 1, 7 },
                { 3, 4, 6, 4, 7, 2, 6, 5, 4, 4 },
                { 3, 2, 5, 1, 2, 5, 1, 2, 3, 4 },
                { 4, 2, 2, 2, 5, 2, 3, 7, 7, 3 },
                { 7, 2, 4, 3, 5, 2, 2, 3, 6, 3 },
                { 5, 1, 4, 2, 6, 4, 6, 7, 3, 7 },
                { 1, 4, 1, 7, 5, 3, 6, 5, 3, 4 }
        };
        List<String> path = findPath(matrix,0,0);
        if (path != null && path.size() > 0) {
            System.out.print("The Shortest Path is " + path);
        }else {
            System.out.println("Destination is not found");
        }
    }
}
