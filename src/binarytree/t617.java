package binarytree;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{21:55}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 合并二叉树
 */
public class t617 {
    //还是递归
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
