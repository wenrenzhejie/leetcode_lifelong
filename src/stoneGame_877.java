import java.util.Arrays;

public class stoneGame_877 {
    //使用【相对分数】解决这个问题
    //【相对分数】即自己得分为正，对方相对自己得分为负
    //记忆化搜索的编码
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        //memo记录子区间[left,right]中先手得到的相对分数
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i],Integer.MIN_VALUE);
            memo[i][i] = piles[i];
        }
        return stoneGame(piles,0,n - 1,memo) > 0;
    }
    private int stoneGame(int[] piles,int left,int right,int[][] memo){
        if (left == right){
            memo[left][right] = piles[left];
            return memo[left][right];
        }
        if (memo[left][right] != Integer.MIN_VALUE){
            return memo[left][right];
        }
        int chooseLeft = piles[left] - stoneGame(piles,left + 1,right,memo);
        int chooseRight = piles[right] - stoneGame(piles,left,right + 1,memo);
        memo[left][right] = Math.max(chooseLeft,chooseRight);
        return memo[left][right];
    }
}
