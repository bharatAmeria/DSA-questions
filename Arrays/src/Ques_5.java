// Find the duplicate element in a limited range array

import java.util.stream.IntStream;

public class Ques_5 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4};
        System.out.println("The duplicate element is " + findDuplicate(arr));
    }

    public static int findDuplicate(int[] arr) {
        boolean visited[] = new boolean[arr.length + 1];

        for(int value : arr) {
            if (visited[value]) {
                return value;
            }
            visited[value] = true;
        } return -1;
    }
// Method 2: using array indices

    public static int M_2(int[] nums) {
         int duplicate = -1; for (int i: nums)
        {
            // get the value of the current element
            int val = (i < 0) ? -i : i;

            // make element at index `val` negative if it is positive
            if (nums[val] >= 0) {
                nums[val] = -nums[val];
            }
            else {
                // if the element is already negative, it is repeated
                duplicate = val;
                break;
            }
        }

        // restore the original array before returning
        for (int i = 0; i < nums.length; i++)
        {
            // make negative elements positive
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }

        // return duplicate element
        return duplicate;
    }
// Method 3:

public static int M_3(int[] nums) {
    int xor = 0;
    for (int value : nums) {
        xor ^= value;
    }
    int i;
    for (i = 1; i < nums.length - 1; i++) ;
    xor ^= i;
    return xor;
}
// M_4 :Using Difference in sum

    public static int M_4(int[] nums) {
        int actual_sum = IntStream.of(nums).sum();
        int excepted_sum = nums.length * (nums.length - 1) / 2;

        return actual_sum - excepted_sum;
    }
}

