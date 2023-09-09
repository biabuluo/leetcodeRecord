package random;

/**
 * @author 小宇
 * @date 2023-09-08:10:07
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 计算列车到站时间
 */
public class t2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime+delayedTime)%24;
    }
}
