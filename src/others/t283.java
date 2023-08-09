package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{23:07}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 移动零
 */
public class t283 {
    //思路：双指针
    public void moveZeroes(int[] nums) {
        int slow_p = 0;
        for(int fast_p=0;fast_p<nums.length;fast_p++){
            nums[slow_p] = nums[fast_p];
            if(nums[slow_p]!=0) slow_p++;

        }
        for(int i=slow_p;i<nums.length;i++) nums[i] = 0;
    }
}
