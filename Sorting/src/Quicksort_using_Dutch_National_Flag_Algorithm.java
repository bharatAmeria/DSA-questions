import java.util.Arrays;

public class Quicksort_using_Dutch_National_Flag_Algorithm {

    record Pair(int x, int y) {
    }

    public static void swap (int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static Pair Partition(int[] arr, int start, int end) {
        int mid = start;
        int pivot = arr[end];

        while (mid <= end) {
            if(arr[mid] < pivot) {
                swap(arr, start,end);
                ++start;
                ++mid;
            }else if (arr[mid] > pivot)
            {
                swap(arr, mid, end);
                --end;
            }else {
                ++mid;
            }
        }
        return new Pair(start - 1, mid);
    }
    public static void Quicksort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        Pair pivot = Partition(arr, start,end);
        Quicksort(arr,start,pivot.x());
        Quicksort(arr, pivot.y(), end);
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 2, 6, 8, 6, 1, 2, 6};
        Quicksort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
