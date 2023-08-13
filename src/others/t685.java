package others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{08}-{13}:{13:57}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 冗余连接II
 */
public class t685 {
    //思路：并查集
    int n;
    int []father;
    //初始化并查集
    public void init(int size){
        n = size+1;
        father = new int[n];
        for(int i=0;i<n;i++)
            father[i] = i;
    }
    //寻根
    public int find(int node){
        if(father[node] == node) return node;
        father[node] = find(father[node]);
        return father[node];
    }
    //是否同源
    public boolean isSame(int u, int v){
        u = find(u);
        v = find(v);
        if(u==v) return true;
        else return false;
    }
    //加入并查集
    public void join(int u, int v){
        u = find(u);
        v = find(v);
        if(u==v) return;
        else father[v] = u;
    }

    //构成有向环情况
    public int[] removeCircle(int [][]edges){
        init(edges.length);
        for(int i=0;i<edges.length;i++){
            if(isSame(edges[i][0], edges[i][1]))
                return edges[i];
            else join(edges[i][0], edges[i][1]);
        }
        return null;
    }

    //删除某条边后，是否是一个树（无环）
    public boolean isTree(int [][]edges, int delete){
        init(edges.length);
        for(int i=0;i<edges.length;i++){
            if(i==delete) continue;
            if(isSame(edges[i][0], edges[i][1]))
                return false;
            else join(edges[i][0], edges[i][1]);
        }
        return true;
    }


    public int[] findRedundantDirectedConnection(int[][] edges) {
        //记录入度
        int[] indegree = new int[edges.length+1];
        for(int i=0;i<edges.length;i++)
            indegree[edges[i][1]]++;
        //处理入度为2的情况
        List<Integer> lines2degree = new ArrayList<>();
        for(int i= edges.length-1;i>=0;i--){
            if(indegree[edges[i][1]]==2)
                lines2degree.add(i);
        }
        for(int i=0;i<lines2degree.size();i++){
            if(isTree(edges, lines2degree.get(i)))
                return edges[lines2degree.get(i)];
        }
        //处理环
        return removeCircle(edges);
    }
}
