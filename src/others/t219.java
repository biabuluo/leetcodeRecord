package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 小宇
 * @date 2023-08-25:10:30
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 存在重复元素II
 */
public class t219 {
    //思路：hash
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //目标值-下标
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                List<Integer> list = map.get(nums[i]);
                for(var idx : list){
                    if(Math.abs(i-idx)<=k)
                        return true;
                }
            }
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            if(list.size()==0) {
                list.add(i);
                map.put(nums[i], list);
            }else list.add(i);

        }
        return false;
    }
}
