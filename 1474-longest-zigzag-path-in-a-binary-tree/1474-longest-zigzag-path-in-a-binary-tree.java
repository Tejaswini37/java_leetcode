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
    private int maxlen=0;
    public void dfs(TreeNode root,int dir,int len){
        if(root==null) return ;
        maxlen=Math.max(maxlen,len);
        if(dir==0){ // last move was left
            dfs(root.right,1,len+1); //continue
            dfs(root.left,0,1); //restart
        } else{
            dfs(root.left,0,len+1); //continue
            dfs(root.right,1,1); //restart
        }
    }
    public int longestZigZag(TreeNode root) {
        // 0 LEFT DIR
        // 1 RIGHT DIR
        if(root==null) return 0;
        dfs(root.left,0,1);
        dfs(root.right,1,1);
        return maxlen;
    }
}

