package binarytree;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{19:06}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */

//二叉树种类：
//- 满二叉树：深度：1、2、3 结点数：2^k-1
//- 完全二叉树：除了底层全满，底层从左到右连续
//- 二叉搜索树：对结点结构没有要求
//- 平衡二叉搜索树：左子树和右子树高度相差<=1
//
//二叉树的存储方式：
//- 链式存储
//- 线性存储：左：2k+1 右：2k+2
//
//二叉树的遍历方式：
//- 深度优先搜索（前中后序遍历（描述的是中的位置））：递归、迭代
//- 广度优先遍历：层序遍历（队列-迭代）
//
//二叉树定义方式：
//- 略


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
