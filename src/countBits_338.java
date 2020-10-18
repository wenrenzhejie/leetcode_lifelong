public class countBits_338 {

    public int[] countBits(int num) {
        //设dp[i]为i的二进制形式中1的个数,当i为奇数时，dp[i] = dp[i - 1] + 1
        //当i为偶数时,i末位为0，那i就相当于它前面的几位组成的数左移的结果（左移，末位补0）
        //因此i位偶数时，它的1的个数就是它前面的几位组成的数中1的个数
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1;i <= num;i ++){
            if (i % 2 == 0){
                dp[i] = dp[i / 2];
            }else{
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
