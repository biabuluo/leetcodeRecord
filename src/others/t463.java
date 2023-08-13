package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{13}:{16:46}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 岛屿的周长
 */
public class t463 {
    public int islandPerimeter(int[][] grid) {
        int [][]newgrid = new int[grid.length+2][grid[0].length+2];
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                newgrid[i+1][j+1] = grid[i][j];
            }
        }
        int res = 0;
        for(int i=1;i<=newgrid.length-2;i++){
            for(int j=1;j<= newgrid[0].length-2;j++){
                if(newgrid[i][j]==1){
                    if(newgrid[i-1][j]==0) res++;
                    if(newgrid[i+1][j]==0) res++;
                    if(newgrid[i][j-1]==0) res++;
                    if(newgrid[i][j+1]==0) res++;
                }
            }
        }
        return res;
    }
}
