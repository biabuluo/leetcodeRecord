package others;

import java.util.LinkedList;

/**
 * @author 小宇
 * @date {2023}-{08}-{12}:{12:04}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 填充每个节点的下一个右侧结点
 */
public class t116 {
    TreeNode pre = null;

    public TreeNode connect(TreeNode root) {
        if(root==null) return root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int nums = queue.size();
            pre = null;
            while(nums>0){
                TreeNode node = queue.poll();
                node.next = pre;
                pre = node;
                if(node.right!=null) queue.add(node.right);
                if(node.left!=null) queue.add(node.left);
                nums--;
            }
        }
        return root;
    }
}
