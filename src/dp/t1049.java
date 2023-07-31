package dp;

/**
 * @author 小宇
 * @date {2023}-{07}-{31}:{13:46}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最后一块石头的重量
 */
public class t1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i=0;i<stones.length;i++){
            sum+=stones[i];
        }
        int target = sum/2;
        int []dp = new int [target+1];
        for(int i=0;i<stones.length;i++){
            for(int j=target;j>=stones[i];j--){
                dp[j] = Math.max(dp[j], dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[target];

    }
}
