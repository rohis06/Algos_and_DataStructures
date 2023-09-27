public class QuickSort {
    public static void quickSort (int[] arr, int low, int high) {
        if (low < high) {
            int partition_index = partition(arr, low, high);

            quickSort(arr, low, partition_index-1);
            quickSort(arr, partition_index+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for (int j=low; j<=high-1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {45, 12, 34, 12, 1};

        System.out.println("Array before sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();

        quickSort(arr, 0, arr.length-1);

        System.out.println("Array after sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();
    }
}