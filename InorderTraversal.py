# Recursive
class Solution:
    def __init__(self):
        self.res = []
    
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self._inorder(root)

        return self.res
    
    def _inorder(self, root: Optional[TreeNode]) -> None:
        if root is None:
            return
        
        self._inorder(root.left)
        self.res.append(root.val)
        self._inorder(root.right)

# Iterative
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        stack = []
        cur = root

        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            
            cur = stack.pop()
            res.append(cur.val)
            cur = cur.right

        return res