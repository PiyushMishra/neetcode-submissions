/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    

    public int goodNodes(TreeNode root) {

        return goodNodesN(root, root.val);
        
    }


     public int goodNodesN(TreeNode root, int value) {

        if(root == null) return 0;
        
        int res = (root.val >= value) ? 1: 0;

        value =  Math.max(value, root.val);
        
        res += goodNodesN(root.left,  value);
        res += goodNodesN(root.right, value);
        return res;
        
    }
}
