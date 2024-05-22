// TC: O(nlogn)
// SC: O(1)
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class SortDoublyLinkedList {
    public void sortList(head) {
        return mergeSort(head);
    }

    public void mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        // Split the list into two halves
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = slow.next;
        slow.next = null; // Terminate the first half

        Node left = mergeSort(head);
        Node right = mergeSort(secondHalf);

        return merge(left, right);
    }

    public void merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                tail.next = left;
                left.prev = tail;
                left = left.next;
            } else {
                tail.next = right;
                right.prev = tail;
                right = right.next;
            }

            tail = tail.next;
        }

        if (left != null) {
            tail.next = left;
            left.prev = tail;
        } else {
            tail.next = right;
            right.prev = tail;
        }

        Node head = dummy.next;
        head.prev = null;

        return head;
    }
}