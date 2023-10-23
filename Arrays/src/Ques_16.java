// Find the largest subarray formed by consecutive integers

class Ques_16 {
    private static boolean isConsecutive(int[] arr,int i, int j, int max,int min) {
        if (max - min != j - i) {
            return false;
        }
        boolean visited[] = new boolean[j - i + 1];
        for (int k = i; k <= j; k++) {
            if (visited[arr[k] - min]) {
                return false;
            }
            visited[arr[k] - min] = true;
        }return true;
    }
    public static void findMaxSub_array(int[] arr) {
        int len = 1;
        int start = 0, end = 0;

        for (int i = 0; i < arr.length; i++) {
            int min_val = arr[i], max_val = arr[i];
            for (int j = i + 1; j < arr.length; j++) {

                min_val = Math.min(min_val,arr[j]);
                max_val = Math.max(max_val,arr[j]);

                if (isConsecutive(arr,i,j,max_val,max_val)) {
                    if (len < max_val - min_val + 1)
                    {
                        len = max_val - min_val + 1;
                        start = i;
                        end = j;
                }
            }
        }
    }
        System.out.println("The largest subarray is [" + start + ", " + end + "]");
}

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 4, 3, 1, 0 };
        findMaxSub_array(arr);
    }
}
