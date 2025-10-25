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
    private TreeNode prev;
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && root.val<prev.val){
            // if this is first violation mark them as first and middle
            if(first==null){
                first=prev;
                middle=root;
            }
            // if this is second violation mark it as last
            else last=root;
        }
        prev=root; // mark this node as previous
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first=middle=last=null;
        prev= new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){  //swap btw non adjacent
            int t=first.val;
            first.val=last.val;
            last.val=t;
        }
        else if(first!=null && middle!=null) {
            // swap btw adjacent
            int t=first.val;
            first.val=middle.val;
            middle.val=t;
        }
    }
}