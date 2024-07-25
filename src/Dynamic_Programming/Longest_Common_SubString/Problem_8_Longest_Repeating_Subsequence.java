package Dynamic_Programming.Longest_Common_SubString;

// Problem Statement: Longest Repeating Subsequence
// LeetCode Question:

public class Problem_8_Longest_Repeating_Subsequence {
    // Brute Force Approach
    public int findLRSLength(String str) {
        return findLRSLengthRecursive(str, 0, 0);
    }

    private int findLRSLengthRecursive(String str, int i1, int i2) {
        if(i1 == str.length() || i2 == str.length())
            return 0;

        if(i1 != i2 && str.charAt(i1) == str.charAt(i2))
            return 1 + findLRSLengthRecursive(str, i1+1, i2+1);

        int c1 = findLRSLengthRecursive(str, i1, i2+1);
        int c2 = findLRSLengthRecursive(str, i1+1, i2);

        return Math.max(c1, c2);
    }

    // Top-down Dynamic Programming with Memoization Approach
    public int findLRSLength_2(String str) {
        Integer[][] dp = new Integer[str.length()][str.length()];
        return findLRSLengthRecursive(dp, str, 0, 0);
    }

    private int findLRSLengthRecursive(Integer[][] dp, String str, int i1, int i2) {
        if(i1 == str.length() || i2 == str.length())
            return 0;

        if(dp[i1][i2] == null) {
            if(i1 != i2 && str.charAt(i1) == str.charAt(i2))
                dp[i1][i2] = 1 + findLRSLengthRecursive(dp, str, i1+1, i2+1);
            else {
                int c1 = findLRSLengthRecursive(dp, str, i1, i2+1);
                int c2 = findLRSLengthRecursive(dp, str, i1+1, i2);
                dp[i1][i2] = Math.max(c1, c2);
            }
        }

        return dp[i1][i2];
    }

    // Bottom-up Dynamic Programming Approach
    public int findLRSLength_3(String str) {
        int[][] dp = new int[str.length()+1][str.length()+1];
        int maxLength = 0;
        // dp[i1][i2] will be storing the LRS up to str[0..i1-1][0..i2-1]
        // this also means that subsequences of length zero (first row and column of dp[][]),
        // will always have LRS of size zero.
        for(int i1=1; i1 <= str.length(); i1++) {
            for(int i2=1; i2 <= str.length(); i2++) {
                if(i1 != i2 && str.charAt(i1-1) == str.charAt(i2-1))
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                else
                    dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);

                maxLength = Math.max(maxLength, dp[i1][i2]);
            }
        }
        return maxLength;
    }
}
