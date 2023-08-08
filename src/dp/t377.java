package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{06}:{23:34}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 组合总和
 */
public class t377 {
    public static void main(String[] args) {
        int []nums = {1,2,3};
        System.out.println(combinationSum4(nums, 4));
    }

    public static int func(int[]nums, int target){
        //定义dp数组
        int []dp = new int[target+1];
        //初始化
        dp[0] = 1;
        //遍历dp
        for(int i=0;i<=target;i++){
            for(int j=0;j< nums.length;j++){
                if(i>=nums[j]){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static int combinationSum4(int[] nums, int target) {
        //定义dp数组
        int [][]dp = new int[nums.length][target+1];
        //初始化dp数组
        for(int i=nums[0];i<=target;i+=nums[0]) dp[0][i] = 1;
        for(int j=0;j<=nums.length-1;j++) dp[j][0] = 1;
        //遍历dp数组
        for(int i=1;i<=target;i++){
            for(int j=1;j< nums.length;j++){
                if(nums[j]<=j)  dp[j][i]+=dp[j-1][i-nums[j]];
            }
        }
        return dp[nums.length-1][target];
    }
}
