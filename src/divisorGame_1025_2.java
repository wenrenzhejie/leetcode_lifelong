public class divisorGame_1025_2 {
    //动态规划方法解决该题
    /*
    * n = 1时，alice无法操作，alice必败
    * n = 2时，alice可选1，此时n = 1，根据n = 1可知，bob必败，alice胜
    * n = 3时，Alice可选1，此时n = 2，根据n = 2可知，bob胜，alice必败
    * n = 4时，alice可选1、2，当选1时，此时n = 3，根据n = 3可知，bob必败，alice胜，
    * 当选2时，此时n = 2，根据n=2可知bob胜，alice败
    * */
    public boolean divisorGame(int N) {
        if (N == 1){
            return false;
        }
        if (N == 2){
            return true;
        }
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3;i <= N;i++){
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0 && dp[i - j]){
                    if (i % 2 == 0){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[N];
    }
}
