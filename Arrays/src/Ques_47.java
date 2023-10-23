// 4–Sum Problem | Quadruplets with a given sum

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ques_47 {
    public static boolean quadRuplet(int[] arr, int n, int target, int count) {
        if (target == 0 && count == 4) {
            return true;
        }
        if (count > 4 || n==0) {
            return false;
        }
        return quadRuplet(arr, n-1, target-arr[n-1], count+1) || quadRuplet(arr, n-1, target,count);
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 0, 9, 5, 1, 3};
        int target = 30;

        if (quadRuplet(arr, arr.length,target, 0)) {
            System.out.println("exists");
        }else {
            System.out.println("DNE");
        }
    }
//    Method_2 hashtable
static class pair{
        public int x,y;
        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public static boolean quadRuplet(int[] arr, int n, int target) {
            Map<Integer, List<pair>> map = new HashMap<>();

            for (int i = 0; i < n -1; i++) {
                for (int j = i+1; j < n; j++) {
                    int val = target - (arr[i] + arr[j]);

                    if(map.containsKey(val)) {
                        for (pair pair: map.get(val)) {
                            int x = pair.x;
                            int y = pair.y;

                            if ((y != i && y != j) && (x != i && y != j)) {
                                System.out.println("Quadruplet Found ("
                                        + arr[i] + ", " + arr[j] + ", "
                                        + arr[x] + ", " + arr[y] + ")");
                                return true;
                            }
                        }
                    }
                    map.putIfAbsent(arr[i] + arr[j], new ArrayList<>());
                    map.get(arr[i] + arr[j]).add(new pair(i, j));
                }
            }
            return false;
        }
}
}
