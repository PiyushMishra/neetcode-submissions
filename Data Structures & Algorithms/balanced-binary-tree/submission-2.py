# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.isBalanced = True
        if root:
            self.height(root)
            return self.isBalanced
        else:
            return True    
    

    def height(self, root):
        if root:
            left = self.height(root.left)
            right = self.height(root.right)
            if abs(left - right) > 1: 
                self.isBalanced = False
            return 1 + max(left, right)    
        return 0    