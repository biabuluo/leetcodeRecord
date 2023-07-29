package binarytree;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{23:17}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二叉搜索树的最小绝对差
 */
public class t530 {
    //二叉树双指针
    public int min = Integer.MAX_VALUE;
    public TreeNode pre = null;
    public void func(TreeNode root){
        if(root==null) return;
        func(root.left);
        if(pre!=null){
            int result = root.val- pre.val;
            if(result<min) min = result;
        }
        pre = root;
        func(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        func(root);
        return min;
    }
}
