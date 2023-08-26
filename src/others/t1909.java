package others;

import java.util.Stack;

/**
 * @author 小宇
 * @date 2023-08-26:11:10
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 删除一个元素使数组严格递增
 */
public class t1909 {
    //思路：遍历
    public boolean canBeIncreasing(int[] nums) {
        if(nums.length==1) return true;
        int num = 1;
        for(int i=0;i<nums.length-1;i++){
            if(num>0 && nums[i+1]<nums[i]){
                num--;
                if(i+2==nums.length){
                    return true;
                }
                if(nums[i+2]>nums[i]){
                    i++;
                }
            }else if(num<=0 && nums[i+1]<nums[i])
                return false;
        }
        return true;
    }
}
