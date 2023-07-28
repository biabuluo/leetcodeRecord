package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{23:46}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t111 {
    public int minDepth(TreeNode root) {
        int res = 1;
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()){
            int nums = queue.size();
            while (nums>0){
                node = queue.poll();
                if(node.left==null&&node.right==null){
                    return res;
                }
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                nums--;
            }
            res++;
        }
        return res;
    }
}
