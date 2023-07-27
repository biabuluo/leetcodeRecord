package hashlist;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{07}-{26}:{22:31}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:字母异位词分组
 */
public class t49 {
    //思路：遍历排序，比较是否相同
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> hashmap = new HashMap<>();
        for (String str:strs) {
            char[] tmp1 = str.toCharArray();
            Arrays.sort(tmp1);
            String tmp2 = new String(tmp1);
            if (!hashmap.containsKey(tmp2)){
                ArrayList<String> tmp3 = new ArrayList<String>();
                tmp3.add(str);
                hashmap.put(tmp2, tmp3);
            }else {
                ArrayList<String> tmp3 = hashmap.get(tmp2);
                tmp3.add(str);
            }
        }
        return new ArrayList<>(hashmap.values());
    }
}
