package binarytree;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{10:51}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 翻转二叉树
 */
public class t226 {
    //递归：前中后序遍历均可
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
