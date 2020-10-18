import java.util.ArrayList;
import java.util.List;

public class divisorGame_1025 {
    /*
    * 解法1：递归的方法,记忆化搜索
    * */
    private int count = 1;
    private int dp[];
    public boolean divisorGame(int N) {
        dp = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dp[i] = -1;
        }
        return my_divisorGame(N);
    }
    private boolean my_divisorGame(int number){
        if (number == 1){
            return count % 2 == 0;
        }
        if (dp[number] != -1){
            if (count % 2 == 1){
                return dp[number] == 1;
            }else {
                return dp[number] != 1;
            }
        }
        //获取number的所有公约数
        List<Integer> list = getFactor(number);
        for (int num:list){
            boolean b = my_divisorGame(number - num);
            if (b){
                if (count % 2 == 1){
                    dp[number] = 1;
                }else {
                    dp[number] = 2;
                }
                return true;
            }
        }
        if (count % 2 == 1){
            dp[number] = 2;
        }else {
            dp[number] = 1;
        }
        return false;
    }
    private List<Integer> getFactor(int number){
        count ++;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 2;i < number / 2;i ++){
            if (number % i == 0){
                list.add(i);
            }
        }
        return list;
    }
}
