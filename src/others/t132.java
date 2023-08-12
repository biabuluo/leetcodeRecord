package others;

import java.util.Map;

/**
 * @author 小宇
 * @date {2023}-{08}-{12}:{17:38}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 分割回文串II
 */
public class t132 {
    public boolean isValid(String s){
        //判断是否是回文串
        int left = 0, right = s.length()-1;
        int nums = s.length()/2;
        while (nums>0){
            if (s.charAt(left)!=s.charAt(right)) return false;
            nums--;
            left++;
            right--;
        }
        return true;
    }
    //思路：动态规划
    public int minCut(String s) {
        //定义dp数组
        int []dp = new int[s.length()];
        //初始化dp数组
        for(int i=0;i<s.length();i++)
            dp[i] = i;
        //遍历dp数组
        for(int i=0;i<s.length();i++){
            if(isValid(s.substring(0, i+1)))
                dp[i] = 0;
            else {
                for(int j=0;j<i;j++){
                    if(isValid(s.substring(j+1, i+1)))
                        dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[s.length()-1];
    }
}
