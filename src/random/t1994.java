package random;

import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{08}-{21}:{11:41}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 好子集的数目
 */
public class t1994 {
    static int MOD = 1000000007;
    //30以内质数
    static List<Integer> prime = List.of(2,3,5,7,11,13,17,19,23,29);
    //构造掩码数组
    static int []mask = new int[31];
    static {
        for(int i=2;i<=30;i++){
            for(int j=0;j<prime.size();j++){
                int tmpprime = prime.get(j);
                if(i%tmpprime==0){
                    if(i%(tmpprime*tmpprime)==0)
                        mask[i] = -1;
                    else
                        mask[i] |= 1<<j;
                }
            }
        }
    }
    //状态压缩+dp
    public int numberOfGoodSubsets(int[] nums) {
        int len = prime.size();
        //定义dp数组
        int []dp = new int[1<<len];
        //初始化dp
        dp[0] = 1;
        //遍历dp数组
        for (int num : nums) {
            int msk = mask[num];
            if (msk >= 0) {
                for (int j = dp.length - 1; j >= msk; j--) {
                    if ((j | msk) == j)
                        dp[j] = (dp[j] + dp[j ^ msk]) % MOD;
                }
            }
        }
        //求结果
        int res = 0;
        for (int mask = 1; mask < dp.length; ++mask) {
            res = (res + dp[mask]) % MOD;
        }

        return res;
    }
}
