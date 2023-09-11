package random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 小宇
 * @date 2023-09-11:10:32
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 课程表III
 */
public class t630 {
    //思路：贪心+优先队列
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, ((o1, o2) -> o1[1]-o2[1]));
        //优先队列：课程耗时降序排列
        Queue<Integer> queue = new PriorityQueue<>((o1, o2)->o2-o1);
        //遍历所有课程情况
        int sum = 0;
        for(var i:courses){
            if(sum+i[0]<=i[1]){
                sum+=i[0];
                queue.add(i[0]);
            }
            //当前最耗时的替换
            else if(!queue.isEmpty() && queue.peek()>i[0]){
                int ti = queue.poll();
                sum -= ti;
                sum += i[0];
                queue.add(i[0]);
            }
        }
        return queue.size();
    }
}
