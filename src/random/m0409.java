package random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{08}-{19}:{11:26}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二叉搜索树序列
 */
public class m0409 {
    //题目意思：每个结点都必须排在子孙结点前面
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    public void backtracking(LinkedList<TreeNode> queue){
        if(queue.isEmpty()){
            res.add(new ArrayList<>(path));
        }
        for(int i=0;i<queue.size();i++){
            LinkedList<TreeNode> thisqueue = new LinkedList<>(queue);
            TreeNode tmp = thisqueue.remove(i);
            path.add(tmp.val);
            if(tmp.left!=null) thisqueue.add(tmp.left);
            if(tmp.right!=null) thisqueue.add(tmp.right);
            if(thisqueue.size()<queue.size()-1)
                backtracking(thisqueue);
            path.remove(path.size()-1);
        }
    }

    //思路：层序遍历+回溯
    public List<List<Integer>> BSTSequences(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null){
            res.add(path);
            return res;
        }
        queue.add(root);
        backtracking(queue);
        return res;
    }
}
