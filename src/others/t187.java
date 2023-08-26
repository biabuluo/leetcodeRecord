package others;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 小宇
 * @date 2023-08-25:11:35
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 重复的DNA序列
 */
public class t187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        if(s.length()<10) return new ArrayList<>(res);
        Map<String, Integer> map = new HashMap<>();
        int len = 10;
        for(int i=0;i<=s.length()-len;i++){
            String substr = s.substring(i, i+len);
            map.put(substr, map.getOrDefault(substr, 0)+1);
            if(map.get(substr)>=2)
                res.add(substr);
        }
        return new ArrayList<>(res);
    }
}
