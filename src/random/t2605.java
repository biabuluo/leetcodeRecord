package random;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 小宇
 * @date 2023-09-05:8:59
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 从两个数字数组中生成最小数字
 */
public class t2605 {

    public int minOfArray(int[] num){
        int res = Integer.MAX_VALUE;
        for(var i:num){
            res = Math.min(res, i);
        }
        return res;
    }

    public int minNumber(int[] nums1, int[] nums2) {
        //考虑数组存在相同情况
        Integer res = Integer.MAX_VALUE;
        Set<Integer> collect1 = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toSet());
        for(var i: nums2){
            if(collect1.contains(i))
                res = Math.min(res, i);
        }
        if(res!=Integer.MAX_VALUE)
            return res;
        else {
            int a = minOfArray(nums1);
            int b = minOfArray(nums2);
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            return min*10+max;
        }
    }
}
