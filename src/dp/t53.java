package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{22:06}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最大子数组和
 */
public class t53 {
    //思路动态规划
    public int maxSubArray(int[] nums) {
        int res = 0;
        //定义dp数组
        int []dp = new int[nums.length];
        //初始化dp数组
        dp[0] = nums[0];res = dp[0];
        //遍历dp数组
        for(int i=1;i< nums.length;i++){
            if(dp[i-1]<=0) dp[i] = nums[i];
            else dp[i] = dp[i-1]+nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
