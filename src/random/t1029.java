package random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 小宇
 * @date {2023}-{08}-{15}:{21:05}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 两地调度
 */
public class t1029 {
    public static void main(String[] args) {
        int [][]costs = {{518,518},{71,971},{121,862},{967,607},{138,754},{513,337},{499,873},{337,387},{647,917},{76,417}};
        System.out.println(twoCitySchedCost(costs));
    }
    public static int twoCitySchedCost(int[][] costs) {
        //思路：贪心
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff1 = Math.abs(o1[0]-o1[1]);
                int diff2 = Math.abs(o2[0]-o2[1]);
                return Integer.compare(diff1, diff2);
            }
        });

        int n = costs.length;
        int a = n/2, b=n/2;
        int res = 0;
        for(int i=n-1;i>=0;i--){
            int cost_a = costs[i][0];
            int cost_b = costs[i][1];
            if(cost_b<cost_a && b>0 || a<=0){
                res+=cost_b;
                b--;
            }else {
                res+=cost_a;
                a--;
            }
        }
        return res;
    }
}
