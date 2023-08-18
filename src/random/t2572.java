package random;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 小宇
 * @date {2023}-{08}-{18}:{17:49}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 无平方子集计数
 */
public class t2572 {
    //结果取mod
    private static int MOD = 1000000007;
    //状态压缩+背包问题
    //三十以内质数
    static int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    //1-30所有数的mask
    static int []mask = new int[31];
    static {
        for (int i = 2; i < mask.length; i++) {
            for (int j = 0; j < prime.length; j++) {
                int p = prime[j];
                if (i % p == 0) {
                    if (i % (p * p) == 0) {
//                        存在平方因子
                        mask[i] = -1;
                        break;
                    }
                    mask[i] |= 1 << j;
                }
            }
        }
    }
    public int squareFreeSubsets(int[] nums) {
        //定义dp数组
        int size = 1<<prime.length;
        int []dp = new int[size];
        //初始化dp数组
        dp[0] = 0;
        for(int i=0;i<nums.length;i++){
            int msk = mask[nums[i]];
            if(msk>=0){
                for(int j=size-1;j>=msk;j--){
                    dp[j] = dp[j]+dp[j^msk]%MOD;
                }
            }
        }
        long res = 0L;
        for(int v : dp)
            res += v;
        return (int) ((res-1)%MOD);
    }
}
