/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node,Node> hm=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        // dfs has cycles repeated nodes may occur in recursion so 
        // return it if already exits
        if(hm.containsKey(node)) return hm.get(node);
        // CLONE THIS NODE
        Node clone=new Node(node.val);
        hm.put(node,clone);
        for(Node x: node.neighbors) {
            clone.neighbors.add(cloneGraph(x));
        }
        return clone;
    }
}
// Problem Restatement: We need to deep-copy a graph, making sure cycles don’t cause infinite recursion.

// Main Idea: Use a HashMap to store already-cloned nodes and avoid duplication.

// DFS vs BFS:

// DFS → recursive, elegant but uses stack.

// BFS → iterative, safe for very deep graphs.

// Complexity: Both take O(V+E) time and O(V) space.