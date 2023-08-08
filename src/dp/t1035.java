package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{21:35}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 不相交的线
 */
public class t1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //定义dp数组
        int [][]dp = new int[nums1.length][nums2.length];
        //初始化dp数组
        for(int i=0;i<nums2.length;i++){
            if(nums1[0]==nums2[i]) dp[0][i] = 1;
            else if(i>=1)dp[0][i] = dp[0][i-1];
        }
        for(int i=0;i<nums1.length;i++){
            if(nums2[0]==nums1[i]) dp[i][0] = 1;
            else if(i>=1)dp[i][0] = dp[i-1][0];
        }
        //遍历dp数组
        for(int i=1;i<nums1.length;i++){
            for(int j=1;j<nums2.length;j++){
                if(nums1[i]==nums2[j]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[nums1.length-1][nums2.length-1];
    }
}
