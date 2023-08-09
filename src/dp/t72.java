package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{14:40}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 编辑距离
 */
public class t72 {
    public static void main(String[] args) {
        String s1 = "dimethylhydrazine", s2 = "dinittrophenylhydrazine";
        minDistance(s1, s2);
        System.out.println("-------");
        func(s1, s2);
    }
    public static void func(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化
        for (int i = 1; i <= m; i++) {
            dp[i][0] =  i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 因为dp数组有效位从1开始
                // 所以当前遍历到的字符串的位置为i-1 | j-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        for(int i=0;i<=word1.length();i++){
            for(int j=0;j<=word2.length();j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    public static void minDistance(String word1, String word2) {
        //定义dp数组
        int [][]dp = new int[word1.length()+1][word2.length()+1];
        //初始化dp数组
        for(int i=0;i<=word2.length();i++) dp[0][i] = i;
        for(int i=1;i<=word1.length();i++) dp[i][0] = i;
        //遍历dp数组
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]))+1;
            }
        }
        for(int i=0;i<=word1.length();i++){
            for(int j=0;j<=word2.length();j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
