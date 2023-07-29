package binarytree;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{14:57}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 平衡二叉树
 */
public class t110 {

    public int func(TreeNode node){
        if(node==null) return 0;
        int height_l=0, height_r = 0;
        height_l = func(node.left);
        if(height_l==-1) return -1;
        height_r = func(node.right);
        if(height_r==-1) return -1;
        if(Math.abs(height_l-height_r)>1) return -1;
        else return Math.max(height_l, height_r)+1;
    }
    //思路后序遍历
    public boolean isBalanced(TreeNode root) {
        if(func(root)!=-1) return true;
        else return false;
    }
}
