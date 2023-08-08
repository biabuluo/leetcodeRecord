package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{15:53}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最长递增子序列
 */
public class t300 {
    public static void main(String[] args) {
        int []nums = {0,1,0,3,2,3};
        lengthOfLIS(nums);
    }
    public static int lengthOfLIS(int[] nums) {
        int res = 1;
        //定义dp数组
        int []dp = new int[nums.length];
        //初始化dp数组
        dp[0] = 1;
        for(int i=1;i< nums.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            res = dp[i]>res?dp[i]:res;
        }
        for (int i:dp
             ) {
            System.out.print(i+" ");
        }
        return res;
    }
}
