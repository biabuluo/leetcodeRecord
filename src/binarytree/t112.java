package binarytree;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{19:25}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 路径总和
 */
public class t112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null){
            if(root.val==targetSum) return true;
            else return false;
        }
        int target = targetSum-root.val;
        if(root.left!=null){
            boolean flag = hasPathSum(root.left, target);
            if(flag==true) return true;
        }
        if(root.right!=null){
            boolean flag = hasPathSum(root.right, target);
            if(flag==true) return true;
        }
        return false;
    }
}
