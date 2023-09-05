package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author 小宇
 * @date 2023-09-04:15:12
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 外观数列
 */
public class t38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(7));
        System.out.println(list);
    }


    public static List<String> list = new ArrayList<>();
    static {
        list.add("0");
        list.add("1");
        list.add("11");
        list.add("21");
        list.add("1211");
        list.add("111221");
    }
    public static String countAndSay(int n) {
        if(n<=5){
            return list.get(n);
        }
        else {
            for(int i=6;i<=n;i++){
                char[] chars = list.get(i-1).toCharArray();
                StringBuffer next = new StringBuffer();
                int l = 0, r=1;
                for(r=1;r<chars.length;r++){
                    if(chars[r]==chars[l])
                        continue;
                    next.append(r - l).append(chars[l]);
                    l = r;
                }
                next.append(r-l).append(chars[l]);
                list.add(next.toString());
            }
            return list.get(n);
        }
    }
}
