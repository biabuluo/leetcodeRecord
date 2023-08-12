package others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{08}-{12}:{11:40}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 将二叉搜索树变平衡
 */
public class t1382 {
    List<Integer> list = new ArrayList<>();

    public void traverse(TreeNode root){
        if(root==null) return;
        if(root.left!=null) traverse(root.left);
        list.add(root.val);
        if(root.right!=null) traverse(root.right);
    }

    public TreeNode balance(int left, int right){
        if(left>right) return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = balance(left, mid-1);
        root.right = balance(mid+1, right);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        //中序遍历二叉树
        traverse(root);
        //将有序数组变为平衡二叉树
        return balance(0, list.size()-1);
    }
}
