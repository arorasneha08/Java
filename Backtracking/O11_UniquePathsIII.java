package Backtracking;

public class O11_UniquePathsIII {
    int paths = 0 ; 
    int empty = 1 ; 
    private void func(int i , int j , int grid[][] , int n , int m){
        if(i < 0 || j < 0 || j >= m || i >= n ) return ; 
        if(grid[i][j] == -1) return ; 
        if(grid[i][j] == 2) {
            if(empty == 0) {
                paths ++ ; 
            }
            return  ; 
        }

        grid[i][j] = -1;
        empty--;

        func(i + 1, j, grid, n, m);
        func(i - 1, j, grid, n, m);
        func(i, j + 1, grid, n, m);
        func(i, j - 1, grid, n, m);

        grid[i][j] = 0;
        empty++;
    }
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        int startRow = 0 ;
        int startCol = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    startRow = i ; 
                    startCol = j ; 
                }
                if(grid[i][j] == 0){
                    empty ++; 
                }
            }
        }
        func(startRow , startCol , grid , n , m); 
        return paths ; 
    }
}
