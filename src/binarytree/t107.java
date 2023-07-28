package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{22:20}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二叉树的层序遍历II
 */
public class t107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> tmp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return tmp;
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()){
            List<Integer> group = new ArrayList<>();
            int nums = queue.size();
            while (nums>0){
                node = queue.poll();
                group.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                nums--;
            }
            tmp.add(group);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=tmp.size()-1;i>=0;i--){
            res.add(tmp.get(i));
        }
        return res;
    }
}
