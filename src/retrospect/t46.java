package retrospect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{16:53}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 全排列
 */
public class t46 {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();
    public int[]used;

    public void backtracking(int []nums, int[] used){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i< nums.length;i++){
            if(used[i]==1) continue;
            path.add(nums[i]);
            used[i] = 1;
            backtracking(nums, used);
            path.removeLast();
            used[i] = 0;
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        used = new int[nums.length];
        backtracking(nums, used);
        return res;
    }
}
