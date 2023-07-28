package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{19:05}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二叉树的前序遍历
 */
public class t144 {
    public void prefunc(TreeNode node, List<Integer> res){
        if(node==null) return ;
        else {
            res.add(node.val);
            prefunc(node.left, res);
            prefunc(node.right, res);
        }
    }
    //使用递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        prefunc(root, res);
        return res;
    }

    //使用非递归-栈模拟递归
    public List<Integer> func(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); TreeNode node;
        while (!stack.isEmpty()){
            node = stack.pop();
            if(node==null) continue;
            else {
                res.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return res;
    }
}
