import java.util.*;

public class Graph_PacificAtlanticFlow {
    public class Pair{
        int row ; 
        int col ;
        Pair(int row , int col){
            this.row = row; 
            this.col = col ; 
        }
    }
    private void bfs(Queue<Pair> q , boolean[][] visited , int arr[][]){
        int n = arr.length ; 
        int m = arr[0].length ; 

        int delRow[] = {-1 , 0 , 1 , 0};
        int delCol[] = {0 , -1 , 0 , 1}; 

        while(!q.isEmpty()){
            Pair curr = q.poll(); 
            int row = curr.row; 
            int col = curr.col ; 

            for(int i = 0 ; i < 4 ; i++){
                int newRow = delRow[i] + row ; 
                int newCol = delCol[i] + col; 

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol] ){
                    if(arr[newRow][newCol] >= arr[row][col]){
                        visited[newRow][newCol] = true; 
                        q.offer(new Pair(newRow , newCol)); 
                    }
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length ; 
        int m = arr[0].length ; 

        boolean pacific[][] = new boolean[n][m] ;
        boolean atlantic[][] = new boolean[n][m]; 

        Queue<Pair> aq = new LinkedList<>(); 
        Queue<Pair> pq = new LinkedList<>();

        for(int i = 0 ; i< n ; i++){
            pacific[i][0] = true; 
            atlantic[i][m-1] = true; 
            pq.offer(new Pair(i , 0)); 
            aq.offer(new Pair(i , m-1)); 
        }

        for(int j = 0 ; j< m ; j++){
            pacific[0][j] = true; 
            atlantic[n-1][j] = true; 
            pq.offer(new Pair(0 , j)); 
            aq.offer(new Pair(n-1 , j)); 
        }
        bfs(aq , atlantic, arr);
        bfs(pq , pacific , arr);

        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j++){
                if(atlantic[i][j] && pacific[i][j]){
                    res.add(Arrays.asList(i , j));
                }
            }
        }
        return res; 
    }
}
// leetcode 417 