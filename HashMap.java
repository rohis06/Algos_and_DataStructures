// Implement HashMap using Arrays in Java. It handles collisions too using chaining

class ListNode {
    int key;
    int val;
    ListNode next;

    ListNode (int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}

class MyHashMap {
    private final int SIZE = 1000;
    ListNode[] buckets;

    public MyHashMap() {
        buckets = new ListNode[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        remove(key); //remove if already present

        int index = hash(key);
        if (buckets[index] == null)
            buckets[index] = new ListNode(key, value, null);
        else {
            ListNode curr = buckets[index];
            while (curr.next != null)
                curr = curr.next;
            curr.next = new ListNode(key, value, null);
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        ListNode curr = buckets[index];

        while (curr != null) {
            if (curr.key == key)
                return curr.val;
            curr = curr.next;
        }
        return -1; //not found
    }
    
    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null)
            return;
        
        if (buckets[index].key == key) {
            buckets[index] = buckets[index].next;
            return;
        }

        ListNode prev = buckets[index];
        ListNode curr = prev.next;
        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        return;
    }
}

public class HashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        
        map.put(1, 10);
        map.put(3, 15);
        map.put(2, 5);

        System.out.println(map.get(3));
    }
}