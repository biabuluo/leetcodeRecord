package random;

/**
 * @author 小宇
 * @date 2023-08-31:9:35
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 一个图中联通三元组的最小度数
 */
public class t1761 {
    public int minTrioDegree(int n, int[][] edges) {
        //计算度数集合
        //计算邻接矩阵
        int res = Integer.MAX_VALUE;
        int [][]neighbor = new int[n+1][n+1];
        int []degree = new int[n+1];
        for(var i : edges){
            degree[i[0]]++;
            degree[i[1]]++;
            neighbor[i[0]][i[1]]++;
            neighbor[i[1]][i[0]]++;
        }
        //遍历枚举连通图
        for(var i : edges){
            int a = i[0];
            int b = i[1];
            for(int j=1;j<n+1;j++){
                if(neighbor[j][a]!=0 && neighbor[j][b]!=0){
                    //计算度数
                    int tmp_degree = degree[a]+degree[b]+degree[j]-6;
                    res = Math.min(res, tmp_degree);
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
