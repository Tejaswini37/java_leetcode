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
    public void helper(TreeNode root,int level,List<Integer> res)
    {
        if(root==null) return;
        if(res.size()==level){
            res.add(root.val);
        }
        helper(root.right,level+1,res);
        helper(root.left,level+1,res);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        helper(root,0,res);
        return res;
    }
}
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         if (root == null) return ans;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);

//         while (!q.isEmpty()) {
//             int size = q.size();
//             TreeNode rightmost = null;

//             for (int i = 0; i < size; i++) {
//                 TreeNode node = q.poll();
//                 rightmost = node;

//                 if (node.left != null) q.offer(node.left);
//                 if (node.right != null) q.offer(node.right);
//             }

//             ans.add(rightmost.val); // last node at this level
//         }

//         return ans;
//     }
// }
