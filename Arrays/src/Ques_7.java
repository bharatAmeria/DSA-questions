//Find the largest subarray having an equal number of 0’s and 1’s

import java.util.HashMap;
import java.util.Map;

public class Ques_7 {
    public static void findLargestSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int len = 0;
        int last_index = -1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (map.containsKey(sum)) {
                if (len < i - map.get(sum)) {
                    len = i - map.get(sum);
                    last_index = i;
                } else {
                    map.put(sum, i);
                }
                if (last_index != -1) {
                    System.out.println("[" + (last_index - len + 1) + ", " +
                            last_index + "]");
                } else {
                    System.out.println("No subarray exists");
                }
            }
        }

    }public static void main (String[]args){
        int[] nums = {0, 0, 1, 0, 1, 0, 0};
        findLargestSubarray(nums);
    }
}
