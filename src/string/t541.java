package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{16:42}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 反转字符串II
 */
public class t541 {
    public static String reverseStr(String s, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<s.length();i+=2*k){
            if(i+2*k>=s.length()&& i+k<s.length()){
                //i-i+k里边全反转
                for (int j=i+k-1;j>=i;j--)stringBuffer.append(s.charAt(j));
                for(int j=i+k;j<s.length();j++)stringBuffer.append(s.charAt(j));
                break;
            }
            if(i+k>=s.length()){
                //结尾全反转
                for(int j=s.length()-1;j>=i;j--) stringBuffer.append(s.charAt(j));
                break;
            }
            for(int j=i+k-1;j>=i;j--) stringBuffer.append(s.charAt(j));
            for(int j=i+k;j<i+2*k;j++) stringBuffer.append(s.charAt(j));
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String s = "abcd";
        int k = 4;
        System.out.println(reverseStr(s, k));
    }
}
