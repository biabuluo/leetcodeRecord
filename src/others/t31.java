package others;

import java.util.Arrays;

/**
 * @author 小宇
 * @date {2023}-{08}-{13}:{16:08}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 下一个排列
 */
public class t31 {
    //思路：模拟排列：寻找右边第一个小元素，与右边第一个大元素交换并排序
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-1;i>=0;i--){
            for(int j=nums.length-1;j>i;j--){
                if(nums[i]<nums[j]){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    Arrays.sort(nums, i+1, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
}
