package random;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{08}-{16}:{13:34}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二叉树的深度
 */
public class offer55 {
    public int maxDepth(TreeNode root) {
        //层序遍历
        int res = 0;
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int nums = queue.size();
            while (nums>0){
                TreeNode tmp = queue.poll();
                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);
                nums--;
            }
            res++;
        }
        return res;
    }
}
