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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resM = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return resM;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);  // Level end marker

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                // End of level
                resM.add(res);
                res = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.offer(null);  // Mark end of next level
                }
            } else {
                // Add children to queue
                res.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

        }

        return resM;
    }
}

