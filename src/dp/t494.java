package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{06}:{15:50}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: t494 目标和
 */
public class t494 {
    //思路：l+r=sum,l-r=t,l+l-t=sum,l=(sum+t)/2;
    public static void main(String[] args) {
        int []nums = {1000};
        int target = -1000;
        System.out.println(findTargetSumWays(nums, target));
    }


    public static int findTargetSumWays(int[] nums, int target) {
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if((sum+target)%2!=0) return 0;
        target = (sum+target)/2;
        int [][]dp = new int[nums.length][target+1];
        //初始化
        for(int j = 0; j <= target; j++) {
            if(nums[0] == j) {
                dp[0][j] = 1;
            }
        }

        int numZeros = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                numZeros++;
            }
            dp[i][0] = (int) Math.pow(2, numZeros);
        }
        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=target;j++){
                if(j<nums[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i]];
            }
        }
        return dp[nums.length-1][target];

    }
}
