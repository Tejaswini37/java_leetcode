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
    public static void inorder(TreeNode root,ArrayList<Integer> h){
        if(root==null) return;
        inorder(root.left,h);
        h.add(root.val);
        inorder(root.right,h);
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> h=new ArrayList<Integer>();
        inorder(root,h);
        
        int l=0,r=h.size()-1;
        while(l<r){
            if(h.get(l)+h.get(r)==k){
                return true;
            }
            else if(h.get(l)+h.get(r)>k) r--;
            else l++;
        }
        return false;

    }
}