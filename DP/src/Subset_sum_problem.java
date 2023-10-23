public class Subset_sum_problem {
    public static boolean subsetSum(int[] A, int n, int k) {
        if ( k==0) {
            return true;
        }
        if(n < 0 || k < 0) {
            return false;
        }
        boolean include = subsetSum(A, n-1, k - A[n]);
        boolean exclude = subsetSum(A, n-1, k);
        return include||exclude;
    }

    public static void main(String[] args) {
        int[] A = {7,3,2,5,8};
        int k = 14;
        if (subsetSum(A, A.length - 1, k)) {
            System.out.println("subset exists");
        }
        else{
            System.out.println("subset not exists");
    }

    }
}
