//TC: O(nlogn)
//SC: O(1)

import java.util.*;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        //construct a heap
        for (int pos=n/2-1; pos>=0; pos--)
            heapify(arr, n, pos);
        
        //extarting element from heap, by swapping first with last
        for (int i=n-1; i>=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //reduce the size of heap
            heapify(arr, i, 0);
        }
    }

    //constructing a max heap
    public static void heapify(int[] arr, int n, int pos) {
        int largest = pos;
        int left = 2*pos + 1;
        int right = 2*pos + 2;

        //if left > root
        if (left < n && arr[left] > arr[largest])
            largest = left;
        
        //if right > largest
        if (right < n && arr[right] > arr[largest])
            largest = right;
        
        if (largest != pos) {
            int temp = arr[pos];
            arr[pos] = arr[largest];
            arr[largest] = temp;

            //heapify again
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {45, 12, 34, 12, 1};

        System.out.println("Array before sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();

        heapSort(arr);

        System.out.println("Array after sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();
    }
}