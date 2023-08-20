package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 小宇
 * @date {2023}-{08}-{20}:{11:41}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 子域名访问计数
 */
public class t811 {

    Map<String, Integer> map = new HashMap<>();
    public void operateStr(String s){
        s = s.trim();
        Integer num = 0;
        String ip = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                num = Integer.valueOf(s.substring(0, i));
                s = s.substring(i).trim();
            }
        }
        String[]iploc = s.split("\\.");
        for(int idx = iploc.length-1;idx>=0;idx--){
            if(idx == iploc.length-1)
                iploc[idx] = iploc[idx];
            else iploc[idx] = iploc[idx]+"."+iploc[idx+1];
            map.put(iploc[idx], map.getOrDefault(iploc[idx], 0)+num);
        }
    }

    //思路：hash
    public List<String> subdomainVisits(String[] cpdomains) {
        for(var s: cpdomains){
            operateStr(s);
        }
        //结果集
        List<String> res = new ArrayList<>();
        for(var entry : map.entrySet()){
            int num = entry.getValue();
            String ip = entry.getKey();
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(num)+" "+ip);
            res.add(stringBuffer.toString());
        }
        return res;
    }
}
