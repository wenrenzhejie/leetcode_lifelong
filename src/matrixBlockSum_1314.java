//知识点：矩阵前缀和
public class matrixBlockSum_1314 {
    public int[][] matrixBlockSum1(int[][] mat, int K) {
        int m = mat.length,n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = 0;i <= m - 1;i ++){
            for (int j = 0;j <= n - 1;j ++){
                int lrow = Math.max(0,i - K);
                int hrow = Math.min(i + K,m - 1);
                int lcol = Math.max(0,j - K);
                int hcol = Math.min(j + K,n - 1);
                int sum = 0;
                for (int r = lrow;r <= hrow;r ++){
                    for (int c = lcol;c <= hcol;c ++){
                        sum += mat[r][c];
                    }
                }
                res[i][j] = sum;
            }
        }
        return res;
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {
        //首先计算矩阵前缀和
        int m = mat.length,n = mat[0].length;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1;i <= m;i ++){
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //计算有效区域的左上角坐标
                int row1 = Math.max(0,i - K);
                int col1 = Math.max(0,j - K);
                //计算有效区域的右下角坐标
                int row2 = Math.min(m - 1,i + K);
                int col2 = Math.min(n - 1,j + K);
                //计算这个矩形区域的和
                res[i][j] = dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1]
                        + dp[row1][col1];
            }
        }
        return res;
    }
}
