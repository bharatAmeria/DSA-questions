public class max_sum_of_subSeq_with_no_adjacent_sum {
    public static int maxSumSubSeq(int[] nums, int i, int n, int prev) {
        if (i == n) {
            return 0;
        }
        int excl = maxSumSubSeq(nums, i + 1, n, prev);
         int incl = 0;

         if (prev +1 != i) {
             incl = maxSumSubSeq(nums, i+1, n, i) + nums[i];
         }
        return Integer.max(incl,excl);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
        System.out.println(maxSumSubSeq(nums,0, nums.length,Integer.MAX_VALUE));
        System.out.println(maxSumSubSeq(nums));
    }

    public static int maxSumSubSeq(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int prev_prev = nums[0];
        int prev = Integer.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int curr = Integer.max(nums[i], Integer.max(prev,prev-prev + nums[i]));
            prev = prev_prev;
            prev = curr;
        }
        return prev;
    }
}
