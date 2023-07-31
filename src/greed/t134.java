package greed;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{22:44}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cursum = 0; int totalsum = 0; int startIndex = 0;
        for(int i=0;i< gas.length;i++){
            cursum += gas[i]-cost[i];
            totalsum+=gas[i]-cost[i];
            if(cursum<0){
                startIndex = (i+1)% gas.length;
                cursum = 0;
            }
        }
        if(totalsum>=0) return startIndex;
        else return -1;
    }
}
