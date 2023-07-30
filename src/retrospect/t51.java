package retrospect;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{19:42}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: N皇后
 */
public class t51 {
    public List<List<String>> res = new ArrayList<>();
    char[][]path;

    public boolean isValid(int row, int col){
        for(int i=0;i<row;i++){
            if(path[i][col]=='Q') return false;
        }
        for(int i=row-1, j=col-1;i>=0&&j>=0;i--,j--){
            if(path[i][j]=='Q') return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<path[0].length;i--,j++){
            if(path[i][j]=='Q') return false;
        }
        return true;
    }

    public void backtracking (int n, int row){
        if(n==row){
            List<String> tmp = new ArrayList<>();
            for(int i=0;i<n;i++){
                tmp.add(String.copyValueOf(path[i]));
            }
            res.add(tmp);
            return;
        }
        for(int i=0;i<n;i++){
            if(isValid(row, i)){
                path[row][i] = 'Q';
                backtracking(n, row+1);
                path[row][i] = '.';
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        path = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                path[i][j] = '.';
            }
        }
        backtracking(n, 0);
        return res;
    }

}
