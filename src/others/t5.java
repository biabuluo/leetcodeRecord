package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{12}:{15:56}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最长回文子串
 */
public class t5 {
    public String longestPalindrome(String s) {
        //思路：动态规划
        int [][]dp = new int[s.length()][s.length()];
        //初始化dp数组
        int res = 0;
        int idx_s = 0, idx_e = 0;
        //遍历dp数组
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(i==j) dp[i][j] = 1;
                else if(i+1==j && s.charAt(i)==s.charAt(j)) dp[i][j] = 2;
                else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]!=0) dp[i][j] = dp[i+1][j-1]+2;
                if(dp[i][j]>res){
                    idx_s = i;
                    idx_e = j;
                    res = dp[i][j];
                }
            }
        }
        return s.substring(idx_s, idx_e+1);
    }
}
