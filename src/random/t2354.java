package random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 小宇
 * @date {2023}-{08}-{23}:{12:04}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 优质数对的数目
 */
public class t2354 {

    public int countBits(int target){
        int res = 0;
        int num = target;
        while (num!=0){
            num = num&(num-1);
            res++;
        }
        return res;
    }
    //思路：c(x|y)+c(x&y) = c(x)+c(y)
    public long countExcellentPairs(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(var i : nums)
            set.add(i);
        for(var i : set) {
            int count = countBits(i);
            cnt.put(count, cnt.getOrDefault(count, 0)+1);
        }
        long res = 0;
        for(var i : cnt.entrySet()){
            for(var j : cnt.entrySet()){
                if(i.getKey()+j.getKey()>= k){
                    res += i.getValue()*j.getValue();
                }
            }
        }
        return res;
    }
}
