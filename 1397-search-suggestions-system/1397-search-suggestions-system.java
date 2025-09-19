class Solution {
    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        List<String> sug=new ArrayList<>();
    }
    public void insert(String s, TrieNode root){
        TrieNode node=root;
        for(char c: s.toCharArray()){
            int idx=c-'a';
            if(node.children[idx]==null){
                node.children[idx]=new TrieNode();
            }
            node=node.children[idx];
            if(node.sug.size()<3){
                node.sug.add(s);
            }
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TrieNode root=new TrieNode();
        for(String s : products){
            insert(s,root);
        }
        List<List<String>> res=new ArrayList<>();
        TrieNode node=root;
        for(char c: searchWord.toCharArray()){
            if(node!=null){
                node=node.children[c-'a'];
            }
            res.add(node==null? new ArrayList<>(): node.sug);
        }
        return res;
    }
}
/*Approach 1: Sort + Binary Search (Optimal)

Sort products lexicographically.

For each prefix of searchWord:

Use binary search (lower_bound) to find the first product that starts with this prefix.

Take up to 3 products from that index that match the prefix.

Complexity: O(n log n + m log n)

Sorting: O(n log n)

Each of m prefixes: binary search + check at most 3 items.

✅ This is the most common and accepted solution.
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // sort lexicographically
        List<List<String>> res = new ArrayList<>();
        int n = products.length;

        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            int idx = lowerBound(products, prefix); // find first >= prefix
            List<String> suggestions = new ArrayList<>();
            
            for (int j = idx; j < n && suggestions.size() < 3; j++) {
                if (products[j].startsWith(prefix)) {
                    suggestions.add(products[j]);
                } else break;
            }
            res.add(suggestions);
        }
        return res;
    }

    // standard binary search lower_bound
    private int lowerBound(String[] products, String target) {
        int l = 0, r = products.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (products[mid].compareTo(target) < 0) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
*/
