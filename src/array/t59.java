package array;

/**
 * @author 小宇
 * @date {2023}-{07}-{25}:{19:22}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 螺旋矩阵2
 */
public class t59 {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row=0,col=0, row_limit=n-1, col_limit=n-1;
        int val = 1;
        while (row<=row_limit&&col<=col_limit){
            if(val>n*n) break;
            for(int i=col; i<=col_limit; i++){
                res[row][i] = val++;
            }
            row++;
            for(int i=row; i<=row_limit; i++){
                res[i][col_limit] = val++;
            }
            col_limit--;
            for(int i=col_limit; i>=col; i--){
                res[row_limit][i] = val++;
            }
            row_limit--;
            for(int i=row_limit; i>=row; i--){
                res[i][col] = val++;
            }
            col++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateMatrix(4));
    }
}
