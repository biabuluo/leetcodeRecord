package binarytree;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{23:56}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 求最近公共祖先
 */
public class t235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p||root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left!=null&&right!=null) return root;
        if(left==null&&right!=null) return right;
        else if(left!=null&&right==null) return left;
        return null;
    }
}
