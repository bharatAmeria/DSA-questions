// Find the index of 0 to be replaced to get the maximum length sequence of continuous ones

public class Ques_12 {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 1, 1, 1, 0, 1, 1};
        int index = findIndexOfZero(arr);
        if (index!= -1) {
            System.out.println("Index to be replaced is " + index);
        }else {
            System.out.println("Invalid input");
        }

    }
    public static int findIndexOfZero(int[] arr) {
        int max_count = 0;
        int max_index = -1;
        int prev_0_index = -1;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                count++;
            }else {
                count = i - prev_0_index;
                prev_0_index = i;
            }
            if (count > max_count) {
                max_count = count;
                max_index = prev_0_index;
            }
        }
        return max_index;

    }
}
