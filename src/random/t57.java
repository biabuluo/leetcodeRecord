package random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小宇
 * @date 2023-08-28:10:44
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 插入区间
 */
public class t57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> res = new ArrayList<>();
        if(intervals.length==0){
            res.add(newInterval);
            res.toArray(int[][]::new);
        }
        //插入再融合
        int len = intervals.length;
        int idx = 0;
        for(idx=0;idx<len;idx++){
            if(intervals[idx][0]<=newInterval[0])
                res.add(intervals[idx]);
            else break;
        }
        int []last;
        if(res.size()==0){
            last = newInterval;
        }else {
            last = res.remove(res.size()-1);
        }
        int start = last[0];
        int cover = last[1];
        if(newInterval[0]>cover){
            res.add(last);
            start = newInterval[0];
            cover = newInterval[1];
        }else {
            cover = Math.max(cover, newInterval[1]);
        }
        for(;idx<len;idx++){
            if(intervals[idx][0]>cover){
                res.add(new int[]{start, cover});
                start = intervals[idx][0];
                cover = intervals[idx][1];
            }else {
                cover = Math.max(cover, intervals[idx][1]);
            }
        }
        res.add(new int[]{start, cover});
        return res.toArray(int[][]::new);

    }
}
