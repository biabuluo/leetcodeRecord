package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{12:03}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 买卖股票的最佳时机
 */
public class t121 {
    //思路：动态规划
    public static int func(int [] prices){
        int [][]dp = new int[prices.length][2];
        //初始化dp数组
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        //遍历dp数组
        for(int i=1;i<prices.length;i++){
            //不持有股票
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            //持有股票
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }


    //思路：动态规划
    public int maxProfit(int[] prices) {
        //定义dp数组
        int []dp = new int[prices.length];
        //初始化dp数组
        dp[0] = 0; int res = 0;
        //遍历dp数组
        for(int i=1;i< prices.length;i++){
            dp[i] = Math.max(dp[i-1]+prices[i]-prices[i-1], dp[i]);
            if(dp[i]>res) res = dp[i];
        }
        return res;
    }
}
