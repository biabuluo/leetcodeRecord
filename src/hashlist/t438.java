package hashlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{26}:{22:55}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 找到字符串中所有字母异位词
 */
public class t438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        //计算p的key
        char[] tmp = p.toCharArray();
        Arrays.sort(tmp);
        String key = new String(tmp);
        //获取p长度
        int len = p.length();
        int last = 0;
        for (int i=0;i+len<s.length();i++){
            String tmp2 = s.substring(i, i+len);
            char[] tmp3 = tmp2.toCharArray();
            Arrays.sort(tmp3);
            String iskey = new String(tmp3);
            if (iskey.equals(key)){
                res.add(i);
            }
            last = i+1;
        }
        //判断最后一个子串是否符合
        String lastsubstring = s.substring(last);
        char[] tmp4 = lastsubstring.toCharArray();
        Arrays.sort(tmp4);
        String iskey = new String(tmp4);
        if (iskey.equals(key)){
            res.add(last);
        }
        return res;
    }
}
