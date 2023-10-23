//Shuffle an array using Fisher–Yates shuffle algorithm


import java.util.Arrays;
import java.util.Random;

//— To shuffle an array ‘a’ of ‘n’ elements:
//      for i from n-1 down to 1 do
//      j = random integer such that 0 <= j <= i
//      exchange a[j] and a[i]
 class Ques_13 {
    public static void main(String[] args) {
        int[] a ={1, 2, 3, 4, 5, 6};
        shuffle(a);
        System.out.println(Arrays.toString(a));
    }
    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void shuffle(int[] a) {
        for (int i = a.length - 1; i >=1 ; i--) {
            Random random = new Random();
            long s = 24;
            random.setSeed(24);
            int j = random.nextInt(i + 1);
            swap(a, i, j);
        }
    }

}