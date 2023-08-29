package random;

import java.util.*;

/**
 * @author 小宇
 * @date 2023-08-29:10:52
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 带因子的二叉树
 */
public class t823 {
    public static final int MOD = 1000000007;
    //思路：dp+hash
    public int numFactoredBinaryTrees(int[] arr) {
        int res = 0;
        Arrays.sort(arr);
        //定义dp+hash
        int []dp = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();
        //初始化dp
        map.put(arr[0], 0);
        dp[0] = 1;
        res = 1;
        Arrays.fill(dp, 1);
        //遍历dp
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                int other = 0;
                if(arr[i]%arr[j]==0){
                    other = arr[i]/arr[j];
                    if(map.containsKey(other)){
                        dp[i] = (dp[i]+(dp[j]*dp[map.get(other)])%MOD)%MOD;
                    }
                }
            }
            res =(res + dp[i])%MOD;
            map.put(arr[i], i);
        }
        return res;
    }
}
