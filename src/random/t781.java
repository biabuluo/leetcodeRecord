package random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小宇
 * @date 2023-08-27:11:26
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 森林中的兔子
 */
public class t781 {
    //思路：hash+贪心
    public int numRabbits(int[] answers) {
        int zeros = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(var i : answers){
            if (i==0){
                zeros++;
                continue;
            }
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int res = 0;
        for(var i : map.entrySet()){
            int num = i.getValue()/(i.getKey()+1);
            if(i.getValue()%(i.getKey()+1)==0)
                res+=num*(i.getKey()+1);
            else
                res += (num+1)*(i.getKey()+1);
        }
        return res+zeros;
    }
}
