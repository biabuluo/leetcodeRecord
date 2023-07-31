package dp;

/**
 * @author 小宇
 * @date {2023}-{07}-{31}:{10:53}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 使用最小花费爬楼梯
 */
public class t746 {
    public static int minCostClimbingStairs(int[] cost) {
        int []dp = new int [cost.length+1];
        dp[0] = 0; dp[1] = 0;
        for(int i=2;i<=cost.length-1;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        int []cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
