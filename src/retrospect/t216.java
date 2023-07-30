package retrospect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{13:46}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t216 {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();

    public void backtracking(int k, int n, int startIndex){
        if(k==0){
            if(n==0) res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<=9;i++){
            path.add(i);
            backtracking(k-1, n-i, i+1);
            path.removeLast();
        }
    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return res;
    }

}
