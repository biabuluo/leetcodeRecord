package random;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{08}-{18}:{16:06}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 重排水果
 */
public class t2561 {
    public static void main(String[] args) {
        int []l1 = {4,2,2,2};
        int []l2 = {1,4,1,2};
        System.out.println(minCost(l1, l2));
    }
    //思路：贪心？
    public static long minCost(int[] basket1, int[] basket2) {
        var map = new HashMap<Integer, Integer>();
        for(int i=0;i<basket1.length;i++){
            map.put(basket1[i], map.getOrDefault(basket1[i], 0)+1);
            map.put(basket2[i], map.getOrDefault(basket2[i], 0)-1);
        }
        //最小值当跳板
        int mn = Integer.MAX_VALUE;
        //重新构造要交换的数组
        List<Integer> a = new ArrayList<>();
        for(var entry : map.entrySet()){
            int x = entry.getKey();
            int y = entry.getValue();
            if(y%2!=0) return -1;
            mn = Math.min(mn, x);
            //只取一半
            for(y = Math.abs(y)/2;y>0;y--){
                a.add(x);
            }
        }
        long res = 0;
        a.sort((x, y)->x-y);
        for(int i=0;i<a.size()/2;i++){
            res += Math.min(a.get(i), mn*2);
        }
        return res;
    }
}
