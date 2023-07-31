package dp;

/**
 * @author 小宇
 * @date {2023}-{07}-{31}:{10:45}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 斐波那契
 */
public class t509 {
    public int fib(int n) {
        int []dp = new int[31];
        dp[0] = 0;
        dp[1] = 1;
        if(n<=1) return dp[n];
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
