package random;

import java.sql.PseudoColumnUsage;

/**
 * @author 小宇
 * @date {2023}-{08}-{21}:{14:01}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 累加数字
 */
public class t306 {
    //思路：枚举

    //字符串加法
    public String stringAdd(String num, int fs, int fe, int ss, int se){
        StringBuffer third = new StringBuffer();
        int add = 0;
        int cur = 0;
        while (fe>=fs || se>=ss || add!=0){
            cur = add;
            if(fe>=fs){
                cur+=num.charAt(fe)-'0';
                fe--;
            }
            if(se>=ss){
                cur+=num.charAt(se)-'0';
                se--;
            }
            add = cur/10;
            cur %= 10;
            third.append((char)(cur+'0'));
        }
        third.reverse();
        return third.toString();
    }

    public boolean isValid(int ss, int se, String num){
        int n = num.length();
        int fs = 0, fe = ss-1;
        while (se<=n-1){
            String third = stringAdd(num, fs, fe, ss, se);
            int ts = se+1;
            int te = se+third.length();
            if(te >= n || !num.substring(ts, te+1).equals(third))
                break;
            if (te == n-1){
                return true;
            }
            fs = ss;
            fe = se;
            ss = ts;
            se = te;
        }
        return false;
    }
    //累加数列前两个数字确定整个数列就确定
    public boolean isAdditiveNumber(String num) {
        int len  =num.length();
        for(int secondStart = 1;secondStart<len-1;secondStart++){
            if(num.charAt(0)=='0' && secondStart!=1)
                break;
            for(int secondEnd = secondStart; secondEnd<len-1;secondEnd++){
                if (num.charAt(secondStart)=='0' && secondStart != secondEnd)
                    break;
                if (isValid(secondStart, secondEnd, num)){
                    return true;
                }
            }
        }
        return false;
    }
}
