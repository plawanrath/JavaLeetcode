class Trie {
    Trie[] nodes;
    boolean isWord;

    /** Initialize your data structure here. */
    public Trie() {
        nodes = new Trie[26];  
        isWord = false;  
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for(char c : word.toCharArray()) {
            if(curr.nodes[c - 'a'] == null) {
                curr.nodes[c - 'a'] = new Trie();
            }
            curr = curr.nodes[c - 'a'];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for(char c : word.toCharArray()) {
            if(curr.nodes[c - 'a'] == null) {
                return false;
            }
            curr = curr.nodes[c - 'a'];
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for(char c : prefix.toCharArray()) {
            if(curr.nodes[c - 'a'] == null)
                return false;
            curr = curr.nodes[c - 'a'];
        }
        return true;
    }
}