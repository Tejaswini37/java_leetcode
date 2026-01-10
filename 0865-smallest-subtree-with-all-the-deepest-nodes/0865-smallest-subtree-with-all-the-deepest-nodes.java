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
//     At each node:
// If left depth > right depth → answer is in the left subtree
// If right depth > left depth → answer is in the right subtree
// If left depth == right depth → this node is the answer (it’s the LCA of deepest nodes)
    public class Pair{
        TreeNode node;
        int depth;
        Pair(TreeNode n,int d){
            node=n;
            depth=d;
        }
    }
    public Pair dfs(TreeNode r){
        if(r==null) return new Pair(null,0);
        Pair left=dfs(r.left);
        Pair right=dfs(r.right);
        if(left.depth>right.depth) return new Pair(left.node,left.depth+1);
        if(left.depth<right.depth) return new Pair(right.node,right.depth+1);
        return new Pair(r,left.depth+1);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
}