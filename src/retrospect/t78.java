package retrospect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{15:34}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:子集问题
 */
public class t78 {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();

    public void backtracking(int []nums, int startIndex){
        res.add(new ArrayList<>(path));
        if(startIndex>=nums.length) return ;
        for(int i=startIndex;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(nums, i+1);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }
}
