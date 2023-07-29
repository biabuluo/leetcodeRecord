package binarytree;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{21:25}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最大二叉树
 */
public class t645 {

    public TreeNode builder(int []nums, int left, int right){
        if(right<=left) return null;
        if(left+1==right) return new TreeNode(nums[left]);
        int max = -1; int max_index=0;
        for(int index=left;index<right;index++){
            if(nums[index]>max){
                max = nums[index];
                max_index = index;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = builder(nums, left, max_index);
        root.right = builder(nums, max_index+1, right);
        return root;
    }
    //递归
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0) return null;
        return builder(nums, 0, nums.length);
    }
}
