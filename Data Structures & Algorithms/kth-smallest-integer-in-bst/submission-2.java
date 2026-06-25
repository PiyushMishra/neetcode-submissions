
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }
 

 class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return kSmallestH(root, k);
    }

    private int count = 0;
    private int result = 0;

    public int kSmallestH(TreeNode root, int k) {
        if (root == null) return -1;
        
        kSmallestH(root.left, k);
        
        count++;
        if (count == k) {
            result = root.val;
            return result;
        }
        
        kSmallestH(root.right, k);
        return result;
    }
}
