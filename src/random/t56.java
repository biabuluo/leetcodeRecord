package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 小宇
 * @date 2023-08-27:11:05
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 合并区间
 */
public class t56 {
    //思路：贪心+排序
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int cover = 0;
        int start = 0;
        for(int i=0;i<intervals.length;i++){
            if(i==0){
                cover = intervals[i][1];
                start = intervals[i][0];
            }else {
                if(cover>=intervals[i][0]){
                   //可以合并
                   cover = Math.max(cover, intervals[i][1]);
                }else {
                    //不可以合并
                    //更新答案
                    res.add(new int[]{start, cover});
                    start = intervals[i][0];
                    cover = intervals[i][1];
                }
            }
        }
        res.add(new int[]{start, cover});
        return res.toArray(int[][]::new);
    }
}
