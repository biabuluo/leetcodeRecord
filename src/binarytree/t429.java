package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{22:55}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: N叉树的层序遍历
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class t429 {
    //思路：正常的层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node node;
        while (!queue.isEmpty()){
            int nums = queue.size();
            List<Integer> group = new ArrayList<>();
            while (nums>0){
                node = queue.poll();
                group.add(node.val);
                for (Node child: node.children) {
                    if(child!=null) queue.add(child);
                }
                nums--;
            }
            res.add(group);
        }
        return res;
    }
}
