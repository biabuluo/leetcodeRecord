package array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 小宇
 * @date {2023}-{07}-{25}:{10:18}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最小覆盖子串
 */
public class t76 {
    //答案：滑动窗口：快慢指针

    public static boolean check(){
        //遍历ori
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if(cnt.getOrDefault(key, 0)<val){
                return false;
            }
        }
        return true;
    }
    public static Map<Character, Integer> ori = new HashMap<>();
    public static Map<Character, Integer> cnt = new HashMap<>();

    public static String func(String s, String t){
        int bound_s = s.length();
        int bound_t = t.length();
        //构造字典
        for(int i=0; i<bound_t; i++){
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0)+1);
        }
        int slowp = 0, fastp = -1;
        int res_len = Integer.MAX_VALUE, res_l = -1, res_r = -1;
        while (fastp<bound_s){
            fastp++;
            if(fastp<bound_s && ori.containsKey(s.charAt(fastp))){
                cnt.put(s.charAt(fastp), cnt.getOrDefault(s.charAt(fastp), 0)+1);
            }
            while (check() && slowp <= fastp){
            //满足子串条件
                if (fastp-slowp+1 < res_len){
                    res_len = fastp-slowp+1;
                    res_l = slowp;
                    res_r = fastp+1;
                }
                if(ori.containsKey(s.charAt(slowp))){
                    cnt.put(s.charAt(slowp), cnt.getOrDefault(s.charAt(slowp), 0)-1);
                }
                slowp++;
            }
        }
        return res_l == -1? "":s.substring(res_l, res_r);

    }




    //思路：暴力遍历
    public static boolean isSatisfy(Map<Character, Integer> hashmap){
        for (int val: hashmap.values()
             ) {
            if(val>0) return false;
        }
        return true;
    }
    public static String minWindow(String s, String t) {
        Map<Character, Integer> hashmap = new HashMap<>();
        Map<Character, Integer> judge = new HashMap<>();
        for(int i=0;i<t.length();i++){
            hashmap.put(t.charAt(i), hashmap.getOrDefault(t.charAt(i), 0)+1);
            judge.put(t.charAt(i), judge.getOrDefault(t.charAt(i), 0)+1);
        }
        int res_l=0,res_r=0,len = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            if(hashmap.containsKey(s.charAt(i))){
                int j = i;
                for(;j<s.length()&&!isSatisfy(hashmap);j++){
                    if(hashmap.containsKey(s.charAt(j))){
                        hashmap.put(s.charAt(j), hashmap.get(s.charAt(j))-1);
                    }
                }
                if (isSatisfy(hashmap)){
                    //更新数据
                    if(len>j-i){
                        len = j-i;
                        res_l = i;
                        res_r = j;
                    }
                }
                hashmap = new HashMap<Character, Integer>();
                hashmap.putAll(judge);
            }
        }
        if (len == Integer.MAX_VALUE) return "kong";
        else return s.substring(res_l, res_r);
    }

    public static void main(String[] args) {
        String s = "A", t = "A";
        System.out.println(minWindow(s, t));
    }
}
