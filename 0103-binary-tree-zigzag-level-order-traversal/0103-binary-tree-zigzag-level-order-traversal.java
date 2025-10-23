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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean leftToRight=true;
        while(!q.isEmpty()){
            int size=q.size();
            LinkedList<Integer> level=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                // int idx=leftToRight?i:(size-i-1);
                if(leftToRight)
                level.addLast(cur.val);
                else level.addFirst(cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            leftToRight=!leftToRight;
            ans.add(level);
        }
        return ans;
    }
}

// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> ans = new ArrayList<>();
//         if (root == null) return ans;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);
//         boolean leftToRight = true;

//         while (!q.isEmpty()) {
//             int size = q.size();
//             LinkedList<Integer> level = new LinkedList<>();

//             for (int i = 0; i < size; i++) {
//                 TreeNode cur = q.poll();

//                 if (leftToRight) {
//                     level.addLast(cur.val);   // normal order
//                 } else {
//                     level.addFirst(cur.val);  // reversed order
//                 }

//                 if (cur.left != null) q.offer(cur.left);
//                 if (cur.right != null) q.offer(cur.right);
//             }

//             ans.add(level);
//             leftToRight = !leftToRight;
//         }

//         return ans;
//     }
// }
