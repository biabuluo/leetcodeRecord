package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{23}:{15:50}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 矩阵中最长递增路径
 */
public class t329 {
    //记忆化+深度优先搜索
    //定义方向
    static int [][]dirs = {
            {-1, 0},  //上
            {1, 0},   //下
            {0, -1},  //右
            {0, 1}    //左
    };
    int rows, cols;

    //深度优先搜索
    public int dfs(int [][]matrix, int row, int col, int [][]copy){
        if(copy[row][col]!=0)
            return copy[row][col];
        //最长路径至少是1
        copy[row][col] ++;
        for(int []dir : dirs){
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            if(newRow>=0 && newRow<rows
            && newCol>=0 && newCol<cols
            && matrix[newRow][newCol]>matrix[row][col])
                copy[row][col] = Math.max(copy[row][col], dfs(matrix, newRow, newCol, copy)+1);
        }
        return copy[row][col];
    }



    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        rows = matrix.length;
        cols = matrix[0].length;
        //结果矩阵
        int [][]copy = new int[rows][cols];
        int res = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
                res = Math.min(res, dfs(matrix, i, j, copy));
        }
        return res;
    }
}
