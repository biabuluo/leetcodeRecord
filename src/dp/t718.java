package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{17:02}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t718 {
    public int findLength(int[] nums1, int[] nums2) {
        int res=0;
        //定义dp数组
        int [][]dp = new int[nums1.length][nums2.length];
        //初始化dp数组
        for(int i=0;i<nums2.length;i++)
            if(nums1[0]==nums2[i]) {
                dp[0][i] = 1;
                res = Math.max(dp[0][i], res);
            }
        for(int i=1;i<nums1.length;i++)
            if(nums2[0]==nums1[i]) {
                dp[i][0] = 1;
                res = Math.max(dp[i][0], res);
            }
        //遍历dp数组
        for(int i=1;i< nums1.length;i++){
            for(int j=1;j<nums2.length;j++){
                if(nums1[i]==nums2[j]) dp[i][j] = dp[i-1][j-1]+1;
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}
