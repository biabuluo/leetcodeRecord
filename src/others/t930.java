package others;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小宇
 * @date 2023-08-25:9:54
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 和相同的二元子数组
 */
public class t930 {
    //hash解决
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (var i : nums){
            sum += i;
            if(map.containsKey(sum-goal))
                res+=map.get(sum-goal);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}
