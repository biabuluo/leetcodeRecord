package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{20:06}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:中序遍历
 */
public class t94 {
    public void infunc(TreeNode node, List<Integer> res){
        if(node==null) return;
        else {
            infunc(node.left, res);
            res.add(node.val);
            infunc(node.right, res);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        infunc(root, res);
        return res;
    }

    //使用非递归法：栈模拟递归
    public List<Integer> func(TreeNode root){
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur!=null || stack.size()!=0){
            if(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
