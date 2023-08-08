package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{11:36}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class TreeNode {
          int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
}
