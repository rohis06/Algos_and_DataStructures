// Implement thread safe queue using Java

import java.lang.InterruptedException;

class ThreadSafeQueue<T> { //generic class can hold any type of data
    private final int capacity;
    private final Object[] queue;
    private int size;
    private int front;
    private int rear;

    public ThreadSafeQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (size == capacity) {
            wait();
        }

        queue[rear] = item;
        rear = (rear+1) % capacity;
        size++;

        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (size == 0) {
            wait();
        }

        T item = (T) queue[front];
        queue[front] = null;
        front = (front+1) % capacity;
        size--;

        notifyAll();
        return item;
    }
}

public class TSQueue {
    public static void main(String[] args) {
        ThreadSafeQueue<Integer> queue = new ThreadSafeQueue<>(5);

        Runnable producer = () -> {
            for (int i=1; i<=10; i++) {
                try {
                    queue.enqueue(i);
                    System.out.println("Enqueued: "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            for (int i=1; i<=10; i++) {
                try {
                    int item = queue.dequeue();
                    System.out.println("Dequeued: "+item);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread prodThread = new Thread(producer);
        Thread consThread = new Thread(consumer);

        prodThread.start();
        consThread.start();

        try {
            prodThread.join();
            consThread.join();           
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}