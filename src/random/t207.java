package random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 小宇
 * @date 2023-09-09:10:37
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 课程表
 */
public class t207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //存储结果
        int[] res = new int[numCourses];
        //构造先选结点关系+入度关系
        int []degree = new int[numCourses];
        List<List<Integer>> relation = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            relation.add(new ArrayList<>());
        }
        //存储上一结点的关系
        for(var info : prerequisites){
            relation.get(info[0]).add(info[1]);
            degree[info[0]]++;
        }
        //使用queue存储可用o入度结点
        Queue<Integer> queue = new LinkedList<>();
        //遍历所有结点,入度为0的入队
        for(int i=0;i<numCourses;i++){
            if(degree[i]==0){
                queue.add(i);
            }
        }
        //遍历所有队中入度为零的结点
        int idx = 0;
        while (!queue.isEmpty()){
            //存储结果
            Integer poll = queue.poll();
            res[idx++] = poll;
            //更新结点关系
            for(int i=0;i<numCourses;i++){
                if(relation.get(i).contains(poll)){
                    degree[i]--;
                    if(degree[i]==0)
                        queue.add(i);
                }
            }
        }
        if(idx == numCourses)
            return true;
        else return false;
    }
}
