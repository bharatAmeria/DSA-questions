import java.util.Arrays;

public class Heap_sort {
    private static int Left(int i) {
        return(2*i +1);
    }

    private static int Right(int i) {
        return(2*i + 2);
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void heapify(int[] A, int i, int size) {
        int left = Left(i);
        int right  = Right(i);

        int largest = i;

        if (left < size && A[left] > A[i]) {
            largest = left;
            }
        if (right < size && A[right] > A[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(A,i,largest);
            heapify(A,largest,size);
        }
    }
    public static int pop(int[] A, int size) {
        if(size <= 0) {
            return -1;
        }
        int top = A[0];

        A[0] = A[size - 1];
        heapify(A,0,size - 1);
        return top;
    }
    public static void heapSort(int[] A) {
        int n = A.length;

        int i = (n - 2)/2;
        while (i>= 0) {
            heapify(A, i--, n);
            n--;
        }
        while (n > 0) {
            A[n - 1] = pop(A,n);
            n--;
        }
    }

    public static void main(String[] args) {
        int[] A = {6, 4, 7, 1, 9, -2 };
        heapSort(A);
        System.out.println(Arrays.toString(A));
    }
}
