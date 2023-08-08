package dp;

import javax.swing.*;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{15:44}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 买卖股票最佳时期含手续费
 */
public class t714 {
    public int maxProfit(int[] prices, int fee) {
        //定义dp数组
        int [][]dp = new int[prices.length][2];
        //初始化dp数组
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        //遍历dp数组
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
