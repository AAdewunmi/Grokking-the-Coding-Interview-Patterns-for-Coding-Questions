package Dynamic_Programming.Longest_Common_SubString;

// Problem Statement: Longest Alternating Subsequence
// LeetCode Question:

public class Problem_11_Longest_Alternating_Subequence {
    // Brute Force Approach
    public int findLASLength(int[] nums) {
        // we have to start with two recursive calls, one where we will consider that the first element is
        // bigger than the second element and one where the first element is smaller than the second element
        return Math.max(findLASLengthRecursive(nums, -1, 0, true),
                findLASLengthRecursive(nums, -1, 0, false));
    }

    private int findLASLengthRecursive(int[] nums, int previousIndex, int currentIndex, boolean isAsc) {
        if(currentIndex == nums.length)
            return 0;

        int c1=0;
        // if ascending, the next element should be bigger
        if(isAsc) {
            if(previousIndex == -1 || nums[previousIndex] < nums[currentIndex])
                c1 = 1 + this.findLASLengthRecursive(nums, currentIndex, currentIndex+1, !isAsc);
        } else { // if descending, the next element should be smaller
            if(previousIndex == -1 || nums[previousIndex] > nums[currentIndex])
                c1 = 1 + this.findLASLengthRecursive(nums, currentIndex, currentIndex+1, !isAsc);
        }
        // skip the current element
        int c2 = this.findLASLengthRecursive(nums, previousIndex, currentIndex+1, isAsc);
        return Math.max(c1,c2);
    }

    // Top-down Dynamic Programming with Memoization
    public int findLASLength_1(int[] nums) {
        Integer[][][] dp = new Integer[nums.length][nums.length][2];
        return Math.max(findLASLengthRecursive(dp, nums, -1, 0, true),
                findLASLengthRecursive(dp, nums, -1, 0, false));
    }

    private int findLASLengthRecursive(Integer[][][] dp, int[] nums,
                                       int previousIndex, int currentIndex, boolean isAsc) {

        if(currentIndex == nums.length)
            return 0;

        if(dp[previousIndex+1][currentIndex][isAsc ? 1 : 0] == null) {
            int c1=0;
            // if ascending, the next element should be bigger
            if(isAsc) {
                if(previousIndex == -1 || nums[previousIndex] < nums[currentIndex])
                    c1 = 1 + this.findLASLengthRecursive(dp, nums, currentIndex, currentIndex+1, !isAsc);
            } else { // if descending, the next element should be smaller
                if(previousIndex == -1 || nums[previousIndex] > nums[currentIndex])
                    c1 = 1 + this.findLASLengthRecursive(dp, nums, currentIndex, currentIndex+1, !isAsc);
            }
            // skip the current element
            int c2 = this.findLASLengthRecursive(dp, nums, previousIndex, currentIndex+1, isAsc);
            dp[previousIndex+1][currentIndex][isAsc ? 1 : 0] = Math.max(c1,c2);
        }

        return dp[previousIndex+1][currentIndex][isAsc ? 1 : 0];
    }

    // Bottom-up Dynamic Programming
    public int findLASLength_2(int[] nums) {
        if(nums.length == 0) return 0;
        //dp[i][0] = stores the LAS ending at 'i' such that the last two elements are in ascending order
        //dp[i][1] = stores the LAS ending at 'i' such that the last two elements are in descending order
        int[][] dp = new int[nums.length][2];
        int maxLength = 1;
        for(int i=0; i < nums.length; i++) {
            // every single element can be considered as LAS of length 1
            dp[i][0] = dp[i][1] = 1;
            for(int j=0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    // if nums[i] is BIGGER than nums[j] then we will consider the LAS ending at 'j' where the
                    // last two elements were in DESCENDING order
                    dp[i][0] = Math.max(dp[i][0], 1 + dp[j][1]);
                    maxLength = Math.max(maxLength, dp[i][0]);
                } else if (nums[i] != nums[j]) { // if the numbers are equal don't do anything
                    // if nums[i] is SMALLER than nums[j] then we will consider the LAS ending at 'j' where the
                    // last two elements were in ASCENDING order
                    dp[i][1] = Math.max(dp[i][1], 1 + dp[j][0]);
                    maxLength = Math.max(maxLength, dp[i][1]);
                }
            }
        }
        return maxLength;
    }
}
