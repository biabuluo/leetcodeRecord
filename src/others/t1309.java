package others;

import java.util.HashMap;

/**
 * @author 小宇
 * @date {2023}-{08}-{24}:{17:24}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 解码字母到整数映射
 */
public class t1309 {
    static HashMap<String, String> map = new HashMap<>();
    static {
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.put("7", "g");
        map.put("8", "h");
        map.put("9", "i");
        map.put("10#", "j");
        map.put("11#", "k");
        map.put("12#", "l");
        map.put("13#", "m");
        map.put("14#", "n");
        map.put("15#", "o");
        map.put("16#", "p");
        map.put("17#", "q");
        map.put("18#", "r");
        map.put("19#", "s");
        map.put("20#", "t");
        map.put("21#", "u");
        map.put("22#", "v");
        map.put("23#", "w");
        map.put("24#", "x");
        map.put("25#", "y");
        map.put("26#", "z");
    }
    public String freqAlphabets(String s) {
        StringBuffer res = new StringBuffer();
        int len = s.length();
        for(int i=len-1;i>=0;){
            if(s.charAt(i)=='#'){
                String tmp = s.substring(i-2, i+1);
                res.append(map.get(tmp));
                i-=3;
            }else {
                String tmp = s.substring(i, i+1);
                res.append(map.get(tmp));
                i--;
            }
        }
        return res.reverse().toString();

    }
}
