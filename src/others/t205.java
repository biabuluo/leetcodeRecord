package others;

import java.util.HashMap;

/**
 * @author 小宇
 * @date {2023}-{08}-{10}:{20:41}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 同构字符串
 */
public class t205 {
    public boolean isIsomorphic(String s, String t) {
        //思路：hash
        if(s.length()!=t.length()) return false;
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map1.containsKey(s.charAt(i))) map1.put(s.charAt(i), t.charAt(i));
            if(!map2.containsKey(t.charAt(i))) map2.put(t.charAt(i), s.charAt(i));
            if(map1.get(s.charAt(i))!=t.charAt(i) || map2.get(t.charAt(i))!=s.charAt(i)) return false;
        }
        return true;
    }
}
