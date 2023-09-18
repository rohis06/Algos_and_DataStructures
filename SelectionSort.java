public class SelectionSort {

    public static void selectionSort(int[] arr, int n) {
        for (int i=0; i<=n-1; i++) {
            int min_idx = i;
            for (int j=i+1; j<=n-1; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {45, 12, 34, 12, 1};

        System.out.println("Array before sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();

        selectionSort(arr, arr.length);

        System.out.println("Array after sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();
    }
}