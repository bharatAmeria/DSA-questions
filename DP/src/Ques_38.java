// Count total possible combinations of n-digit numbers in a mobile keypad

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Ques_38 {
    public static boolean isValid(int i, int j) {
        if (i == 3 && (j == 0 || j == 2)) {
            return false;
        }
        return (i >= 0 && i <= 3 && j >= 0 && j <= 2);
    }
    public static Map<Integer, List<Integer>> fillMap(char[][] keypad) {
        Map<Integer, List<Integer>> mapping = new HashMap<>();

        int[] row = {0,-1,0,1};
        int[] col = {-1,0,1,0};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    int r = i + row[k];
                    int c = j + col[k];

                    if (isValid(i,j) && isValid(r,c)) {
                        mapping.putIfAbsent(keypad[i][j] - '0', new ArrayList<>());
                        mapping.get(keypad[i][j] - '0').add(keypad[r][c] - '0');
                    }
                }
            }
        }
        return mapping;
    }
    public static int getCount(Map<Integer, List<Integer>> mapping, int i, int n, int[][] lookup) {
        if (n == 1) {
            return 1;
        }
        if (lookup[i][n] == 0) {
            lookup[i][n] = getCount(mapping, i, n - 1, lookup);
            for (Integer e: mapping.get(i)) {
                lookup[i][n] += getCount(mapping, e,n - 1, lookup);
            }
        }
        return lookup[i][n];
    }
    private static int findCount(int n, char[][] keypad) {
        Map<Integer, List<Integer>> mapping = fillMap(keypad);
        int[][] lookup = new int[10][n + 1];
        int count = 0;
        for (int i = 0; i <= 9; i++) {
            count += getCount(mapping, i, n, lookup);
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 2;
        char[][] keypad = {
                { '1', '2', '3' },
                { '4', '5', '6' },
                { '7', '8', '9' },
                { '*', '0', '#' }
        };
        System.out.println(findCount(n, keypad));
    }
}
