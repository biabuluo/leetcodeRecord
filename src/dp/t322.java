package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{07}:{16:51}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 零钱兑换
 */
public class t322 {
    //排列+完全背包问题
    public int coinChange(int[] coins, int amount) {
        //定义dp数组
        int []dp = new int[amount+1];
        //初始化dp数组
        for(int i=0;i<dp.length;i++) dp[i] = amount+1;
        dp[0] = 0;
        for(int i=coins[0];i<amount+1;i+=coins[0]){
            dp[i] = dp[i-coins[0]]+1;
        }
        //遍历dp数组
        for(int i=1;i<coins.length;i++){
            for(int j=0;j<amount+1;j++){
                if(coins[i]<=j){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
