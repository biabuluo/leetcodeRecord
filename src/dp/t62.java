package dp;

/**
 * @author 小宇
 * @date {2023}-{07}-{31}:{11:21}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t62 {
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1&&j==1){
                    dp[i][j] = 1;continue;
                }
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
