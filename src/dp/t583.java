package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{13:20}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t583 {
    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
        System.out.println(minDistance(word1, word2));
    }


    //思路1：使用最长子序列
    public static int minDistance(String word1, String word2) {
        //定义dp数组
        int [][]dp = new int[word1.length()][word2.length()];
        //初始化dp数组
        for(int i=0;i<word2.length();i++){
            if(word1.charAt(0)==word2.charAt(i)) dp[0][i] = 1;
            else if (i>0)dp[0][i] = dp[0][i-1];
        }
        for(int i=1;i<word1.length();i++){
            if(word1.charAt(i)==word2.charAt(0)) dp[i][0] = 1;
            else dp[i][0] = dp[i-1][0];
        }
        //遍历dp数组
        for(int i=1;i<word1.length();i++){
            for(int j=1;j<word2.length();j++){
                if(word1.charAt(i)==word2.charAt(j)) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return word1.length()-dp[word1.length()-1][word2.length()-1]+(word2.length()-dp[word1.length()-1][word2.length()-1]);
    }
}
