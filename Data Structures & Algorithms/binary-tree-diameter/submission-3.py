# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    

    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.diameter = 0
        if root:
           self.height(root)
           return self.diameter
        else:
            return 0    
                  

    def height(self, root) -> int:
        if root:
            left_tree_height  = self.height(root.left)
            right_tree_height = self.height(root.right)
            self.diameter = max(self.diameter, left_tree_height + right_tree_height)  
            return 1 + max(left_tree_height, right_tree_height)
        else:
            return 0    
