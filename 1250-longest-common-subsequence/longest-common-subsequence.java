class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            return longestCommonSubsequence(text2, text1);
        }
        int[] dp = new int[text2.length() + 1];
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        for (char c1 : ch1) {
            int prevDiag = 0;
            for (int j = 1; j < dp.length; j++) {
                int tmp = dp[j];
                dp[j] = c1 == ch2[j - 1] ? prevDiag + 1 : Math.max(dp[j], dp[j - 1]);
                prevDiag = tmp;
            }
        }
        return dp[dp.length - 1];
    }
}