public class O11_SearchMatrix2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length ; 
        int row = 0 ; 
        int col = n-1; 
        while(row < n && col >= 0){
            if(matrix[row][col] == target){
                return true; 
            }
            else if(matrix[row][col] < target){
                row ++; 
            }
            else{
                col --  ;
            }
        }
        return false; 
    }
}
