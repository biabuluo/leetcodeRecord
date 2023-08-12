package others;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{08}-{10}:{21:59}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t129 {
    //思路：使用层序遍历
    public int sumNumbers(TreeNode root) {
        int res = 0;
        if(root==null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(tmp.left==null&&tmp.right==null) res+=tmp.val;
            if(tmp.left!=null) {
                tmp.left.val += tmp.val*10;
                queue.add(tmp.left);
            }
            if(tmp.right!=null) {
                tmp.right.val += tmp.val*10;
                queue.add(tmp.right);
            }
        }
        return res;
    }
}
