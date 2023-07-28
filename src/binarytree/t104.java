package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{23:40}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:二叉树最大深度
 */
public class t104 {
    //层序遍历？获取最大层数
    public int maxDepth(TreeNode root) {
        int res = 0;
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); TreeNode node;
        while (!queue.isEmpty()){
            int nums= queue.size();
            while (nums>0){
                node = queue.poll();
                if(nums==1) res+=1;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                nums--;
            }
        }
        return res;
    }
}
