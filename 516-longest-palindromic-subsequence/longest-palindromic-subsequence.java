class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int dp[][] = new int[n+1][n+1];

        return lcs(s, s2, n, n, dp);
    }
        private int lcs(String s, String s2, int n, int m, int[][] dp){

            for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
        }

}