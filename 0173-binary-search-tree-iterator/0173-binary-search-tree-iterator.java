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
class BSTIterator {
    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        pushLeft(root);
    }
    public  void pushLeft(TreeNode node){
        while(node!=null){
            st.push(node);
            node=node.left;
        }
    }
    public int next() {
        TreeNode node =st.pop();
        if(node.right!=null){
            pushLeft(node.right);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}


// 1. Brute Force: Store Full Inorder
// Do an inorder traversal once.
// Store all values in an array.
// Maintain an index pointer for next().

// \U0001f449 Example:
// Inorder list = [3, 7, 9, 15, 20]
// next() just returns list[index++].
// hasNext() checks index < list.size()
// class BSTIterator {
//     private List<Integer> inorder;
//     private int index;

//     public BSTIterator(TreeNode root) {
//         inorder = new ArrayList<>();
//         index = 0;
//         dfs(root);
//     }

//     private void dfs(TreeNode node) {
//         if (node == null) return;
//         dfs(node.left);
//         inorder.add(node.val);
//         dfs(node.right);
//     }

//     public int next() {
//         return inorder.get(index++);
//     }

//     public boolean hasNext() {
//         return index < inorder.size();
//     }
// }

// 2. Optimized Approach (Using Stack, O(h) space) → ✅ Standard Solution

// Instead of storing all elements, we only store the left path at each point (like simulating recursion stack).

// \U0001f539 Idea

// Always keep track of the next smallest element using a stack.

// Initially, push all the left children from root down to the leftmost node.

// For next():

// Pop from stack → that’s the smallest node left.

// If that node has a right child, push its right child and its entire left path onto stack.

// For hasNext(): return true if stack is not empty.
    //    7
    //   / \
    //  3   15
    //     /  \
    //    9    20
//     Initialization (constructor):

// Push root (7), then keep pushing left → [7, 3]
// (Stack top is 3, bottom is 7).

// Now operations:

// next() → pop 3 → return 3.
// Stack: [7].

// next() → pop 7 → return 7.
// 7 has right child (15) → push 15, then its left chain → [15, 9].

// next() → pop 9 → return 9.
// Stack: [15].

// next() → pop 15 → return 15.
// 15 has right child (20) → push 20.
// Stack: [20].

// next() → pop 20 → return 20.
// Stack empty.

// So output sequence = [3, 7, 9, 15, 20] ✅ Correct.

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */