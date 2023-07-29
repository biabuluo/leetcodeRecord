package binarytree;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{22:13}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二叉搜索树中的搜索
 */
public class t700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(root.val == val) return root;
        else if(root.val>val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
