package dp;

/**
 * @author 小宇
 * @date {2023}-{07}-{31}:{11:59}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 不同二叉搜索树
 */
public class t96 {
    public int numTrees(int n) {
        int []dp = new int[20];
        dp[0] = 1; dp[1] = 1; dp[2] = 2;
        for(int i=3;i<=n;i++){
            //表示以j为头结点的二叉树个数
            for(int j=1;j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
