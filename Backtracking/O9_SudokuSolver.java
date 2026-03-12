package Backtracking;

public class O9_SudokuSolver {
    private boolean isValid(int r , int c , int val , char board[][]){
        for(int i = 0 ; i < 9 ; i++){
            if(board[r][i] == val) return false; 
            if(board[i][c] == val) return false; 
        }
        int startRow = (r / 3) * 3 ; 
        int startCol = (c / 3) * 3 ; 
        for(int i = startRow ; i < startRow + 3 ; i++){
            for(int j = startCol ; j < startCol + 3 ; j++){
                if(board[i][j] == val) return false ;
            }
        }
        return true; 
    }
    private boolean solve(char board[][]){
        int n = board.length ; 
        int m = board[0].length ; 

        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == '.'){
                    for(char ch = '1' ; ch <= '9' ; ch ++){
                        if(isValid(i , j , ch , board)){
                            board[i][j] = ch ; 

                            if(solve(board)) return true; 

                            board[i][j] = '.'; 
                        }
                    }
                    return false ; 
                }
            }
        }
        return true ; 
    }
    public void solveSudoku(char[][] board) {
        solve(board); 
    }
}
