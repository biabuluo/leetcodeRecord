package random;

import java.util.Arrays;

/**
 * @author 小宇
 * @date 2023-09-09:10:49
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 至少是其它数字两倍的最大数
 */
public class t747 {
    //思路:遍历
    public int dominantIndex(int[] nums) {
        //确定唯一最大数下标
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                maxIndex = i;
                max = nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i==maxIndex)
                continue;
            if(max<nums[i]*2)
                return -1;
        }
        return maxIndex;
    }

}
