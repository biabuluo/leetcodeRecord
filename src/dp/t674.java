package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{16:24}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最长连续递增序列
 */
public class t674 {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        //定义dp数组
        int []dp = new int[nums.length];
        //初始化dp数组
        dp[0] = 1;
        //遍历dp数组
        for(int i=1;i< nums.length;i++){
            if(nums[i]>nums[i-1]) dp[i] = dp[i-1]+1;
            else dp[i] = 1;
            res = Math.max(res, dp[i]);
        }
        return res;

    }
}
