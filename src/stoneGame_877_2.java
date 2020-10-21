public class stoneGame_877_2 {
    //动态规划的方式
    //dp[i][j]：表示在[i...j]区间，先手得到的最大相对分数，其中i<=j
    //状态转移方程：dp[i][j] = max{piles[i] - dp[i+1][j],piles[j] - dp[i][j - 1]}
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = n - 2;i >= 0;i --){
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j],piles[i] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}
