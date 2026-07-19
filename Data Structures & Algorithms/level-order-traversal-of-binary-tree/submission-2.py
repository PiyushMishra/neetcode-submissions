# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        if not root:
           return []

        res_final: List[List[int]] = []

        queue: List[Optional[TreeNode]] = []

        queue.append(root)
        queue.append(None)

        res = []
        while queue:
            node = queue.pop(0)
            if node:
                res.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)    
            else:
                res_final.append(res)
                res = []

                if queue:
                    queue.append(None)
            
        return res_final

        