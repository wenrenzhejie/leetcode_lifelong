//二维矩阵区域和：知识点：矩阵前缀和
public class NumMatrix_304 {
    int[][] dp;
    public NumMatrix_304(int[][] matrix) {
        int m = matrix.length;
        if (matrix.length == 0){
            return;
        }
        int n = matrix[0].length;
        dp = new int[m + 1][n + 1];
        //计算前缀和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = matrix[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}
