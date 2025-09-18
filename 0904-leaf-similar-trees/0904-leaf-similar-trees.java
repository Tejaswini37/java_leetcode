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
    public void getleaves(List<Integer> leaves,TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null) leaves.add(root.val);
        getleaves(leaves,root.left);
        getleaves(leaves,root.right);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1=new ArrayList<>();
        List<Integer> leaves2=new ArrayList<>();
        getleaves(leaves1,root1);
        getleaves(leaves2,root2);
        return leaves1.equals(leaves2);

    }
}