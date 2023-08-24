package others;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{08}-{24}:{13:34}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 单线程CPU
 */
public class t1834 {
    //思路：数据结构模拟
    public int[] getOrder(int[][] tasks) {
        int curtime = 1;
        int n = 0;
        int num = tasks.length;
        int cur = 0;
        int []res = new int[num];
        //构造新数组
        int [][]newTasks = new int[num][3];
        for(int i=0;i<num;i++){
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;
        }
        //按达到时间排序
        Arrays.sort(newTasks, (o1, o2)->o1[0]-o2[0]);
        //已到达任务队列
        Queue<int[]> queue = new PriorityQueue<>((o1, o2)->{
            if(o1[1]==o2[1])
                return o1[2] - o2[2];
            else return o1[1]-o2[1];
        });
        while (n<num){
            //到达任务入队
            while (cur<num && newTasks[cur][0]<=curtime){
                queue.add(newTasks[cur]);
                cur++;
            }
            //选择队列任务进行处理
            if(!queue.isEmpty()){
                int []curtask = queue.poll();
                curtime+=curtask[1];
                res[n] = curtask[2];
                n++;
            }else curtime = newTasks[cur][0];
        }
        return res;
    }
}
