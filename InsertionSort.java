public class InsertionSort {

    public static void insertionSort(int[] arr, int n) {
        for (int i=0; i<=n-1; i++) {
            int j = i;
            while (j>0 && arr[j-1] > arr[j]) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {45, 12, 34, 12, 1};

        System.out.println("Array before sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();

        insertionSort(arr, arr.length);

        System.out.println("Array after sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();
    }
}