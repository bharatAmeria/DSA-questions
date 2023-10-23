// Find maximum length Sub_array having a given sum

import java.util.HashMap;
import java.util.Map;

public class Ques_6 {
    public static void findMaxLenSubarray(int[] arr, int S) {
        int len = 0;
        int last_index = 0;

        for (int i = 0; i < arr.length; i++) {
            int target = 0;
            for (int j = i; j < arr.length; j++) {
                target += arr[j];

                if (target == S) {
                    if(len < j - i + 1) {
                        len = j - 1 + 1;
                        last_index = j;
                    }
                }
            }
        }
        System.out.println("[" + (last_index - len + 1 +"," + last_index + "]"));
    }

    public static void main(String[] args) {
        int[] arr ={5, 6, -5, 5, 3, 5, 3, -2, 0};
        int target = 8;
        int[] nums = {5, 6, -5, 5, 3, 5, 3, -2, 0};
        M_2(nums, target);
        findMaxLenSubarray(arr, target);
    }
    public static void M_2(int[] nums, int S) {
        Map<Integer,Integer> map =new HashMap<>();

        map.put(0, -1);
        int target =0;
        int len = 0;
        int last_index = -1;

        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
            map.putIfAbsent(target, i);

            if (map.containsKey(target - S) && len < i - map.get(target -S)) {
                len = i - map.get(target - S);
                last_index = i;
            }
            System.out.println("[" + (last_index - len + 1) + ", " + last_index + "]");
        }
    }
}
