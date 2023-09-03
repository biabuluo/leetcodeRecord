package random;

import java.util.Arrays;

/**
 * @author 小宇
 * @date 2023-09-03:10:35
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t1921 {

    public static void main(String[] args) {
        int[] dist = {3,2,4};
        int[] speed = {5,3,2};
        System.out.println(eliminateMaximum(dist, speed));
    }
    //排序，贪心
    public static int eliminateMaximum(int[] dist, int[] speed) {
        //计算所有怪兽到达的步数
        int n = dist.length;
        double[] step = new double[n];
        for(int i=0;i<n;i++){
            step[i] = dist[i]/(double)speed[i];
        }
        //排序
        Arrays.sort(step);
        //模拟
        int res = 0;
        for(int i=0;i<n;i++){
            if(i>=step[i])
                break;
            res++;
        }
        return res;
    }
}
