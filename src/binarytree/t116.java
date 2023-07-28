package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{23:07}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:填充每个节点的下一个右侧结点指针
 */
class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _left, Node2 _right, Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class t116 {
    //还是层序遍历，，，，这下刷爽了
    public Node2 connect(Node2 root) {
        Node2 res = root;
        if(root == null) return res;
        Queue<Node2> queue = new LinkedList<>();
        queue.add(root); Node2 node;
        while (!queue.isEmpty()){
            int nums = queue.size();
            int counter = nums;
            Node2 last = null;
            while (nums>0){
                node = queue.poll();
                if(nums== counter) node.next = null;
                else node.next = last;
                if(node.right!=null) queue.add(node.right);
                if(node.left!=null) queue.add(node.left);
                last = node;
                nums--;
            }
        }
        return res;
    }
}
