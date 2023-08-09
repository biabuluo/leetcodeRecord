package others;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{22:53}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 独一无二出现次数
 */
public class t1207 {
    //思路：hash
    public boolean uniqueOccurrences(int[] arr) {
        int []hash = new int[1001];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            hash[entry.getValue()]++;
            if(hash[entry.getValue()]>1) return false;
        }
        return true;
    }
}
