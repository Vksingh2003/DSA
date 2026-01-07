class Solution {
    public int rob(int[] nums) {
        int prev1 = 0; // dp[i-1]
        int prev2 = 0; // dp[i-2]

        for (int money : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + money);
            prev2 = temp;
        }
        return prev1;
    }
}
