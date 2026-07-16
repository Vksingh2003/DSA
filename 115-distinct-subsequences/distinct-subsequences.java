import java.util.Arrays;

class Solution {

    private int recursive(int i, int j, String s, String t){
        if(j < 0){
            return 1;
        }

        if(i < 0){
            return 0;
        }

        if(s.charAt(i) == t.charAt(j)){
            return recursive(i-1, j-1, s, t) + recursive(i-1, j, s, t);
        }

        return recursive(i-1, j, s, t);
    }

    private int memoization(int i, int j, String s, String t, int[][] dp){
        if(j == 0){
            return 1;
        }

        if(i == 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i-1) == t.charAt(j-1)){
            return dp[i][j] = memoization(i-1, j-1, s, t, dp)
                    + memoization(i-1, j, s, t, dp);
        }

        return dp[i][j] = memoization(i-1, j, s, t, dp);
    }

    private int tabulation(String s, String t){

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        for(int j = 1; j <= m; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }

    private int SpaceOptimized2D(String s, String t){

        int n = s.length();
        int m = t.length();

        int[] prev = new int[m+1];
        prev[0] = 1;

        for(int i = 1; i <= n; i++){

            int[] curr = new int[m+1];
            curr[0] = 1;

            for(int j = 1; j <= m; j++){

                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }

            prev = curr;
        }

        return prev[m];
    }

    private int SpaceOptimized1D(String s, String t){

        int n = s.length();
        int m = t.length();

        int[] prev = new int[m+1];
        prev[0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = m; j >= 1; j--){

                if(s.charAt(i-1) == t.charAt(j-1)){
                    prev[j] = prev[j-1] + prev[j];
                }
            }
        }

        return prev[m];
    }

    public int numDistinct(String s, String t){

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        // return recursive(n-1, m-1, s, t);
        // return memoization(n, m, s, t, dp);
        // return tabulation(s, t);
        // return SpaceOptimized2D(s, t);
        return SpaceOptimized1D(s, t);
    }
}