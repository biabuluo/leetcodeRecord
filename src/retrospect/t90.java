package retrospect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{16:03}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 子集II
 */
public class t90 {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();

    public void backtracking(int []nums, int startIndex){
        if(startIndex>=nums.length) return;
        for (int i=startIndex;i<nums.length;i++){
            if(i>startIndex&&nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            backtracking(nums, i+1);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return res;
    }
}
