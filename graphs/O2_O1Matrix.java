import java.util.LinkedList;
import java.util.Queue;

public class O2_O1Matrix {
    private class Pair {
        int row ;
        int col ; 
        int dist ; 
        Pair(int row , int col , int dist){
            this.row = row; 
            this.col = col ;
            this.dist = dist; 
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length ; 
        int m = mat[0].length ;
        int delRow[] = {-1 , 0 , 0 , 1};
        int delCol[] = {0 , -1 , 1 , 0};
        Queue<Pair> q = new LinkedList<>(); 
        int visited[][] = new int[n][m] ;
        int distance[][] = new int[n][m]; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j ++){
                if(mat[i][j] == 0){
                    q.offer(new Pair(i , j , 0)); 
                    visited[i][j] = 1; 
                }
                else{
                    visited[i][j] = 0 ; 
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row ; 
            int c = curr.col ; 
            int d = curr.dist; 

            distance[r][c] = d; 
            
            for(int i = 0 ; i < 4 ; i ++){
                int newRow = r + delRow[i]; 
                int newCol = c + delCol[i] ;

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                && visited[newRow][newCol] == 0 && mat[newRow][newCol] == 1){
                    visited[newRow][newCol] = 1;  
                    q.offer(new Pair(newRow , newCol , d + 1)); 
                }
            }
        }
        return distance ; 
    }
}
