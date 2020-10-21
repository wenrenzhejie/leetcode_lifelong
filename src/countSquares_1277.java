public class countSquares_1277 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //计算矩阵的前缀和
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = matrix[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
        }
        int res = 0;
        int minE = Math.min(m,n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int e = 1; e <= minE; e++) {
                    if (i + e > m || j + e > n){
                        break;
                    }
                    int sumRegion = dp[i + e][j + e] - dp[i + e][j] - dp[i][j + e] + dp[i][j];
                    System.out.println(sumRegion);
                    if (sumRegion == e * e){
                        res ++;
                        System.out.println("["+i+","+j+"]"+":e:"+e);
                    }else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
