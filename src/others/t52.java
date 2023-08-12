package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{12}:{12:16}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: N皇后II
 */
public class t52 {
    int res = 0;
    int [][]path;
    int level;

    public boolean isValid(int n, int no){
        for(int i=n-1;i>=0;i--)if(path[i][no]==1) return false;
        for(int i=no-1, j=n-1;i>=0&&j>=0;i--,j--)if(path[j][i]==1) return false;
        for(int i=no+1, j=n-1;i<level&&j>=0;i++,j--) if(path[j][i]==1) return false;
        return true;
    }

    public void backtracking(int n){
        if(n>=level){
            res++;
        }else {
            for(int i=0;i<level;i++){
                if(isValid(n, i)){
                    path[n][i] = 1;
                    backtracking(n+1);
                    path[n][i] = 0;
                }
            }
        }
    }

    public int totalNQueens(int n) {
        level = n;
        path = new int[n][n];
        backtracking(0);
        return res;
    }
}
