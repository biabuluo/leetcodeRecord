package random;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 小宇
 * @date 2023-09-04:11:34
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t449 {

    //思路：使用后序遍历
    public void postTree(TreeNode root, StringBuffer res){
        if(root==null){
            return ;
        }
        postTree(root.left, res);
        postTree(root.right, res);
        res.append(" "+root.val);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer res = new StringBuffer();
        //使用后序遍历遍历树
        postTree(root, res);
        //转为字符串
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //将字符串拆解
        String[] node = data.trim().split(" ");

        List<Integer> vals = Arrays.stream(node)
                .filter(o->o!=null&&o.equals(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        int len = vals.size()-1;
        //递归构造成树
        return constructTree(vals, 0, len);
    }

    //构造树
    public TreeNode constructTree(List<Integer> node, int s, int e){
        if(e<s)
            return null;
        Integer rootVal = node.get(e);
        TreeNode root = new TreeNode(rootVal);
        //找到第一个比根节点大的坐标；
        Integer idx = null;
        for(int i=0;i<e;i++){
            if(node.get(i)>rootVal){
                idx = i;
                break;
            }
        }
        //找到了
        if(idx!=null){
            if(idx-1<0) {
                root.left = null;
                root.right = constructTree(node, idx, e-1);
            }
            else {
                root.left = constructTree(node, s, idx-1);
                root.right = constructTree(node, idx, e-1);
            }
        }
        else {
            root.right = null;
            root.left = constructTree(node, s, e-1);
        }
        return root;
    }




}
