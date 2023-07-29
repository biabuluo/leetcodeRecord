package binarytree;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{22:27}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 验证二叉搜索树
 */
public class t98 {
    //不用额外空间



    //中序遍历二叉树，判断是否有序
    public static void builder(TreeNode root, List<Integer> list){
        if(root==null) return;
        builder(root.left, list);
        list.add(root.val);
        builder(root.right, list);
    }
    public static boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        builder(root, list);
        int flag = list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=flag) return false;
            flag = list.get(i);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isValidBST(root));
    }
}
