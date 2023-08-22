package random;

import java.sql.PreparedStatement;

/**
 * @author 小宇
 * @date {2023}-{08}-{21}:{12:17}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 判断根结点是否等于子节点之和
 */
public class t2236 {
    public boolean checkTree(TreeNode root) {
        if(root == null) return true;
        int sum = 0;
        if(root.left!=null) sum += root.left.val;
        if(root.right!=null) sum += root.right.val;
        if(sum == root.val) return true;
        else return false;
    }
}
