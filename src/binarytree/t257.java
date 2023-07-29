package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{15:18}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二叉树所有路径
 */
public class t257 {

    public void func(TreeNode node, List<String> res, List<Integer> path){
        path.add(node.val);
        if(node.left==null&&node.right==null){
            StringBuffer buffer = new StringBuffer();
            buffer.append(String.valueOf(path.get(0)));
            for(int i=1;i<path.size();i++){
                buffer.append("->"+String.valueOf(path.get(i)));
            }
            res.add(buffer.toString());
            return;
        }
        if(node.left!=null) {
            func(node.left, res, path);
            path.remove(path.size()-1);
        }
        if(node.right!=null){
            func(node.right, res, path);
            path.remove(path.size()-1);
        }
    }


    //思路：前序遍历
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null) return res;
        List<Integer> path=new ArrayList<>();
        func(root, res, path);
        return res;
    }
}
