package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{20:52}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最长公共子序列
 */
public class t1143 {
    public static void main(String[] args) {
        String s1 = "abcde", s2 = "ace";
        System.out.println(longestCommonSubsequence(s1, s2));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        //定义dp数组
        int [][]dp = new int[text1.length()][text2.length()];
        //初始化dp数组
        int flag = 0;
        for(int i=0;i<text2.length();i++){
            if(text1.charAt(0)==text2.charAt(i)){
                dp[0][i] = 1; flag = 1;
            }
            if(flag==1) dp[0][i] = 1;
        }
        flag = 0;
        for(int i=0;i<text1.length();i++){
            if(text2.charAt(0)==text1.charAt(i)){
                dp[i][0] = 1; flag=1;
            }
            if(flag==1) dp[i][0] = 1;
        }
        //遍历dp数组
        for(int i=1;i<text1.length();i++){
            for(int j=1;j<text2.length();j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }
}
