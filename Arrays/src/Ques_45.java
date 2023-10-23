// Find pairs with difference `k` in an array

import java.util.HashSet;
import java.util.Set;

public class Ques_45 {
    public static void findPair(int[] arr,int diff) {
        Set<Integer> set = new HashSet<>();

        for (int i:arr) {
            if (set.contains(i - diff)) {
                System.out.println("(" + i+","+(i-diff) +")");
            }
            if (set.contains(i+diff)) {
                System.out.println("(" + (i + diff) + ", " + i + ")");
            }
            set.add(i);
        }
    }

    public static void main(String[] args) {
        int[] A = { 1, 5, 2, 2, 2, 5, 5, 4};
        int diff = 3;

        findPair(A, diff);
    }
}
