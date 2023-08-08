package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{06}:{22:33}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 零钱兑换
 */
public class t518 {

    public int func(int amount, int[] coins){
        //定义dp数组
        int []dp = new int [amount+1];
        //初始化dp数组
        dp[0] = 1;
        for(int i=1;i<coins.length;i++){
            for(int j=1;j<amount+1;j++){
                dp[j] += coins[j-coins[i]];
            }
        }
        return dp[amount];
    }

    public int change(int amount, int[] coins) {
        //定义dp数组
        int [][]dp = new int[coins.length][amount+1];
        //初始化dp数组
        for (int i=0;i<amount+1;i+=coins[0]){
            dp[0][i] = 1;
        }
        for(int i=0;i<coins.length;i++){
            dp[i][0] = 1;
        }
        //遍历dp数组
        for(int i=1;i<coins.length;i++){
            for(int j=1;j<amount+1;j++){
                for(int k=0;k*coins[i]<=j;k++){
                    dp[i][j] += dp[i-1][j-k*coins[i]];
                }
            }
        }
        return dp[coins.length-1][amount];

    }
}
