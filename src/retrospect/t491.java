package retrospect;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{16:42}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 递增子序列
 */
public class t491 {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();

    public void backtracking(int[]nums, int startIndex){
        if(path.size()>1) res.add(new ArrayList<>(path));
        if(startIndex>=nums.length) return;
        Set<Integer> hashset = new HashSet<>();
        for(int i=startIndex;i<nums.length;i++){
            if(path.size()!=0&&nums[i]<path.get(path.size()-1)||hashset.contains(nums[i]))
                continue;
            path.add(nums[i]);
            backtracking(nums, i+1);
            path.removeLast();
            hashset.add(nums[i]);
        }

    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }
}
