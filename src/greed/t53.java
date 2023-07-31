package greed;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{21:34}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum<0) sum = 0;
            if(sum>res) res = sum;
        }
        return res;
    }
}
