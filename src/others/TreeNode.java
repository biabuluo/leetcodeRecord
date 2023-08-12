package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{10}:{21:59}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
