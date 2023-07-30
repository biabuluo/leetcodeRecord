package retrospect;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{19:30}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t47 {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();
    public int[]used;

    public void backtracking(int []nums, int[] used){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i< nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            if(used[i]==1) continue;
            path.add(nums[i]);
            used[i] = 1;
            backtracking(nums, used);
            path.removeLast();
            used[i] = 0;
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        used = new int[nums.length];
        backtracking(nums, used);
        return res;
    }
}
