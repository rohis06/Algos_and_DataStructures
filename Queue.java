public class Queue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;

    public Queue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue");
            return;
        }
        rear++;
        queueArray[rear] = item;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int item = queueArray[front];
        front++;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek");
            return -1;
        }
        return queueArray[front];
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public int size() {
        return rear - front + 1;
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Queue size: " + q.size());
        System.out.println("Front element: " + q.peek());

        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());

        System.out.println("Queue size: " + q.size());
        System.out.println("Front element: " + q.peek());        
    }
}