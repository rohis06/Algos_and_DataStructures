// Stack implementation

class Stack {
    private int arr[];
    private int top;
    private int capacity;

    Stack (int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack overflow");
            System.exit(1);
        }
        System.out.println("Inserting " +  x);
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack empty");
            System.exit(1);
        }
        return arr[top--];
    }

    public int getSize() {
        return top+1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        for (int i=0; i<=top; i++)
            System.out.print(arr[i] + ", ");
    }
}

public class Stacks {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.printStack();

        stack.pop();
        stack.printStack();
    }
}


// ArrayList implemetation
// https://www.javatpoint.com/difference-between-arraylist-and-linkedlist

import java.util.ArrayList;
import java.util.List;

class Stack {
    private List<Integer> list;
    private int top;
    private int capacity;

    Stack(int size) {
        list = new ArrayList<>();
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack overflow");
            System.exit(1);
        }
        System.out.println("Inserting " + x);
        list.add(++top, x);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack empty");
            System.exit(1);
        }
        return list.remove(top--);
    }

    public int getSize() {
        return top + 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++)
            System.out.print(list.get(i) + ", ");
    }
}

public class Stacks {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.printStack();

        stack.pop();
        stack.printStack();
    }
}
