package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{20:03}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 后序遍历
 */
public class t145 {
    public void postfunc(TreeNode node, List<Integer> res){
        if(node==null) return;
        else {
            postfunc(node.left, res);
            postfunc(node.right, res);
            res.add(node.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postfunc(root, res);
        return res;
    }

    //使用非递归实现后序遍历：思路：使用前序(中，右，左)遍历代码实现后序遍历（）
    public List<Integer> func(TreeNode root){
        List<Integer> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); TreeNode node;
        while (!stack.isEmpty()){
            node = stack.pop();
            if(node==null) continue;
            else {
                res.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
//                stack.push(node.right);
//                stack.push(node.left);
            }
        }
        for(int i= res.size()-1;i>=0;i--){
            tmp.add(res.get(i));
        }
        return tmp;
    }
}
