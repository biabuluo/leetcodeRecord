package random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小宇
 * @date {2023}-{08}-{19}:{11:06}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 和为s的两个数组
 */
public class offer57 {
    public int[] twoSum(int[] nums, int target) {
        int []res = {-1, -1};
        //思路：hash
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                res[0] = nums[map.get(nums[i])];
                res[1] = nums[i];
                return res;
            }else {
                map.put(target-nums[i], i);
            }
        }
        return res;
    }
}
