package random;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 小宇
 * @date {2023}-{08}-{20}:{11:33}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二进制表示中质数个计算置位
 */
public class t762 {
    static Set<Integer> set = Set.of(2,3,5,7,11,13,17,19,23,29,31);

    public int count(int num){
        int res = 0;
        while (num!=0){
            num = num&(num-1);
            res++;
        }
        return res;
    }

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for(int i=left;i<=right;i++){
            if(set.contains(count(i))){
                res++;
            }
        }
        return res;
    }
}
