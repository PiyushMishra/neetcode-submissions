class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);  // Level end marker

        TreeNode prev = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                // End of level
                if (prev != null) {
                    res.add(prev.val); // Rightmost node of this level
                }
                if (!queue.isEmpty()) {
                    queue.offer(null);  // Mark end of next level
                }
            } else {
                // Add children to queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            prev = node;
        }

        return res;
    }
}
