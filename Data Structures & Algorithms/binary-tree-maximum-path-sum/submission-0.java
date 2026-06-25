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

class MaxSum {
    int value = Integer.MIN_VALUE;
    MaxSum setValue(Integer value) {
        this.value = value;
        return this;
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
       MaxSum max = new MaxSum();
       maxPathSumH(root,max);
       return max.value;
    }


     public int maxPathSumH(TreeNode root, MaxSum max) {

        if(root == null) {
            return 0;
        }
        
        int left = Math.max(0, maxPathSumH(root.left, max));
        int right = Math.max(0, maxPathSumH(root.right, max));

        max.setValue(Math.max(max.value, root.val + left + right));  

        return root.val + Math.max(left, right);
    }
}
