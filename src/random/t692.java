package random;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{08}-{17}:{12:42}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 前K个高频单词
 */
public class t692 {
    public List<String> topKFrequent(String[] words, int k) {
        //思路：使用treemap？
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        List<String> res = new ArrayList<>();
        List<Map.Entry<String, Integer>> maplist = new ArrayList<>(map.entrySet());
        Collections.sort(maplist, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int val1 = o1.getValue();
                int val2 = o2.getValue();
                return val1==val2?o1.getKey().compareTo(o2.getKey()):Integer.compare(val2, val1);
            }
        });
        for(int i=0;i<k;i++){
            res.add(maplist.get(i).getKey());
        }
        return res;

    }
}
