package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{23:30}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:填充每个节点的下一个右侧结点指针II
 */
public class t117 {
    //感觉和116没区别。。。。
    public Node2 connect(Node2 root) {
        Node2 res = root;
        if(root == null) return res;
        Queue<Node2> queue = new LinkedList<>();
        queue.add(root); Node2 node;
        while (!queue.isEmpty()){
            int nums = queue.size();
            Node2 last = null;
            while (nums>0){
                node = queue.poll();
                if(nums== queue.size()) node.next = null;
                else {
                    node.next = last;
                    if(node.right!=null) queue.add(node.right);
                    if(node.left!=null) queue.add(node.left);
                }
                last = node;
                nums--;
            }
        }
        return res;
    }
}
