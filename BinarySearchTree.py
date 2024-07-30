class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class BinarySearchTree:
    def insert(self, node, val):
        # if tree empty
        if node is None:
            return Node(val)
        
        # traverse and insert
        if val < node.val:
            node.left = self.insert(node.left, val)
        else:
            node.right = self.insert(node.right, val)
        
        return node
    
    def delete(self, node, val):
        if node is None:
            return None
        else:
            if val < node.val:
                node.left = self.delete(node.left, val)
            elif val > node.val:
                node.right = self.delete(node.right, val)
            else:
                if node.left is None and node.right is None:
                    return None
                elif node.left is None:
                    node = node.right
                elif node.right is None:
                    node = node.left
                else:
                    temp = self.minNode(node.right)
                    node.val = temp.val
                    node.right = self.delete(node.right, temp.val)
        
        return node
    
    def minNode(self, root):
        if root.left is None:
            return root
        
        return self.minNode(root.left)
    
    def inorder(self, root):
        if root is None:
            return
        
        self.inorder(root.left)
        print(str(root.val) + "->", end=' ')
        self.inorder(root.right)
    
bst = BinarySearchTree()
root = None

# Insert nodes
values_to_insert = [50, 30, 20, 40, 70, 60, 80]
for val in values_to_insert:
    root = bst.insert(root, val)

print("In-order traversal before deletion:")
bst.inorder(root)
print("\n")

# Delete nodes
values_to_delete = [20, 30, 50]
for val in values_to_delete:
    root = bst.delete(root, val)

print("In-order traversal after deletion:")
bst.inorder(root)
print("\n")
