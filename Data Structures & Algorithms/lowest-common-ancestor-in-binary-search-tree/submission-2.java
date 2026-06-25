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

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//     if (root == null || p == null || q == null) {
//             return null;
//     }        
//     if(root.val == p.val || root.val == q.val) return root;
//     TreeNode left = lowestCommonAncestor(root.left, p, q);
//     TreeNode right = lowestCommonAncestor(root.right, p, q);
//     if (left != null && right != null) return root;
//     return left != null ? left : right;
//     }
// }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);  // LCA in left subtree
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q); // LCA in right subtree
        } else {
            return root; // split point: one node on each side (or root is p or q)
        }
    }
}

