//   public class TreeNode {
//       int val;
//       TreeNode left;
//       TreeNode right;
//       TreeNode() {}
//       TreeNode(int val) { this.val = val; }
//       TreeNode(int val, TreeNode left, TreeNode right) {
//           this.val = val;
//           this.left = left;
//           this.right = right;
//       }
//   }

 
class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       if(root == null) return false;
       return isSubtreeH(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSubtreeH(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return root1.val == root2.val && isSubtreeH(root1.left, root2.left) && isSubtreeH(root1.right, root2.right);

    }
}
