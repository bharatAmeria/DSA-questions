// Find a triplet with the given sum in an array

public class Ques_41 {
    public static boolean Triplet(int[] arr,int n, int target, int count) {
        if (count == 3 && target == 0) {
            return true;
        }
        if (count == 3 || n == 0 || target < 0) {
            return false;
        }
        return Triplet(arr,n-1,target-arr[n-1],count+1) || Triplet(arr,n-1,target,count);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 4, 0, 9, 5, 1, 3};
        int target = 6;
        Triplet(arr,arr.length,target,0);
    }
}
