//TC: O(n^2 logn) since merge takes n^2
//SC: O(1)

import java.util.*;

public class MergeSortInPlace {
    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r)
            return;
        
        int m = l + (r-l)/2;

        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);

        merge(arr, l, m, r);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int start2 = mid+1;

        if (arr[mid] <= arr[start2])
            return;
        
        while (start <= mid && start2 <= end) {
            if (arr[start] <= arr[start2])
                start++;
            else {
                int temp = arr[start2];
                int index = start2;

                while (index != start) {
                    arr[index] = arr[index-1];
                    index--;
                }

                arr[start] = temp;

                start++;
                mid++;
                start2++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {45, 12, 34, 12, 1};

        System.out.println("Array before sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();

        mergeSort(arr, 0, arr.length-1);

        System.out.println("Array after sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();
    }
}