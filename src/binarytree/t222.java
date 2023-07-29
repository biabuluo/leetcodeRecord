package binarytree;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{13:12}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 完全二叉树结点个数
 */
public class t222 {
    //利用完全二叉树特点
    public int func(TreeNode root){
        if(root==null) return 0;
        //判断子树是否为完全二叉树
        int height_l = 1, height_r = 1;
        TreeNode node = root;
        while (node.left!=null){
            node = node.left;
            height_l++;
        }
        while (node.right!=null){
            node = node.right;
            height_r++;
        }
        if(height_l==height_r) return (int)Math.pow(2, height_l)-1;
        else return func(root.left)+func(root.right)+1;
    }


    //暴力遍历
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int num_l = countNodes(root.left);
        int num_r = countNodes(root.right);
        return num_r+num_l+1;
    }
}
