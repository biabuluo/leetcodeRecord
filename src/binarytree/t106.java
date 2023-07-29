package binarytree;

import java.util.Arrays;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{20:51}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 从中序与后续遍历序列构造二叉树
 */
public class t106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0 || inorder.length == 0)
            return null;
        return buildHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);

    }
    private TreeNode buildHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if (postorderStart == postorderEnd)
            return null;
        int rootVal = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        int middleIndex;
        for (middleIndex = inorderStart; middleIndex < inorderEnd; middleIndex++) {
            if (inorder[middleIndex] == rootVal)
                break;
        }

        int leftInorderStart = inorderStart;
        int leftInorderEnd = middleIndex;
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = inorderEnd;


        int leftPostorderStart = postorderStart;
        int leftPostorderEnd = postorderStart + (middleIndex - inorderStart);
        int rightPostorderStart = leftPostorderEnd;
        int rightPostorderEnd = postorderEnd - 1;
        root.left = buildHelper(inorder, leftInorderStart, leftInorderEnd, postorder, leftPostorderStart, leftPostorderEnd);
        root.right = buildHelper(inorder, rightInorderStart, rightInorderEnd, postorder, rightPostorderStart, rightPostorderEnd);

        return root;
    }
}
