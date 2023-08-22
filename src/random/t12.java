package random;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author 小宇
 * @date {2023}-{08}-{21}:{14:52}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 整数转罗马数字
 */
public class t12 {

    public static void main(String[] args) {
        System.out.println(map);
    }
    //map
    static Map<Integer, String> map = new TreeMap<>((o1, o2)->Integer.compare(o2, o1));

    static {
           map.put(1, "I");
           map.put(5, "V");
           map.put(10, "X");
           map.put(50, "L");
           map.put(100, "C");
           map.put(500, "D");
           map.put(1000, "M");
           map.put(900, "CM");
           map.put(400, "CD");
           map.put(90, "XC");
           map.put(40, "XL");
           map.put(9, "IX");
           map.put(4, "IV");
    };
    public static String intToRoman(int num) {
        StringBuffer res = new StringBuffer();
        int targer = num;
        for(var entry : map.entrySet()){
            while (targer>=entry.getKey()){
                targer -= entry.getKey();
                res.append(entry.getValue());
            }
        }
        return res.toString();
    }

}
