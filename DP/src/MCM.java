class MCM {
    public static int MCM(int[] arr,int i, int j, int T[][]) {
        if(j <= i + 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        if (T[i][j] == 0) {
        for (int k = i + 1; k <= j-1 ; k++) {
            int cost = MCM(arr, i, k,T);
            cost += MCM(arr, k, j,T);
            cost += arr[i] * arr[k] * arr[j];

            if (cost < min) {
                min = cost;
            }
        }
            T[i][j] = min;
        }
        return T[i][j];
    }

    public static void main(String[] args) {
        int[] arr ={10,30,5,60};
        int[][] T= new int[arr.length + 1][arr.length + 1];
        System.out.println(MCM(arr,0, arr.length-1,T));
    }
}
