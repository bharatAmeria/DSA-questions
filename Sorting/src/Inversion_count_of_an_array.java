import java.util.Arrays;

public class Inversion_count_of_an_array {

    public static int findInversionCount(int[] arr) {
        int inversionCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }

    public static void main(String[] args) {
        int[] arr = {1,9,6,4,5};

        int[] aux = Arrays.copyOf(arr, arr.length);
        System.out.println(findInversionCount(arr));

        System.out.println(mergesort(arr,aux,0, arr.length-1));
    }

//  method 2 :- By merge sort

public static int merge(int[] arr, int[] aux,int low, int mid, int high) {
    int k = low, i = low, j = mid + 1;
    int inversionCOunt = 0;

    while (i <= mid && j <= high) {
        if (arr[i] <= arr[j]) {
            aux[k++] = arr[j++];
        } else {
            aux[k++] = arr[j++];
            inversionCOunt += (mid - i + 1);
        }
        for (i = low; i <= high; i++) {
            arr[i] = aux[i];
        }
    }
    return inversionCOunt;
}
public static int mergesort(int[] arr, int[] aux, int low, int high) {
        if(high<=low) {
            return 0;
        }
        int mid = (low + ((high - low) >> 1));
        int inversionCount = 0;

        inversionCount += mergesort(arr,aux,low,mid);
        inversionCount += mergesort(arr, aux, mid+1, high);
        inversionCount += merge(arr,aux,low,mid,high);
        return inversionCount;
   }
}
