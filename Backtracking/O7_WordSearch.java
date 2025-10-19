package Backtracking ; 

public class O7_WordSearch {
    private boolean dfs(int i , int j , int idx , char mat[][] , String word, int visited[][]){
        int n = mat.length ;
        int m = mat[0].length ; 
        if(idx == word.length()) return true; 
        if(i >= n || j >= m || i < 0 || j < 0) return false; 

        if(visited[i][j] == 1 || mat[i][j] != word.charAt(idx)) return false ; 

        visited[i][j] = 1 ; 
        boolean left = dfs(i , j-1 , idx + 1 , mat , word, visited);
        boolean right = dfs(i , j+1 , idx + 1, mat , word , visited); 
        boolean top = dfs(i + 1 , j , idx + 1 , mat , word , visited); 
        boolean bottom = dfs(i - 1 , j , idx + 1 , mat , word , visited); 
        visited[i][j] = 0 ; 

        return left || right || top || bottom ; 
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length ;
        int m = board[0].length ; 
        int visited[][] = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(dfs(i , j , 0, board , word , visited)){
                    return true; 
                } 
            }
        }
        return false; 
    }
}
