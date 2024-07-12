package Trie;

// Problem Statement: Implement Trie (Prefix Tree) (medium)
// LeetCode Question: 208. Implement Trie (Prefix Tree)

public class Problem_1_Implement_Trie_Prefix_Tree {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        public TrieNode(){};
    }

    private TrieNode root;

    public Problem_1_Implement_Trie_Prefix_Tree(TrieNode root) {
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for (char c : word.toCharArray()){
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for (char c : word.toCharArray()){
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()){
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return true;
    }

}
