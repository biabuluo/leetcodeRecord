package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{16}:{16:30}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 猜数字大小II
 */
public class t375 {
    //思路：使用动态规划
    public int getMoneyAmount(int n) {
        //定义dp数组
        int [][]dp = new int[n+1][n+1];
        //初始化dp数组
        //遍历dp数组
        for(int i=n;i>=1;i--){
            for(int j=i+1;j<=n;j++){
                if(j-i==1) dp[i][j] = i;
                else {
                    //初始化边界
                    dp[i][j] = j+dp[i][j-1];
                    for(int k=i;k<j;k++){
                        dp[i][j] = Math.min(dp[i][j], k+Math.max(dp[i][k-1], dp[k+1][j]));
                    }
                }
            }
        }
        return dp[1][n];
    }
}
