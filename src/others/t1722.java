package others;

import java.util.HashMap;

/**
 * @author 小宇
 * @date {2023}-{08}-{24}:{11:16}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 执行交换操作后的最小汉明距离
 */
public class t1722 {
    //思路：并查集
    int []father;
    public void init(int n){
        father = new int[n];
        //初始化
        for(var i : father)
            father[i] = i;
    }
    //寻根
    public int find(int n){
        if (father[n] == n)
            return n;
        else {
            father[n] = find(father[n]);
            return father[n];
        }
    }

    //判断是否同源
    public boolean isSame(int a, int b){
        int sa = find(a);
        int sb = find(b);
        if(sa == sb)
            return true;
        else return false;
    }

    //添加同源
    public void add(int u, int v){
        u = find(u);
        v = find(v);
        if(u==v) return;
        father[v] = u;
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int len = source.length;
        init(len);
        for (var i : allowedSwaps){
            add(i[0], i[1]);
        }
        //hash存储需要转变的值
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i=0;i<len;i++){
            int root = find(i);
            if (!map.containsKey(root)) {
                map.put(root, new HashMap<>());
            }
            map.get(root).put(source[i], map.get(root).getOrDefault(source[i], 0) + 1);
        }
        // target和source比较
        int res = 0;
        for (int i = 0; i < len; i++) {
            int root = find(i);
            //看这个root的连通块中，有没有target[i]这个数字
            // 本来就没有这个数字，或者前面比较过程中这个数字的个数已经变成0了
            if ((!map.get(root).containsKey(target[i])) || (map.get(root).get(target[i]) == 0)) {
                res++;
            } else {
                //有这个数字，对应的次数-1
                map.get(root).put(target[i], map.get(root).get(target[i]) - 1);
            }
        }
        return res;

    }
}
