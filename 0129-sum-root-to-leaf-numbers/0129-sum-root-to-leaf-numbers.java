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
    public int dfs(TreeNode root,int cur){
        if(root==null) return 0;
        cur=cur*10+root.val;
        if(root.left==null && root.right==null) return cur;
        return dfs(root.left,cur)+dfs(root.right,cur);
    }
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return dfs(root,0);
    }
}
// class Solution {
//     public int sumNumbers(TreeNode root) {
//         if (root == null) return 0;
//         Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
//         q.offer(new Pair<>(root, root.val));
//         int sum = 0;

//         while (!q.isEmpty()) {
//             Pair<TreeNode, Integer> p = q.poll();
//             TreeNode node = p.getKey();
//             int curr = p.getValue();

//             if (node.left == null && node.right == null) {
//                 sum += curr;
//             }
//             if (node.left != null) {
//                 q.offer(new Pair<>(node.left, curr * 10 + node.left.val));
//             }
//             if (node.right != null) {
//                 q.offer(new Pair<>(node.right, curr * 10 + node.right.val));
//             }
//         }
//         return sum;
//     }
// }
