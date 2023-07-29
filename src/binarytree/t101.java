package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{11:15}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 对称二叉树
 */
public class t101 {

    //思路：使用后序遍历：判断左右子树是否是可翻转的
    public boolean comparefunc(TreeNode left, TreeNode right){
        if(left==null&&right==null) return true;
        else if(left!=null&&right==null||left==null&&right!=null) return false;
        else if(left.val!=right.val) return false;
        boolean res1 = comparefunc(left.left, right.right);
        boolean res2 = comparefunc(left.right, right.left);
        return res1&&res2;
    }


    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        return comparefunc(root.left, root.right);
    }
}
