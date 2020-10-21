public class divisorGame_1025_3 {
    Boolean[] memo;
    public boolean divisorGame(int N) {
        memo = new Boolean[N + 1];
        return dfs(N);
    }
    private boolean dfs(int n){
        if (n == 1){
            return false;
        }
        if (n == 2){
            return true;
        }
        if (memo[n] != null){
            return memo[n];
        }
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0){
                if (!dfs(n - i)){
                    memo[n] = true;
                    return true;
                }
            }
        }
        memo[n] = false;
        return false;
    }
}
