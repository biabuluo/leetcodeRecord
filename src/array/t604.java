package array;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{07}-{24}:{22:13}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:水果成蓝
 */
public class t604 {
    //思路：快慢指针+hashmap
    public static int totalFruit(int[] fruits) {
        int bound = fruits.length-1;
        int slowp = 0 ;int res = 0;
        Map<Integer, Integer> backet = new HashMap<>();
        for (int fastp=0; fastp<=bound; fastp++){
            backet.put(fruits[fastp], backet.getOrDefault(fruits[fastp], 0)+1);
            while (backet.size()>2){
                backet.put(fruits[slowp], backet.get(fruits[slowp])-1);
                if(backet.get(fruits[slowp]) == 0) backet.remove(fruits[slowp]);
                slowp++;
            }
            res = Math.max(res, fastp-slowp+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int []fruits = {1,2,3,2,2};
        System.out.println(totalFruit(fruits));
    }
}
