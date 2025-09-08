class TrieNode{
    TrieNode[] children=new TrieNode[26];
    boolean isEnd;
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node=root;
        for(char ch : word.toCharArray()){
            if(node.children[ch-'a']==null){
                node.children[ch-'a']=new TrieNode();
            }
            node=node.children[ch-'a'];
        }
        node.isEnd=true;
    }
    
    private boolean dfs(String word,int idx,TrieNode node){
        if(node==null) return false;
        if(idx==word.length()) return node.isEnd;
        char ch=word.charAt(idx);
        if(ch=='.'){
            for(TrieNode child : node.children){
                if(child!=null && dfs(word,idx+1,child)){
                    return true;
                }
            }
            return false;
        }
        else{
            return dfs(word,idx+1,node.children[ch-'a']);
        }
    }
    public boolean search(String word) {
        return dfs(word,0,root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */