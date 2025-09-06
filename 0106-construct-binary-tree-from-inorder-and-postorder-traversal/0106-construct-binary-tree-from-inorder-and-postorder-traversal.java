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
    public TreeNode contruct(int postorder[],int start,int end,Map<Integer,Integer> hm,int postIndex[]){
        if(start>end) return null;
        int d=postorder[postIndex[0]--];
        int idx=hm.get(d);
        TreeNode root=new TreeNode(d);
        root.right=contruct(postorder,idx+1,end,hm,postIndex);
        root.left=contruct(postorder,start,idx-1,hm,postIndex);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++) hm.put(inorder[i],i);
        int postIndex[]=new int[]{n-1};
        return contruct(postorder,0,n-1,hm,postIndex);
    }
}