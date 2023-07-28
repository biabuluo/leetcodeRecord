package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{22:43}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二叉树的层平均值
 */
public class t637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()){
            double avg = 0;
            int counter = queue.size();int nums = counter;
            while (counter>0){
                node = queue.poll();
                avg += node.val;
                if(node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                counter--;
            }
            avg = avg / (double)nums;
            res.add(avg);
        }
        return res;
    }
}
