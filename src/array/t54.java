package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{25}:{21:18}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:螺旋矩阵
 */
public class t54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new LinkedList<>();
        int l = 0;
        int r = matrix[0].length - 1;
        int u = 0;
        int d = matrix.length - 1;
        List<Integer> list = new LinkedList<>();
        while (l <= r && u <= d){
            for (int i = l; i <= r; i++) {
                list.add(matrix[u][i]);
            }
            u++;
            for (int i = u; i <= d; i++) {
                list.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >= l && u <= d; i--) {
                list.add(matrix[d][i]);
            }
            d--;
            for (int i = d; i >= u && l <= r; i--) {
                list.add(matrix[i][l]);
            }
            l++;
        }
        return list;
    }

    public static void main(String[] args) {
        int [][]matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralOrder(matrix);
    }
}
