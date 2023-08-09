package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{16:30}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最长回文子序列
 */
public class t516 {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
    public static int longestPalindromeSubseq(String s) {
        //定义dp数组
        int [][]dp = new int[s.length()][s.length()];
        //初始化
        //遍历dp数组
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(i==j) dp[i][j] = 1;
                else if(j-i==1) {
                    if(s.charAt(i)==s.charAt(j)) dp[i][j] = 2;
                    else dp[i][j] = 1;
                }
                else {
                    if(s.charAt(i)==s.charAt(j)) dp[i][j] = dp[i+1][j-1]+2;
                    else dp[i][j] = Math.max(dp[i+1][j], Math.max(dp[i+1][j-1], dp[i][j-1]));
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
