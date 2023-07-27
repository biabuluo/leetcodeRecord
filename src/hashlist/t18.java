package hashlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{12:01}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:四数之和
 */
public class t18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i< nums.length;i++){
            if(nums[i]>target && nums[i]>0 && target>0) break;
            if(i-1>=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j< nums.length;j++){
                if(nums[i]+nums[j]>target && nums[j]>0 && target>0) break;
                if(j-1>i && nums[j]==nums[j-1]) continue;
                int left = j+1, right = nums.length-1;
                while (left<right){
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum > target){
                        right--;
                    } else if (sum < target) {
                        left++;
                    }else{
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        right--;
                        left++;
                        while (left<right && nums[left]==nums[left-1]) left++;
                        while (left<right && nums[right]==nums[right+1]) right--;
                    }
                }
            }
        }
        return  res;
    }
}
