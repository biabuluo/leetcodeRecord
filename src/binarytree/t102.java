package binarytree;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{21:40}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二叉树的层序遍历（广搜索）
 */
public class t102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return res;
        else {
            TreeNode node;
            queue.add(root);
            while (!queue.isEmpty()){
                List<Integer> group = new ArrayList<>();
                int nums = queue.size();
                while (nums>0){
                    node = queue.poll();
                    group.add(node.val);
                    if(node.left!=null) queue.add(node.left);
                    if(node.right!=null) queue.add(node.right);
                    nums--;
                }
                res.add(group);
            }
        }
        return res;
    }
}
