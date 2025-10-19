package Backtracking;

class O16_CheckKnightTour {

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0) return false ; 
        // return helper(grid , 0,0,0) ;
        int delRow[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int delCol[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
        int row = 0 ; 
        int col = 0 ;

        for(int step = 1 ; step < n * n ; step ++){
            boolean found = false;
            for(int i = 0 ; i < 8 ; i++){
                int newRow = delRow[i] + row; 
                int newCol = delCol[i] + col ;
                if(newRow >= 0 && newRow < n && newCol >=0 && newCol < n){
                    if(grid[newRow][newCol] == step){
                        row = newRow; 
                        col = newCol; 
                        found = true; 
                        break; 
                    }
                }
            }
            if(!found) return false;
        } 
        return true;
    }
}