package hashlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{10:44}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:三数之和
 */
public class t15 {
    //思路：使用三指针
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) break;
            if(i-1>=0&&nums[i-1]==nums[i]) continue;
            int left = i+1, right = nums.length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if (sum>0) right--;
                else if(sum<0) left++;
                else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left<right&&nums[left]==nums[left-1]) left++;
                    while (right>left&&nums[right]==nums[right+1]) right--;
                }
            }
        }
        return res;
    }
}
