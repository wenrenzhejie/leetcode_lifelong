public class maxSideLength_1292 {
    public int maxSideLength1(int[][] mat, int threshold) {
        //用到的知识点：二维数组的前缀和(矩阵前缀和)
        //首先求前缀和数组dp
        int m = mat.length;
        int n = mat[0].length;
        //额外加一行一列，使得第一行和第一列的矩阵前缀和与其他的求解方式一致
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1;i <= m;i ++){
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
        }
        int res = 0;
        for (int i = 0;i <= m;i ++){
            for (int j = 0;j <= n;j ++) {
                for (int e = res; i + e<= m && j + e <= n; e++) {
                    if (dp[i + e][j + e] - dp[i + e][j] - dp[i][j + e] + dp[i][j] <= threshold){
                        res = res > e?res:e;
                    }else {
                        break;
                    }
                }
            }
        }
        return res;
    }
    /*
    *
    * 前缀和加二分：
    * 二分的思路：正方形的边长越大，元素和越大，相当于一个升序的序列,这个题就转化为在升序的数组中找一个<=threshold的数
    * */
    public int maxSideLength(int[][] mat, int threshold) {
        //首先求前缀和数组dp
        int m = mat.length;
        int n = mat[0].length;
        //额外加一行一列，使得第一行和第一列的矩阵前缀和与其他的求解方式一致
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1;i <= m;i ++){
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
        }
        int res = 0;
        for (int i= 0;i < m;i ++){
            for (int j = 0;j < n;j ++){
                int lowE = 1;
                int highE = Math.min(m - i,n - j);
                while (lowE <= highE){
                    int midE = lowE + (highE - lowE) / 2;
                    if (dp[i + midE][j + midE] -dp[i + midE][j] - dp[i][j + midE] + dp[i][j] > threshold){
                        highE = midE - 1;
                    }else if (dp[i + midE][j + midE] -dp[i + midE][j] - dp[i][j + midE] + dp[i][j] < threshold){
                        res = res > midE?res:midE;
                        lowE = midE + 1;
                    }else {
                        res = res > midE?res:midE;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
