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

class Value {
    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;
} 

class Solution {
    public boolean isValidBST(TreeNode root) {
       return isValidBSTH(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public boolean isValidBSTH(TreeNode root, long left, long right) {
        
        if(root == null) return true;

        if (!(left < root.val && root.val < right)) {
            return false;
        }

        return isValidBSTH(root.left, left, root.val) && isValidBSTH(root.right,root.val, right);
         
    }
}
