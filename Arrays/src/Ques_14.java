// Rearrange an array with alternate high and low elements

import java.util.Arrays;

class Ques_14 {
   private static void swap(int[] a, int i, int j){
       int temp = a[i];
       a[i] = a[j];
       a[j] = temp;
   }
   public static void reArrange(int[] a) {
       for (int i = 1; i < a.length; i += 2) {
           if (a[i -1] > a[i] ) {
               swap(a, i - 1, i);
           }if (i + 1 < a.length && a[i + 1] >a[i]){
               swap(a, i + 1, i);
           }
       }
   }

    public static void main(String[] args) {
       int[] a = {9,6,8,3,7};
       reArrange(a);
        System.out.println(Arrays.toString(a));
    }
}
