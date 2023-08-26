package others;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{08}-{25}:{9:36}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t958 {
    //思路：层序遍历不出现空结点
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode pre = root;
        while (!queue.isEmpty()){
            int num = queue.size();
            while (num>0){
                TreeNode node = queue.poll();
                num--;
                if(pre == null && node!=null)
                    return false;
                if (node == null) {
                    pre = null;
                    continue;
                }
                queue.add(node.left);
                queue.add(node.right);
                pre = node;
            }
        }
        return true;
    }
}
