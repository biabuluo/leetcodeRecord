package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{23:28}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 不同子序列
 */
public class t115 {
    public static void main(String[] args) {
        String s = "babgbag", t = "bag";
        System.out.println(numDistinct(s, t));
    }
    public static int numDistinct(String s, String t) {
        //定义dp数组
        int [][]dp = new int[s.length()][t.length()];
        //初始化dp数组
        for(int i=0;i<s.length();i++){
            if(i==0) {
                if(s.charAt(i)==t.charAt(0)) dp[i][0] = 1;
            }else {
                if(s.charAt(i)==t.charAt(0)) dp[i][0] = dp[i-1][0]+1;
                else dp[i][0] = dp[i-1][0];
            }
        }
        //遍历dp数组
        for(int i=1;i<s.length();i++){
            for(int j=1;j<t.length();j++){
                if(i<j) continue;
                if(s.charAt(i)==t.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[s.length()-1][t.length()-1];
    }
}
