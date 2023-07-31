package greed;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{21:41}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 买卖股票
 */
public class t122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]-prices[i]>0){
                res+=prices[i+1]-prices[i];
            }
        }
        return res;
    }
}
