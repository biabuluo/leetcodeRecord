package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{07}:{19:32}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:完全平方数
 */
public class t279 {
    //思路：完全背包问题
    public int numSquares(int n) {
        //定义dp数组
        int []dp = new int[n+1];
        //初始化dp数组
        for(int i=1;i<=n;i++){
            dp[i] = i;
        }
        //遍历dp数组
        for(int i=2;i*i<=n;i++){
            for(int j=1;j<=n;j++){
                if(j>=i*i){
                    dp[j] = Math.min(dp[j], dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }
}
