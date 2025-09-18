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
    public TreeNode findMin(TreeNode node){
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val<key) root.right=deleteNode(root.right,key);
        else if(root.val>key) root.left=deleteNode(root.left,key);
        else{
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            //node with 2 children;
            // node with inorder successor 
            TreeNode successor=findMin(root.right);
            root.val=successor.val;
            root.right=deleteNode(root.right,successor.val);
        }
        return root;
    }
}
// When we find the node with key, there are 3 cases:

// Node has no children (leaf):
// → Just remove it (return null).

// Node has one child:
// → Replace node with its single child.

// Node has two children:

// Find inorder successor (minimum value in right subtree).

// Replace node’s value with successor’s value.

// Delete the successor recursively from right subtree.