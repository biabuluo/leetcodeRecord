package random;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author 小宇
 * @date 2023-08-30:10:33
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 到家的最少跳跃次数
 */
public class t1654 {
    //思路：使用广度优先搜索
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        //广度优先搜索队列
        Queue<int[]> queue = new LinkedList<>();
        //确定BFS的上下限
        int forbidden_max = Arrays.stream(forbidden).max().getAsInt();
        int low = 0, upper = Math.max(forbidden_max+a, x)+b;
        //visited集合
        Set<Integer> visitedSet = new HashSet<>();
        //forbidden集合
        Set<Integer> forbiddenSet = Arrays.stream(forbidden)
                .boxed()
                .collect(Collectors.toSet());
        //初始化
        int []init = new int[]{0, 1, 0};
        queue.add(init);
        visitedSet.add(0);
        //BFS
        while (!queue.isEmpty()){
            int[] status = queue.poll();
            int position = status[0];
            int direction = status[1];
            int step = status[2];
            //终止状态
            if(position==x){
                return step;
            }
            //考虑前进
            int position_next = position+a;
            int direction_next = 1;
            int step_next = step++;
            if(position_next>=low && position_next<=upper
                    && !visitedSet.contains(position_next*direction_next)
                    && !forbiddenSet.contains(position_next)){
                queue.add(new int[]{position_next, direction_next, step_next});
                visitedSet.add(position_next*direction_next);
            }
            //考虑后退(-1不考虑后退)
            if(direction == 1){
                position_next = position-b;
                direction_next = -1;
                step_next = step++;
                if(position_next>=low && position_next<=upper
                        && !visitedSet.contains(position_next*direction_next)
                        && !forbiddenSet.contains(position_next)){
                    queue.add(new int[]{position_next, direction_next, step_next});
                    visitedSet.add(position_next*direction_next);
                }
            }
        }
        return -1;
    }
}
