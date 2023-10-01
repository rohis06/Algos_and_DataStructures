public class BinarySearchTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int element) {
        Node newNode = new Node(element);

        //if tree is empty
        if (root == null) {
            root = newNode;
            return;
        } else {
            Node current = root, parent = null;

            while(true) {
                parent = current;

                if (element < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node deleteNode(Node node, int value) {
        if (node == null)
            return null;
        else {
            if (value < node.data)
                node.left = deleteNode(node.left, value);
            else if (value > node.data)
                node.right = deleteNode(node.right, value);
            else {
                if (node.left == null && node.right == null)
                    node = null;
                else if (node.left == null)
                    node = node.right;
                else if (node.right == null)
                    node = node.left;
                else {
                    Node temp = minNode(node.right);
                    node.data = temp.data;
                    node.right = deleteNode(node.right, temp.data);
                }
            }
        }

        return node;
    }

    public Node minNode(Node root) {
        if (root.left!=null)
            return minNode(root.left);
        return root;
    }

    public void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        bst.insert(7);
        bst.insert(14);
        bst.insert(6);
        bst.insert(7);
        bst.insert(2);
        bst.insert(18);
        bst.insert(14);

        bst.inorderTraversal(bst.root);
        System.out.println();

        bst.deleteNode(bst.root, 14);
        bst.inorderTraversal(bst.root);
        System.out.println();
    }
}