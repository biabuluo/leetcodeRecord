package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 小宇
 * @date {2023}-{07}-{29}:{23:46}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t501 {
    public void func(TreeNode root, Map<Integer, Integer> hashmap){
        if(root==null) return;
        hashmap.put(root.val, hashmap.getOrDefault(root.val, 0)+1);
        func(root.left, hashmap);
        func(root.right, hashmap);
    }
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        func(root, hashmap);
        int maxcount = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry: hashmap.entrySet()) {
            if(entry.getValue()>maxcount) maxcount = entry.getValue();
        }
        List<Integer> tmp = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: hashmap.entrySet()) {
            if(entry.getValue()==maxcount) tmp.add(entry.getKey());
        }
        int []res = new int[tmp.size()];
        for(int i=0;i<res.length;i++){
            res[i] = tmp.get(i);
        }
        return res;
    }
}
