package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{22:35}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二叉树的右视图
 */
public class t199 {
    //思路：层序遍历获取最后一个元素
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()){
            int nums = queue.size();
            while (nums>0){
                if(nums==1) res.add(queue.peek().val);
                node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                nums--;
            }
        }
        return res;
    }
}
