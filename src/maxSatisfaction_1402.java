import java.util.Arrays;

public class maxSatisfaction_1402 {
    public int maxSatisfaction(int[] satisfaction) {
        //贪心 假如只做一道菜的话，我们从中选出最大的s0
        //做两道菜的话，选出次大的s1，这时的满意程度总和s1 + 2s0要满足s1 + 2s0 > s0
        //即s1+s0>0的时候才会选择做这道菜
        /*
        * s0：此时判别s0
        * s1 + 2s0:此时判别s1 + s0 < 0?
        * s2 + 2s1 +3s0：此时判别s2 + s1 + s0 < 0?
        * 可以找到规律得出结果，下面代码中的ans即代表每次的判别式
        * */
        Arrays.sort(satisfaction);
        int res = 0;
        int ans = 0;
        for (int i = satisfaction.length - 1;i >= 0;i --){
            if (ans + satisfaction[i] < 0){
                break;
            }
            ans += satisfaction[i];
            res += ans;
        }
        return res;
    }

    public static void main(String[] args) {
        new maxSatisfaction_1402().maxSatisfaction(new int[]{1,3,5,6,4});
    }
}
