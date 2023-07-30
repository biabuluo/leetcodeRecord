package retrospect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{14:11}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 组合总和
 */
public class t39 {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();
    public int sum = 0;
    public void backtacking(int[]candidates, int target, int startIndex){
        if(sum>=target){
            if(sum==target) res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i< candidates.length;i++){
            path.add(candidates[i]);
            sum+=candidates[i];
            backtacking(candidates, target, i);
            path.removeLast();
            sum-=candidates[i];
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtacking(candidates, target, 0);
        return res;
    }
}
