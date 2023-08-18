package random;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 小宇
 * @date {2023}-{08}-{18}:{14:40}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 前往目标的最小代价
 */
public class t2662 {
    //思路：使用迪杰斯特拉求最短路径
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        //使用long表示int的二维坐标点
        long t = (long)target[0]<<32 | target[1];
        //dis记录从起点到目标点的最短距离
        Map<Long, Integer> dis = new HashMap<>();
        dis.put(t, Integer.MAX_VALUE);
        //初始点
        long s = (long)start[0]<<32 | start[1];
        dis.put(s, 0);
        //vis记录已经确定最短路径的点
        Set<Long> vis = new HashSet<>();
        while (true){
            long v = -1;
            int dv = -1;
            //已遍历的点挑选一条最短路径
            for(var e:dis.entrySet()){
                if(!vis.contains(e.getKey()) && (e.getValue()<dv || dv<0)){
                    v = e.getKey();
                    dv = e.getValue();
                }
            }
            //该点是终点
            if(v == t) return dv;
            //添加进vis
            vis.add(v);
            //从该点开始更新最短路
            int vx = (int)(v >> 32), vy = (int) (v & Integer.MAX_VALUE);
            //先初始化位曼哈顿距离
            dis.put(t, Math.min(dis.get(t), dv+Math.abs(target[0]-vx)+Math.abs(target[1]-vy)));
            //考虑特殊路径
            for(var r : specialRoads){
                int d = dv + Math.abs(r[0]-vx)+Math.abs(r[1]-vy)+r[4];
                long w = (long) r[2]<<32 | r[3];
                if(d<dis.getOrDefault(w, Integer.MAX_VALUE)){
                    dis.put(w, d);
                }
            }
        }
    }
}
