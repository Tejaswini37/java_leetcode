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
    public TreeNode construct(int[] preorder,int start,int end,Map<Integer,Integer> mp,int preIndex[]){
        if(start>end) return null;
        int d=preorder[preIndex[0]++];
        TreeNode root=new TreeNode(d);
        int idx=mp.get(d);
        root.left=construct(preorder,start,idx-1,mp,preIndex);
        root.right=construct(preorder,idx+1,end,mp,preIndex);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++) mp.put(inorder[i],i);
        int preIndex[]=new int[]{0};
        return construct(preorder,0,n-1,mp,preIndex);
    }
}