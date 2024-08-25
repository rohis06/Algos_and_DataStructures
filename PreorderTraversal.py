# Recursive
class Solution:
    def __init__(self):
        self.res = []
    
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self._preorder(root)

        return self.res
    
    def _preorder(self, root: Optional[TreeNode]) -> None:
        if root is None:
            return
        
        self.res.append(root.val)
        self._preorder(root.left)
        self._preorder(root.right)


# Iterative
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        stack = [root]
        res = []

        while stack:
            cur = stack.pop()

            if cur:
                res.append(cur.val)
                stack.append(cur.right)
                stack.append(cur.left)
        
        return res