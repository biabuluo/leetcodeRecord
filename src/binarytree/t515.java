package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{23:02}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 在每个树中找到最大值
 */
public class t515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        queue.add(root);
        while (!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int nums = queue.size();
            while (nums>0){
                node = queue.poll();
                if(node.val>max) max = node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                nums--;
            }
            res.add(max);
        }
        return res;
    }
}
