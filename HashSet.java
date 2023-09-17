// Implementing HashSet data structure in Java.
// It handles collisions using chaining

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class MyHashSet {
    final int SIZE = 1000;
    ListNode[] buckets;

    public MyHashSet() {
        buckets = new ListNode[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public boolean add(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new ListNode(key);
        } else {
            ListNode curr = buckets[index];
            while (curr.next != null) {
                if (curr.val == key)
                    return false; //Element already exists
                curr = curr.next;
            }
            if (curr.val == key)
                return false; //Element already exists
            curr.next = new ListNode(key);
        }
        return true;
    }

    public boolean remove(int key) {
        int index = hash(key);
        if (buckets[index] == null)
            return false; //element not found
        
        if (buckets[index].val == key) {
            buckets[index] = buckets[index].next;
            return true;
        }

        ListNode prev = buckets[index];
        ListNode curr = prev.next;
        while (curr != null) {
            if (curr.val == key) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    public boolean contains(int key) {
        int index = hash(key);
        ListNode curr = buckets[index];
        
        while (curr != null) {
            if (curr.val == key)
                return true; //element found
            curr = curr.next;
        }

        return false;
    }
}

public class HashSet {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();

        System.out.println(set.add(5));
        System.out.println(set.add(16));
        System.out.println(set.add(5));
        System.out.println(set.add(5));
        System.out.println(set.add(20));
        System.out.println(set.remove(5));
        System.out.println(set.contains(5));
        System.out.println(set.remove(16));
    }
}