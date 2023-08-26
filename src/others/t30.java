package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 小宇
 * @date 2023-08-25:11:02
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 串联所有单词的子串
 */
public class t30 {
    public boolean isValid(String s, Map<String, Integer> map, int len){
        Map<String, Integer> judge = new HashMap<>(map);
        for(int i=len-1;i<s.length();i+=len){
            String target = s.substring(i-len+1, i+1);
            if(judge.containsKey(target)){
                if(judge.get(target)<=0)
                    return false;
                else {
                    judge.put(target, judge.get(target)-1);
                }
            }else {
                return false;
            }
        }
        for(var i : judge.entrySet()){
            if(i.getValue()>0)
                return false;
        }
        return true;
    }


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length==0) return res;
        int len = words.length;
        int str_len = words[0].length();
        int winlen = len * str_len;
        Map<String, Integer> map = new HashMap<>();
        for(var i : words){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(int i=winlen-1;i<s.length();i++){
            if(isValid(s.substring(i-winlen+1, i+1), map, str_len)){
                res.add(i-winlen+1);
            }
        }
        return res;
    }
}
