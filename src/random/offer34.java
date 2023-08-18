package random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{08}-{17}:{15:24}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二叉树中和为某一值的路径
 */
public class offer34 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;
    public void backtracking (TreeNode root, int target){
        if(root==null) return;
        sum += root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(sum == target){
                res.add(new ArrayList<>(path));
            }
        }
        backtracking(root.left, target);
        backtracking(root.right, target);
        path.remove(path.size()-1);
        sum -= root.val;
    }
    //思路：递归
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backtracking(root, target);
        return res;
    }
}
