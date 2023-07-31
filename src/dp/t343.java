package dp;

/**
 * @author 小宇
 * @date {2023}-{07}-{31}:{11:40}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 整数拆分
 */
public class t343 {
    public int max(int a, int b, int c){
        int max_num = a;
        if(max_num<b) max_num = b;
        if(max_num<c) max_num = c;
        return max_num;
    }
    public int integerBreak(int n) {
        int []dp = new int[59];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i] = max(j*(i-j), j*dp[i-j], dp[i]);
            }
        }
        return dp[n];

    }
}
