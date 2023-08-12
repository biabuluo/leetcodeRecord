package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{10}:{11:56}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 寻找数组中心下标
 */
public class t724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            int leftsum, rightsum;
            if(i==0)leftsum = 0;
            else leftsum = nums[i-1];
            rightsum = sum-leftsum-nums[i];
            if(leftsum==rightsum) return i;
            if (i!=0)nums[i] +=nums[i-1];
        }
        return -1;
    }
}
