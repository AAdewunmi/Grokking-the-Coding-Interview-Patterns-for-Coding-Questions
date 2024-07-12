package Trie;

// Problem Statement: Index Pairs of a String (easy)
// LeetCode Question: 1065. Index Pairs of a String

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_2_Index_Pairs_Of_A_String {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        public TrieNode(){};
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
        }
    }

    public List<List<Integer>> indexPairs(String text, List<String> words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            TrieNode p = trie.root;
            for (int j = i; j < text.length(); j++) {
                char currentChar = text.charAt(j);
                if (p.children[currentChar - 'a'] == null) {
                    break;
                }
                p = p.children[currentChar - 'a'];
                if (p.isEnd) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

}
