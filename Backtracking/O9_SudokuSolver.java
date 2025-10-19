package Backtracking;

public class O9_SudokuSolver {
    public boolean valid(char board[][] , int row , int col){
        char ch = board[row][col]; 

        for(int i = 0 ; i < 9 ; i++){
            if(i != row && board[i][col] == ch) return false; 
            if(i != col && board[row][i] == ch) return false; 
        }
        int startRow = (row / 3) * 3 ;
        int startCol = (col / 3) * 3 ;

        for(int i = startRow ; i < startRow + 3 ; i ++){
            for(int j = startCol ; j < startCol + 3 ; j ++){
                if((i != row || j != col) && board[i][j] == ch) {
                    return false ; 
                }
            }
        }
        return true ; 
    }
    private boolean solve(char board[][]){
        for(int i = 0 ; i < 9 ; i ++){
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j] == '.'){
                    for(char ch = '1' ; ch <= '9' ; ch ++){
                        board[i][j] = ch ; 
                        if(valid(board , i , j) && solve(board)){
                            return true; 
                        }
                        board[i][j] = '.'; 
                    }
                    return false; 
                }
            }
        }
        return true ; 
    }
    public void solveSudoku(char[][] board) {
        solve(board); 
    }
}
