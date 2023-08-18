package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{18}:{15:28}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 构造有效字符串的最少插入数
 */
public class t2645 {
    //思路：dp?
    public int addMinimum(String word) {
        char[] s = word.toCharArray();
        if(s.length==0) return 3;
        //定义dp数组
        int []dp = new int[s.length];
        //初始化dp数组
        dp[0] = 2;
        if(s.length>1){
            if(s[1]=='b' && s[0]=='a' || s[1]=='c' && s[0]=='b' || s[1]=='c' && s[0]=='a')
                dp[1] = 1;
            else dp[1] = dp[0]+2;
        }
        if(s.length>2){
            if(s[2]=='c' && s[1]=='b' && s[0]=='a')
                dp[2] = 0;
            else if(s[2]=='c' && s[1]=='b' || s[2]=='c' && s[1]=='a' ||  s[2]=='b' && s[1]=='a')
                dp[2] = dp[0]+1;
            else dp[2] = dp[1]+2;
        }
        //遍历dp数组
        for(int i=3;i<s.length;i++){
            if(s[i]=='b'){
                if(s[i-1]=='a')
                    dp[i] = dp[i-2] + 1;
                else
                    dp[i] = dp[i-1] + 2;
            }
            else if(s[i]=='c'){
                if(s[i-1]=='b' && s[i-2]=='a')
                    dp[i] = dp[i-3];
                else if (s[i-1]=='b' || s[i-1]=='a')
                    dp[i] = dp[i-2]+1;
                else dp[i] = dp[i-1]+2;
            }
            else dp[i] = dp[i-1] + 2;
        }
        return dp[s.length-1];
    }
}
