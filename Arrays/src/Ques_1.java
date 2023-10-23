// Find a pair with the given sum in an array

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ques_1 {

    public static void findPair(int arr[],int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("pair found  " +arr[j] + arr[i]);
                    return;
                }
            }
        }
        System.out.println("pair not found");
    }

    public static void Method_2(int nums[], int target) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            if (nums [high] +nums[low] == target) {
                System.out.println((char)8);
                System.out.println(nums[low] +  nums[high]);

            }
            if (nums[low] + nums[high] < target) {
                low++;
            }else {
                high--;
            }
        }
        System.out.println((char)8);
        System.out.println("pair not found");
    }

    public static void Method_3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                System.out.println("Pair found"+ nums[map.get(target - nums[i])] + nums[i]);
            }
            map.put(nums[i], i);
        }
        System.out.println("pair not found ");
    }

    public static void main(String[] args) {
        int[] arr = {8,7,2,5,3,1};
        int target = 10;
        findPair(arr, target);




     }
}
