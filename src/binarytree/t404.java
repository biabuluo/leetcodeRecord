package binarytree;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{16:18}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 左叶子之和
 */
public class t404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 0;
        int sum = 0;
        if(root.left!=null && root.left.left==null&&
        root.left.right==null){
            sum += root.left.val;
        }
        else sum+=sumOfLeftLeaves(root.left);
        return sum+=sumOfLeftLeaves(root.right);
    }
}
