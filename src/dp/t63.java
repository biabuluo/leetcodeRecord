package dp;

/**
 * @author 小宇
 * @date {2023}-{07}-{31}:{11:31}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1||obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1) return 0;
        obstacleGrid[0][0] = 1;
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[0].length;j++){
                if(i==0&&j==0) continue;
                if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                if(i==0){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                    continue;
                }
                if(j==0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i-1][j]+obstacleGrid[i][j-1];

            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

}
