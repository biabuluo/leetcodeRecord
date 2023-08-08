package dp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 小宇
 * @date {2023}-{08}-{07}:{20:04}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 单词拆分
 */
public class t139 {
    public static void main(String[] args) {
        String s ="ssssssssssssssss";
        List<String> wordDict = new ArrayList<>();
    }
    //思路：动态规划: 组合问题+多重背包
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        //定义dp数组
        boolean []dp = new boolean[s.length()+1];
        //初始化dp数组
        for(int i=0;i<=s.length();i++) dp[i] = false;
        dp[0] = true;
        //遍历dp数组
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(set.contains(s.substring(j, i))&&dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
