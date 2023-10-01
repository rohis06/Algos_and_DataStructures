public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    private static final int FRONT = 1;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[this.capacity + 1];
    }

    private int leftChild(int pos) {
        return 2*pos;
    }

    private int rightChild(int pos) {
        return 2*pos + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size/2))
            return true;
        return false;
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    private void heapify(int pos) {
        if (!isLeaf(pos)) {
            int swapPos = pos;

            //extracting the min in the children
            if (rightChild(pos) <= size)
                swapPos = heap[leftChild(pos)] < heap[rightChild(pos)] ? leftChild(pos): rightChild(pos);
            else
                swapPos = leftChild(pos);

            //compare min of children with parent
            if (heap[pos] > heap[swapPos]) {
                swap(pos, swapPos);
                heapify(swapPos);
            }
        }
    }

    public void insert(int element) {
        if (size >= capacity)
            return;
        
        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[current/2]) {
            swap(current, current/2);
            current = current/2;
        }
    }

    public void remove() {
        heap[FRONT] = heap[size--];
        heapify(FRONT);
    }

    public int extractMin() {
        return heap[FRONT];
    }

    public void printHeap() {
        for (int i=1; i<=size/2; i++) {
            System.out.print("PARENT: " + heap[i] + " LEFT CHILD: " + heap[2*i] + " RIGHT CHILD: " + heap[2*i+1]);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minH= new MinHeap(10);

        minH.insert(3);
        minH.insert(12);
        minH.insert(10);
        minH.insert(3);
        minH.insert(5);
        minH.insert(1);
        minH.insert(7);

        minH.printHeap();
        System.out.println("Min element: " + minH.extractMin());

        minH.remove();
        System.out.println("Min element: " + minH.extractMin());
    }
}