package others;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{08}-{10}:{21:00}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 查找共用字符
 */
public class t1002 {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        if(words.length==0) return res;
        //构造字典
        Set<String> set = new HashSet<>();
        for(int i=0;i<words[0].length();i++){
            set.add(String.valueOf(words[0].charAt(i)));
        }
        for(int i=1;i<words.length;i++){
            for (String tmp : set) {
                if (!words[i].contains(tmp)) {
                    set.remove(tmp);
                }
            }
        }
        res.addAll(set);
        return res;
    }
}
