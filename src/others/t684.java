package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{13}:{11:35}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 冗余连接
 */
public class t684 {
    //并查集模板
    static int n;
    static int []father;
    //初始化
    public static void init(){
        for(int i=0;i<n+1;i++)
            father[i] = i;
    }
    //寻根
    public static int find(int u){
        if (father[u]==u) return u;
        father[u] = find(father[u]);
        return father[u];
    }
    //是否相同根
    public static boolean isSame(int u, int v){
        u = find(u);
        v = find(v);
        return u==v;
    }
    //添加到并查集
    public static void join(int u, int v){
        u = find(u);
        v = find(v);
        if(u==v) return;
        else father[v] = u;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        n = edges.length;
        father = new int[n+1];
        init();
        for(int i=0;i<edges.length;i++){
            if (!isSame(edges[i][0], edges[i][1]))
                join(edges[i][0], edges[i][1]);
            else return edges[i];
        }
        return null;
    }

    public static void main(String[] args) {
        int [][]edges = {{1,2}, {1,3}, {2,3}};
        findRedundantConnection(edges);
    }
}
