package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{11:36}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 打家劫舍III
 */
public class t337 {
    //思路：树形dp
    public int[] func(TreeNode node){
        int []res = new int[2];
        if(node==null) return res;
        int []rightdp = func(node.left);
        int []leftdp = func(node.right);
        res[0] = Math.max(rightdp[0], rightdp[1])+Math.max(leftdp[0], leftdp[1]);
        res[1] = rightdp[0]+leftdp[0]+node.val;
        return res;
    }
    public int rob(TreeNode root) {
        int []res = func(root);
        return Math.max(res[0], res[1]);
    }
}
