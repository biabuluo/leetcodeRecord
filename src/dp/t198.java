package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{07}:{22:33}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 打家结舍
 */
public class t198 {
    //2112这种情况就不能贪心了
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int []dp = new int[nums.length];
        //初始化dp数组
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //遍历dp数组
        for(int i=2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
