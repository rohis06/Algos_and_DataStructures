# Recursive
class Solution:
    def __init__(self):
        self.res = []
    
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self._postorder(root)

        return self.res
    
    def _postorder(self, root: Optional[TreeNode]) -> None:
        if root is None:
            return

        self._postorder(root.left)
        self._postorder(root.right)
        self.res.append(root.val)

# Iterative
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        stack = [root]
        visit = [False]
        res = []

        while stack:
            cur, v = stack.pop(), visit.pop()
            if cur:
                if v:
                    res.append(cur.val)
                else:
                    stack.append(cur)
                    visit.append(True)
                    stack.append(cur.right)
                    visit.append(False)
                    stack.append(cur.left)
                    visit.append(False)

        return res