package greed;

import java.util.Arrays;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{22:19}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: K次取反后最大化的数组和
 */
public class t1005 {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int counter = k;
        for (int i=0;i<nums.length;i++) {
            if(nums[i]>=0) break;
            if(counter>0&&nums[i]<0) {
                nums[i] = -nums[i];
                counter--;
            }
        }
        Arrays.sort(nums);
        counter %=2;
        if(counter>0){
            for(int i=0;i<nums.length;i++){
                nums[i] = -nums[i];
                counter--;
                if (counter==0) break;
            }
        }
        int res = 0;
        for (int i:nums) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        int []nums = {2,-3,-1,5,-4};
        System.out.println(largestSumAfterKNegations(nums, 2));
    }
}
