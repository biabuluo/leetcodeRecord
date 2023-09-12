package random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 小宇
 * @date 2023-09-12:10:20
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 课程表IV
 */
public class t1462 {

    //思路：广度优先搜索+拓扑排序
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //构造入度数组+相邻关系
        int[] inDegree = new int[numCourses];
        List<List<Integer>> relationship = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            relationship.add(new ArrayList<>());
        for(var i : prerequisites){
            relationship.get(i[0]).add(i[1]);
            inDegree[i[1]]++;
        }
        //构造二维关系表
        Boolean[][] isPre = new Boolean[numCourses][numCourses];
        //广度优先搜索队列
        Queue<Integer> queue = new LinkedList<>();
        //所有入度为0的入队
        for (int i=0;i<numCourses;i++){
            if (inDegree[i]==0)
                queue.add(i);
        }

        //遍历
        while (!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> child = relationship.get(cur);
            for(var i : child){
                //更新boolean关系
                isPre[cur][i] = true;
                for (int j=0;j<numCourses;j++){
                    isPre[j][i] = isPre[j][i] | isPre[j][cur];
                }
                //更新队
                inDegree[i]--;
                if(inDegree[i]==0)
                    queue.add(i);
            }
        }

        //获取结果
        List<Boolean> resList = new ArrayList<>();
        for(var i : queries){
            resList.add(isPre[i[0]][i[1]]);
        }
        return resList;
    }
}
