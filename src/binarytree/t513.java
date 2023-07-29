package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{17:00}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 找树左下角的值
 */
public class t513 {
    //思路1：选择层序遍历
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        int res = 0; //记录每一层第一个元素
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);TreeNode node;
        while (!queue.isEmpty()){
            res = queue.peek().val;
            int nums = queue.size();
            while (nums>0){
                node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                nums--;
            }
        }
        return res;
    }
}
