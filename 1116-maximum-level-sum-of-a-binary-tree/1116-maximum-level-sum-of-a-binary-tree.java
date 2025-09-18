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
    public int maxLevelSum(TreeNode root) {
       Queue<TreeNode> q=new LinkedList<>();
       q.add(root);
       int level=1,maxLevel=1;
       int maxSum=Integer.MIN_VALUE;
       while(!q.isEmpty()){
        int size=q.size();
        int sum=0;
        for(int i=0;i<size;i++){
            TreeNode node=q.poll();
            sum+=node.val;
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }
        if(sum>maxSum){
            maxSum=sum;
            maxLevel=level;
        }
        level++;
       } 
       return maxLevel;
    }
}

//   
// class Solution {
//     private Map<Integer, Integer> levelSum = new HashMap<>();

//     public int maxLevelSum(TreeNode root) {
//         dfs(root, 1);
//         int maxSum = Integer.MIN_VALUE;
//         int ans = 1;

//         for (int lvl : levelSum.keySet()) {
//             int sum = levelSum.get(lvl);
//             if (sum > maxSum || (sum == maxSum && lvl < ans)) {
//                 maxSum = sum;
//                 ans = lvl;
//             }
//         }

//         return ans;
//     }

//     private void dfs(TreeNode node, int level) {
//         if (node == null) return;
//         levelSum.put(level, levelSum.getOrDefault(level, 0) + node.val);
//         dfs(node.left, level + 1);
//         dfs(node.right, level + 1);
//     }
// }
