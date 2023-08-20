package random;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 小宇
 * @date {2023}-{08}-{20}:{12:25}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 宝石与石头
 */
public class t771 {
    //思路：hash
    public int numJewelsInStones(String jewels, String stones) {
        char[] jewelsList = jewels.toCharArray();
        char[] stonesList = stones.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : jewelsList) {
            set.add(c);
        }
        int res = 0;
        for(char c : stonesList){
            if(set.contains(c))
                res++;
        }
        return res;
    }
}
