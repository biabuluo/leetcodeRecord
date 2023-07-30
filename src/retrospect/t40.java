package retrospect;

import java.security.PublicKey;
import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{14:26}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 组合总和II
 */
public class t40 {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();
    public int sum = 0;

    public void backtracjing(int []candidates, int target, int startIndex){
        if(sum>=target){
            if(sum==target) res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
            //重点是这个！！！
            if(i>startIndex && candidates[i]==candidates[i-1]) continue;
            path.add(candidates[i]);
            sum+=candidates[i];
            backtracjing(candidates, target, i+1);
            path.removeLast();
            sum-=candidates[i];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracjing(candidates, target, 0);
        return res;

    }
}
