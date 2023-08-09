package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{15:33}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 回文子串
 */
public class t647 {
    public int countSubstrings(String s) {
        int res = 0;
        //定义dp数组
        boolean [][]dp = new boolean[s.length()][s.length()];
        //初始化dp数组
        for(int i=0;i<s.length();i++){
            for (int j=0;j<s.length();j++) dp[i][j] = false;
        }
        //遍历dp数组
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(j==i) dp[i][j]=true;
                else {
                    if(s.charAt(i)==s.charAt(j)){
                        if(j-i<=1) dp[i][j] = true;
                        else dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]==true) res++;
            }
        }
        return res;
    }
}
