package random;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/**
 * @author 小宇
 * @date 2023-09-06:10:51
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最深叶节点的最近公共祖先
 */
public class t1123 {

    class Pair{
        private TreeNode node;
        private Integer level;
        public Pair(TreeNode node, Integer level){
            this.node = node;
            this.level = level;
        }

        public TreeNode getNode() {
            return node;
        }

        public Integer getLevel() {
            return level;
        }

        public Pair setNode(TreeNode node) {
            this.node = node;
            return this;
        }

        public Pair setLevel(Integer level) {
            this.level = level;
            return this;
        }
    }

    public Pair backTracking(TreeNode root){
        if(root==null){
            return new Pair(root, 0);
        }
        Pair left = backTracking(root.left);
        Pair right = backTracking(root.right);
        if(left.getLevel()>right.getLevel()){
            return left.setLevel(left.level+1);
        }else if(left.getLevel()<right.getLevel()){
            return right.setLevel(right.level+1);
        }else
            return new Pair(root, right.level+1);
    }

    //思路:递归
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null)
            return null;
        else {
            return backTracking(root).getNode();
        }
    }
}
