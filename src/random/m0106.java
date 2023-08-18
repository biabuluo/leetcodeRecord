package random;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author 小宇
 * @date {2023}-{08}-{17}:{14:45}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 字符串压缩
 */
public class m0106 {
    public static void main(String[] args) {
        String s = "aabcccccaa";
        compressString(s);
    }
    public static String compressString(String S) {
        if (S.length()==0) return "";
        char[] s = S.toCharArray();
        StringBuffer res = new StringBuffer();
        char val = s[0];
        int count = 1;
        for(int i=1;i<s.length;i++){
            if(s[i]==val)
                count++;
            else {
                res.append(val);
                res.append(count);
                val = s[i];
                count = 1;
            }
        }
        res.append(val);
        res.append(count);
        return res.length()<s.length ? res.toString():S;
    }
}
