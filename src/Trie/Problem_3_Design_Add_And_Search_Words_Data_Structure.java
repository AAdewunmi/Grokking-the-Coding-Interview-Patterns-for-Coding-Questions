package Trie;

// Problem Statement: Design Add and Search Words Data Structure (medium)
// LeetCode Question: 211. Design Add and Search Words Data Structure

public class Problem_3_Design_Add_And_Search_Words_Data_Structure {

    class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
    }

    private TrieNode root;

    public Problem_3_Design_Add_And_Search_Words_Data_Structure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.children[ch - 'a'] == null) return false;
                node = node.children[ch - 'a'];
            }
        }
        return node.isEnd;
    }

}
