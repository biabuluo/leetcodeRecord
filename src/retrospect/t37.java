package retrospect;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{20:10}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 解数独
 */
public class t37 {

    public boolean isValid(char[][]board, int row, int col, char val){
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean backtracking(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.')continue;
                for(char k='1';k<='9';k++){
                    if(isValid(board, i, j, k)){
                        board[i][j] = k;
                        if(backtracking(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }
}
