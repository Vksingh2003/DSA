class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] dp = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            int prev = 0;
            char c = chars[i];
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (c == chars[j]) {
                    dp[j] = prev + 2;
                } else {
                    int left = dp[j - 1];
                    if (left > dp[j]) {
                        dp[j] = left;
                    }
                }
                prev = temp;
            }
        }
        return dp[n - 1];
    }
}