package random;

/**
 * @author 小宇
 * @date 2023-09-01:10:27
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 买钢笔和铅笔的方案数
 */
public class t2240 {
    //思路：回溯  超出时间限制
    public int total = 0;
    public int sum = 0;
    public int res = 1;

    public void backTracking(int cost1, int cost2){
        if(total-sum <cost1 || total-sum<cost2){
            return;
        }
        //花费cost1
        sum+=cost1;
        backTracking(cost1, cost2);
        res++;
        sum-=cost1;
        //花费cost2
        sum+=cost2;
        backTracking(cost1, cost2);
        res++;
        sum-=cost2;
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        this.total = total;
        backTracking(cost1, cost2);
        return res;
    }



    //思路2：模拟
    public long func(int total, int cost1, int cost2){
        int max = Math.max(cost1, cost2);
        int min = Math.min(cost1, cost2);
        int res = 0; //什么都不买
        //计算可以买大的max的情况
        for(int i=0;i*max<=total;i++){
            //剩下的钱拿去买多少只min
            int left = total-i*max;
            res += left/min+1;
        }
        return res;
    }


}
