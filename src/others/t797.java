package others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{08}-{12}:{21:53}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 所有可能的路径
 */
public class t797 {
    //思路：dfs
    static List<List<Integer>> res = new LinkedList<>();
    static List<Integer> path = new ArrayList<>();

    public static void dfs(int [][] graph, int node){
        //退出条件
        if(node == graph.length-1) {
            res.add(new ArrayList<>(path));
            return;
        }
        //当前层处理
        for(int i=0;i<graph[node].length;i++){
            path.add(graph[node][i]);
            dfs(graph, graph[node][i]);
            path.remove(path.size()-1);
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(graph, 0);
        return res;
    }

    public static void main(String[] args) {
        int [][]graph = {{1,2},{3},{3},{}};
        allPathsSourceTarget(graph);
    }
}
