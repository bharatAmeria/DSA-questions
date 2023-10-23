public class Longest_alternating_subSeq {
    public static int util(int[] A, int start, int end, boolean flag) {
        int result = 0;
        for (int i = start; i <= end; i++) {
            if (flag && A[i-1] < A[i]) {
                result = Integer.max(result, 1 + util(A, i + 1, end, !flag));
            } else if (!flag && A[i-1] > A[i]) {
                result = Integer.max(result, 1 + util(A, i + 1, end, !flag));
            }
        }
        return result;
    }
    public static int findLongestSeq(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        return 1 + Integer.max(util(A,1,A.length - 1, true),util(A,1, A.length - 1, false));
    }

    public static void main(String[] args) {
        int[] A = {8, 9, 6, 4, 5, 7, 3, 2, 4};
        System.out.println(findLongestSeq(A));
        System.out.println(findLongestSeq(A));
    }
    public static int findLongestSeq1(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }
        int T[][] = new int [A.length][2];
        int result = 1;
        T[0][0] = T[0][1] = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    T[i][0] = Math.max(T[i][0], T[j][1] + 1);
                }
                if (A[i] < A[j]) {
                    T[i][1] = Math.max(T[i][1], T[j][0] + 1);
                }
            }
            if (result < Math.max(T[i][0], T[i][1])) {
                result = Math.max(T[i][0], T[i][1]);
            }
        }
        return result;
    }
}
