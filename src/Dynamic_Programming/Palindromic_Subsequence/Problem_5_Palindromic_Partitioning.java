package Dynamic_Programming.Palindromic_Subsequence;

// Problem Statement: Palindromic Partitioning
// LeetCode Question: 131. Palindrome Partitioning

public class Problem_5_Palindromic_Partitioning {
    // Brute Force Approach
    public int findMPPCuts(String st) {
        return this.findMPPCutsRecursive(st, 0, st.length()-1);
    }

    private int findMPPCutsRecursive(String st, int startIndex, int endIndex) {
        // we don't need to cut the string if it is a palindrome
        if(startIndex >= endIndex || isPalindrome(st, startIndex, endIndex))
            return 0;

        // at max, we need to cut the string into its 'length-1' pieces
        int minimumCuts = endIndex-startIndex;
        for (int i=startIndex; i <= endIndex; i++) {
            if(isPalindrome(st, startIndex, i)){
                // we can cut here as we have a palindrome from 'startIndex' to 'i'
                minimumCuts = Math.min(minimumCuts, 1 + findMPPCutsRecursive(st, i+1, endIndex));
            }
        }
        return minimumCuts;
    }

    private boolean isPalindrome(String st, int x, int y) {
        while(x < y) {
            if(st.charAt(x++) != st.charAt(y--))
                return false;
        }
        return true;
    }

    // Top-down Dynamic Programming with Memoization Approach
    public int findMPPCuts_1(String st) {
        Integer dp[][] = new Integer[st.length()][st.length()];
        Boolean dpIsPalindrome[][] = new Boolean[st.length()][st.length()];
        return this.findMPPCutsRecursive(dp, dpIsPalindrome, st, 0, st.length()-1);
    }

    private int findMPPCutsRecursive(Integer dp[][], Boolean dpIsPalindrome[][],
                                     String st, int startIndex, int endIndex) {

        if(startIndex >= endIndex || isPalindrome(dpIsPalindrome, st, startIndex, endIndex))
            return 0;

        if(dp[startIndex][endIndex] == null) {
            // at max, we need to cut the string into its 'length-1' pieces
            int minimumCuts = endIndex-startIndex;
            for (int i=startIndex; i <= endIndex; i++) {
                if(isPalindrome(dpIsPalindrome, st, startIndex, i)){
                    // we can cut here as we have a palindrome from 'startIndex' to 'i'
                    minimumCuts = Math.min(minimumCuts, 1+findMPPCutsRecursive(dp, dpIsPalindrome, st, i+1, endIndex));
                }
            }
            dp[startIndex][endIndex] = minimumCuts;
        }
        return dp[startIndex][endIndex];
    }

    private boolean isPalindrome(Boolean dpIsPalindrome[][], String st, int x, int y) {
        if(dpIsPalindrome[x][y] == null) {
            dpIsPalindrome[x][y]=true;
            int i=x, j=y;
            while(i < j) {
                if(st.charAt(i++) != st.charAt(j--)) {
                    dpIsPalindrome[x][y]=false;
                    break;
                }
                // use memoization to find if the remaining string is a palindrome
                if(i < j && dpIsPalindrome[i][j] != null) {
                    dpIsPalindrome[x][y] = dpIsPalindrome[i][j];
                    break;
                }
            }
        }
        return dpIsPalindrome[x][y];
    }

    // Bottom-up Dynamic Programming Approach
    public int findMPPCuts_2(String st) {
        // isPalindrome[i][j] will be 'true' if the string from index 'i' to index 'j' is a palindrome
        boolean[][] isPalindrome = new boolean[st.length()][st.length()];

        // every string with one character is a palindrome
        for (int i = 0; i < st.length(); i++)
            isPalindrome[i][i] = true;

        // populate isPalindrome table
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if (endIndex - startIndex == 1 || isPalindrome[startIndex + 1][endIndex - 1]) {
                        isPalindrome[startIndex][endIndex] = true;
                    }
                }
            }
        }

        // now lets populate the second table, every index in 'cuts' stores the minimum cuts needed
        // for the substring from that index till the end
        int[] cuts = new int[st.length()];
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            int minCuts = st.length(); // maximum cuts
            for (int endIndex = st.length() - 1; endIndex >= startIndex; endIndex--) {
                if (isPalindrome[startIndex][endIndex]) {
                    // we can cut here as we got a palindrome
                    // also we dont need any cut if the whole substring is a palindrome
                    minCuts = (endIndex == st.length() - 1) ? 0 : Math.min(minCuts, 1 + cuts[endIndex + 1]);
                }
            }
            cuts[startIndex] = minCuts;
        }

        return cuts[0];
    }
}
