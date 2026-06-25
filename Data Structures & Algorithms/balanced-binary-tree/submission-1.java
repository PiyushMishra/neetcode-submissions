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
    public boolean isBalanced(TreeNode root) {
        return height(root)[0] == 1;
    }


    public int[] height(TreeNode root) {

        if(root == null) return new int[]{1, 0};

        int[] lh = height(root.left);
        int[] rh = height(root.right);

        boolean isBalanced = lh[0] == 1 && rh[0] ==1 && Math.abs(lh[1] -rh[1]) <= 1;
        int height = 1 + Math.max(lh[1], rh[1]);

        return new int[] {isBalanced ? 1:0, height};

        

    }       


}
