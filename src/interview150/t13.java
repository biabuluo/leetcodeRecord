package interview150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小宇
 * @date {2023}-{08}-{14}:{18:01}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 罗马数字转整数
 */
public class t13 {
    //构建字典
    public Map<Character, Integer> dict = new HashMap<>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(i<s.length()-1){
                if(dict.get(s.charAt(i))<dict.get(s.charAt(i+1))){
                    res -= dict.get(s.charAt(i));
                }else {
                    res += dict.get(s.charAt(i));
                }
            }else {
                res += dict.get(s.charAt(i));
            }
        }
        return res;
    }
}
