package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{15:00}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 买卖股票的最佳时期含冷冻期
 */
public class t309 {
    //思路：动态规划
    public int maxProfit(int[] prices) {
        //定义：dp数组
        int [][]dp = new int[prices.length][4];
        //初始化dp数组
        //0：冷冻期，1：持有股票 2：售出股票 3.未持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = 0;
        //遍历dp数组
        for(int i=1;i< prices.length;i++){
            dp[i][0] = dp[i-1][2];
            dp[i][1] = Math.max(dp[i-1][1], Math.max(dp[i-1][3]-prices[i], dp[i-1][0]-prices[i]));
            dp[i][2] = dp[i-1][1]+prices[i];
            dp[i][3] = Math.max(dp[i-1][0], dp[i-1][3]);
        }
        return Math.max(dp[prices.length-1][0], Math.max(dp[prices.length-1][3], dp[prices.length-1][2]));
    }
}
