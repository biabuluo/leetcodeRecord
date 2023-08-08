package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{14:26}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 买卖股票最佳时间
 */
public class t188 {
    public int maxProfit(int k, int[] prices) {
        //定义dp数组
        int [][]dp = new int[prices.length][2*k+1];
        //初始化dp数组
        for(int i=1;i<=2*k;i++){
            if(i%2==0) dp[0][i] = 0;  //偶数未持有
            else dp[0][i] = -prices[0];  //奇数持有
        }
        //遍历dp数组
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=2*k;j++){
                if(j%2==0){  //未持有
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]+prices[i]);
                }  //持有
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]-prices[i]);
            }
        }
        return dp[prices.length-1][2*k];
    }
}
