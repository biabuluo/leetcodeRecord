package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{06}:{16:44}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 一和0
 */
public class t474 {
    public static void main(String[] args) {
        String []test = {"10","0001","111001","1","0"};
        System.out.println(findMaxForm(test, 5, 3));
    }
    public static int[] counter(String s){
        int []res = new int[2];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') res[0]++;
            else res[1]++;
        }
        return res;
    }
    //01背包
    public static int findMaxForm(String[] strs, int m, int n) {
        int []ones = new int[strs.length];
        int []zeros = new int[strs.length];
        for(int i=0;i< strs.length;i++){
            String tmp = strs[i];
            int []res = counter(tmp);
            zeros[i] = res[0];
            ones[i] = res[1];
        }
        //构造dp数组
        int [][][]dp = new int[strs.length][m+1][n+1];
        //初始化
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(zeros[0]<=i&&ones[0]<=j){
                    dp[0][i][j] = 1;
                }
            }
        }
        //遍历dp数组
        for(int i=1;i< strs.length;i++){
            for(int j=0;j<m+1;j++){
                for(int l=0;l<n+1;l++){
                    if(j<zeros[i]||l<ones[i]) dp[i][j][l] = dp[i-1][j][l];
                    else {
                        dp[i][j][l] = Math.max(dp[i-1][j][l], dp[i-1][j-zeros[i]][l-ones[i]]+1);
                    }
                }
            }
        }
        return dp[strs.length-1][m][n];
    }
}
