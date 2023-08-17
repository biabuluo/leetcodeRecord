package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{16}:{13:40}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class TreeNode {
     int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
   TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
       this.left = left;
       this.right = right;
   }
}
