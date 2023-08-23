package random;

import java.util.Arrays;

/**
 * @author 小宇
 * @date {2023}-{08}-{23}:{11:40}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t2344 {
    public int gcd(int a, int b){
        while (b!=0){
            int c = a%b;
            a = b;
            b = c;
        }
        return a;
    }


    public int minOperations(int[] nums, int[] numsDivide) {
        int len = numsDivide.length;
        int g;
        if(len ==1)
            g = numsDivide[0];
        else g = gcd(numsDivide[0], numsDivide[1]);
        for(int i=2; i<numsDivide.length;i++){
            g = gcd(g, numsDivide[i]);
        }
        Arrays.sort(nums);
        int idx = 0;
        for(idx = 0; idx<nums.length; idx++){
            if(g % nums[idx] == 0)
                return idx;
        }
        return -1;
    }
}
