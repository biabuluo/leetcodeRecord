package retrospect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{13:02}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t77 {

    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();

    //回溯
    public void backtracking(int n, int k, int startIndex ){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int i=startIndex;i<=n;i++){
            path.add(i);
            backtracking(n, k, i+1);
            path.removeLast();
        }
    }


    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }
}
