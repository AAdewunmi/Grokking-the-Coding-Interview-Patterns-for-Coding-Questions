package Dynamic_Programming.Longest_Common_SubString;

// Problem Statement: Longest Common Subsequence
// LeetCode Question: 1143. Longest Common Subsequence

public class Problem_2_Longest_Common_Subsequence {
    // Brute Force Approach
    public int findLCSLength(String s1, String s2) {
        return findLCSLengthRecursive(s1, s2, 0, 0);
    }

    private int findLCSLengthRecursive(String s1, String s2, int i1, int i2) {
        if(i1 == s1.length() || i2 == s2.length())
            return 0;

        if(s1.charAt(i1) == s2.charAt(i2))
            return 1 + findLCSLengthRecursive(s1, s2, i1+1, i2+1);

        int c1 = findLCSLengthRecursive(s1, s2, i1, i2+1);
        int c2 = findLCSLengthRecursive(s1, s2, i1+1, i2);

        return Math.max(c1, c2);
    }

    // Top-down Dynamic Programming with Memoization Approach
    public int findLCSLength_1(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return findLCSLengthRecursive(dp, s1, s2, 0, 0);
    }

    private int findLCSLengthRecursive(Integer[][] dp, String s1, String s2, int i1, int i2) {
        if (i1 == s1.length() || i2 == s2.length())
            return 0;

        if (dp[i1][i2] == null) {
            if (s1.charAt(i1) == s2.charAt(i2))
                dp[i1][i2] = 1 + findLCSLengthRecursive(dp, s1, s2, i1 + 1, i2 + 1);
            else {
                int c1 = findLCSLengthRecursive(dp, s1, s2, i1, i2 + 1);
                int c2 = findLCSLengthRecursive(dp, s1, s2, i1 + 1, i2);
                dp[i1][i2] = Math.max(c1, c2);
            }
        }

        return dp[i1][i2];
    }

    // Bottom-up Dynamic Programming Approach
    static int findLCSLength_2(String s1, String s2) {
        int[][] dp = new int[2][s2.length()+1];
        int maxLength = 0;
        for(int i=1; i <= s1.length(); i++) {
            for(int j=1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i%2][j] = 1 + dp[(i-1)%2][j-1];
                else
                    dp[i%2][j] = Math.max(dp[(i-1)%2][j], dp[i%2][j-1]);

                maxLength = Math.max(maxLength, dp[i%2][j]);
            }
        }
        return maxLength;
    }
}
