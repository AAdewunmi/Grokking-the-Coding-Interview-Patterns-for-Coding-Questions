package Trie;

// Problem Statement: Extra Characters in a String (medium)
// LeetCode Question: 2707. Extra Characters in a String

public class Problem_4_Extra_Characters_In_A_String {

    class TrieNode {
     TrieNode[] children = new TrieNode[26];
     boolean isEnd = false;
    }

    // Method to calculate minimum extra characters.
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = buildTrie(dictionary);
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;
            TrieNode node = root;
            for (int end = start; end < n; end++) {
                if (node.children[s.charAt(end) - 'a'] == null) {
                    break;
                }
                node = node.children[s.charAt(end) - 'a'];
                if (node.isEnd) {
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }
        return dp[0];
    }

    // Method to build the trie from the dictionary.
    private TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }
        return root;
    }

}
