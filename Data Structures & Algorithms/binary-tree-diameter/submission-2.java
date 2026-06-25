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

class MaxValue {
    int value = Integer.MIN_VALUE;
}

class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
       MaxValue max = new MaxValue();
       diameterOfBinaryTreeH(root, max);
       return max.value;
    }

    public int diameterOfBinaryTreeH(TreeNode root, MaxValue max) {
        if(root == null) return 0;
        int left   = diameterOfBinaryTreeH(root.left, max);
        int right  = diameterOfBinaryTreeH(root.right,max);
        max.value = Math.max(max.value, left + right);
        return 1 + Math.max(left ,right);
    }
}
