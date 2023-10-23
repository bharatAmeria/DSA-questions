// Find equilibrium index of an array

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Ques_15 {
     public static void main(String[] args) {
         int[] arr = {0, -3, 5, -4, -2, 3, 1, 0};
         findEqmIndex(arr);
         Method_2(arr);
     }
     public static void findEqmIndex(int[] arr) {
         int[] left = new int[arr.length];
         for (int i = 1; i < arr.length; i++) {
             left[i] = left[i - 1] + arr[i - 1];
         }
         int right = 0;
         List<Integer> indices = new ArrayList<>();
         for (int i = arr.length - 1; i >= 0 ; i--) {
             if (left[i] == right) {
                 indices.add(i);
             }right += arr[i];
         }
         System.out.println("Equilibrium Index found at " + indices);

     }
public static void Method_2(int[] arr){
         int total = IntStream.of(arr).sum();
         int right = 0;
         List<Integer> indices = new ArrayList<>();

    for (int i = arr.length - 1; i >= 0 ; i--) {
        if (right == total - (arr[i] + right)) {
            indices.add(i);
        }right += arr[i];
    }
    System.out.println("Equilibrium Index found at " + indices);
}
}
