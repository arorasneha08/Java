import java.util.Arrays;
import java.util.PriorityQueue;

public class DP_Graph_MinCostPath {
    private class Pair implements Comparable<Pair>{
        int row ; 
        int col ; 
        int cost; 
        
        Pair(int row , int col , int cost){
            this.row = row; 
            this.col = col ; 
            this.cost = cost ; 
        }
        public int compareTo(Pair other){
            return this.cost - other.cost ; 
        }
    }
    public int minimumCostPath(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ; 
        
        int delRow[] = {-1 , 0 , 1 , 0} ; 
        int delCol[] = {0 , -1 , 0 , 1}; 
        
        int dist[][] = new int[n][m]; 
        for(int row[] : dist){
            Arrays.fill(row , Integer.MAX_VALUE); 
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        dist[0][0] = grid[0][0] ; 
        pq.offer(new Pair(0 , 0 , grid[0][0])); 
        
        while(!pq.isEmpty()){
            Pair p = pq.poll() ;
            int r = p.row ; 
            int c = p.col ; 
            int price = p.cost ; 
            
            if(r == n-1 && c == n-1) return price; 
            
            for(int i = 0 ; i < 4 ; i++){
                int newRow = delRow[i] + r ; 
                int newCol = delCol[i] + c ; 
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m ){
                    int newCost = price + grid[newRow][newCol]; 
                    
                    if(newCost < dist[newRow][newCol]){
                        dist[newRow][newCol] = newCost; 
                        pq.offer(new Pair(newRow , newCol , newCost)); 
                    }
                }
            }
        }
        return dist[n-1][n-1]; 
    }
}
