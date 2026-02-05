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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int ops=0;
        while(!q.isEmpty()){
            int size=q.size();
            int arr[]=new int[size];
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                arr[i]=node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            ops+=minSwaps(arr);
        }
        return ops;
    }
    private int minSwaps(int a[]){
        int n=a.length;
        int swaps=0;
        int temp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            temp[i][0]=a[i];
            temp[i][1]=i;
        }
        Arrays.sort(temp,(c,b)->c[0]-b[0]);
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i] || temp[i][1]==i) continue;
            int cycle=0;
            int j=i;
            while(!vis[j]){
                vis[j]=true;
                j=temp[j][1];
                cycle++;
            }
            if(cycle>1) swaps+=cycle-1;
        }
        return swaps;
    }
}
 
// private int minSwaps(int[] arr) {
//     int n = arr.length;
//     int swaps = 0;

//     int[] sorted = arr.clone();
//     Arrays.sort(sorted);

//     Map<Integer, Integer> indexMap = new HashMap<>();
//     for (int i = 0; i < n; i++) {
//         indexMap.put(arr[i], i);
//     }

//     for (int i = 0; i < n; i++) {
//         if (arr[i] != sorted[i]) {
//             swaps++;

//             int correctIndex = indexMap.get(sorted[i]);

//             // swap in arr
//             int temp = arr[i];
//             arr[i] = arr[correctIndex];
//             arr[correctIndex] = temp;

//             // update map
//             indexMap.put(arr[correctIndex], correctIndex);
//             indexMap.put(arr[i], i);
//         }
//     }

//     return swaps;
// }
// private int minSwaps(int[] arr) {
//     List<Integer> list = new ArrayList<>();
//     for (int x : arr) list.add(x);

//     List<Integer> sorted = new ArrayList<>(list);
//     Collections.sort(sorted);

//     int swaps = 0;

//     for (int i = 0; i < list.size(); i++) {
//         if (!list.get(i).equals(sorted.get(i))) {
//             swaps++;

//             int idx = list.indexOf(sorted.get(i));

//             // swap
//             Collections.swap(list, i, idx);
//         }
//     }

//     return swaps;
// }
