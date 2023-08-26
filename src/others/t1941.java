package others;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小宇
 * @date 2023-08-26:11:04
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 检查是否所有字符出现次数相同
 */
public class t1941 {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        for(var i : str){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int num = -1;
        for(var i : map.entrySet()){
            if(num==-1){
                num = i.getValue();
            }else {
                if(i.getValue()!=num)
                    return false;
            }
        }
        return true;
    }
}
