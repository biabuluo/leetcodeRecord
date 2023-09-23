package others;

/**
 * @author 小宇
 * @date 2023-09-20:10:15
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class LCP06 {
    public int minCount(int[] coins) {
        int res = 0;
        for(var i : coins){
            res += i/2;
            if(i%2!=0){
                res++;
            }
        }
        return res;
    }
}
