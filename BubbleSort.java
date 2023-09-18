public class BubbleSort {

    public static void bubbleSort(int[] arr, int n) {
        for (int i=0; i<=n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {45, 12, 34, 12, 1};

        System.out.println("Array before sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();

        bubbleSort(arr, arr.length);

        System.out.println("Array after sorting:");
        for (int x: arr)
            System.out.print(x + " ");
        System.out.println();
    }
}