package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{12}:{19:17}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最长递增子序列的个数
 */
public class t673 {
    //思路：动态规划
    public int findNumberOfLIS(int[] nums) {
        if (nums.length<=1) return nums.length;
        int maxlen = 0;
        int res = 0;
        //定义dp数组
        int []dp = new int[nums.length];
        int []count = new int[nums.length];
        //初始化dp数组
        for(int i=0;i<nums.length;i++) {
            dp[i] = 1;
            count[i] = 1;
        }
        //遍历dp数组
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    }else if(dp[j]+1==dp[i])
                        count[i] += count[j];
                maxlen = Math.max(maxlen, dp[i]);
            }
        }
        //获取结果
        for(int i=0;i<nums.length;i++){
            if(dp[i]==maxlen) res+=count[i];
        }
        return res;
    }
}
