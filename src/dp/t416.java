package dp;

/**
 * @author 小宇
 * @date {2023}-{07}-{31}:{13:04}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 分割等和子集
 */
public class t416 {
    //一维背包
    public boolean func(int []nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        int target = sum/2;
        int []dp = new int[target+1];
        //初始化
        for(int i=nums[0];i<=target;i++){
            dp[i] = nums[0];
        }
        for(int i=1;i<nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
                if(dp[j]==target) return true;
            }
        }
        if(dp[target]==target) return true;
        else return false;

    }




    //二维背包
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        int target = sum/2;
        int [][]dp = new int[nums.length][target+1];
        //初始化
        for(int i=nums[0];i<=target;i++){
            dp[0][i] = nums[i];
        }
        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=target;j++){
                if(j<nums[i]) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);
                }
                if(dp[i][j]==target) return true;
            }
        }
        if(dp[nums.length-1][target] != target) return false;
        else return true;
    }
}
