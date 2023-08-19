package random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{08}-{19}:{14:00}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 从上到下打印二叉树
 */
public class offer32II {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    //思路：层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return res;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            path.clear();
            while (size>0){
                TreeNode node = queue.poll();
                path.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);

                size--;
            }
            res.add(new ArrayList<>(path));
        }
        return res;
    }
}
