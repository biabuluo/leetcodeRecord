package dp;

import javax.swing.*;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{13:43}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t123 {
    public int maxProfit(int[] prices) {
        //定义dp数组
        int [][]dp = new int[prices.length][4];
        //初始化dp数组
        dp[0][0] = 0; dp[0][1] = -prices[0];
        dp[0][2] = 0; dp[0][3] = -prices[0];
        //遍历dp数组
        for(int i=1;i< prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i-1][3]+prices[i], dp[i-1][2]);
            dp[i][3] = Math.max(dp[i-1][0]-prices[i], dp[i-1][3]);
        }
        return dp[prices.length-1][2];
    }
}
