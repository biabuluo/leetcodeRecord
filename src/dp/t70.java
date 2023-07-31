package dp;

/**
 * @author 小宇
 * @date {2023}-{07}-{31}:{10:48}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 爬楼梯
 */
public class t70 {
    public int climbStairs(int n) {
        int[] dp = new int[46];
        dp[0] = 0;dp[1] = 1;dp[2] = 2;
        if(n<=2) return dp[n];
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
