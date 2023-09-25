//TC: O(nlogn)
//SC: O(n)

import java.util.*;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        int n = arr.length;

        if (n <= 1)
            return;
        
        int mid = (n-1)/2;

        int[] left = Arrays.copyOfRange(arr, 0, mid+1);
        int[] right = Arrays.copyOfRange(arr, mid+1, n);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int l = 0, r = 0, k = 0;
        int n = left.length, m = right.length;

        while (l < n && r < m) {
            if (left[l] < right[r]) {
                arr[k++] = left[l++];
            }
            else {
                arr[k++] = right[r++];
            }
        }

        while (l < n) {
            arr[k++] = left[l++];
        }

        while (r < m) {
            arr[k++] = right[r++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {45, 12, 34, 12, 1};

        System.out.println("Array before sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();

        mergeSort(arr);

        System.out.println("Array after sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();
    }
}