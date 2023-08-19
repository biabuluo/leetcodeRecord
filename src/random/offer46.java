package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{19}:{13:41}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 把数字翻译成字符串
 */
public class offer46 {
    //思路：dp
    public int translateNum(int num) {
        String s = String.valueOf(num);
        char []str = s.toCharArray();
        //定义dp数组
        int []dp = new int[s.length()];
        //初始化dp数组
        dp[0] = 1;
        if(str.length==1) return dp[0];
        else {
            Integer tmp = Integer.valueOf(s.substring(0, 2));
            if(tmp<26)
                dp[1] = 2;
            else dp[1] = 1;
        }
        //遍历dp数组
        for(int i=2;i<dp.length; i++){
            dp[i] = dp[i-1];
            Integer tmp = Integer.valueOf(s.substring(i-1, i+1));
            if(str[i-1]!='0' && tmp<26)
                dp[i] += dp[i-2];
        }
        return dp[dp.length-1];
    }
}
