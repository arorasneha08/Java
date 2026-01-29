import java.util.Arrays;
import java.util.PriorityQueue;

public class O10_PairWithMinEffort {
    private class Pair implements Comparable<Pair>{
        int row ; 
        int col ; 
        int effort ; 

        Pair(int r , int c , int e){
            row = r ;
            col = c ; 
            effort = e; 
        }
        public int compareTo(Pair other){
            return this.effort - other.effort ;
        }
    }
    public int minimumEffortPath(int[][] grid) {
        int n = grid.length; 
        int m = grid[0].length; 
        int delRow[] = {-1 , 0 , 1 , 0}; 
        int delCol[] = {0 , -1 , 0 , 1}; 

        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        pq.offer(new Pair(0, 0, 0));

        int dist[][] = new int[n][m]; 
        for(int row[] : dist){
            Arrays.fill(row , Integer.MAX_VALUE);
        }

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int r = curr.row; 
            int c = curr.col ; 
            int e = curr.effort ;

            if(r == n-1 && c == m-1) return e ; 

            for(int i = 0 ; i < 4 ; i ++){
                int newRow = delRow[i] + r; 
                int newCol = delCol[i] + c; 

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m ){
                    int diff = Math.abs(grid[r][c] - grid[newRow][newCol]); 
                    int newEffort = Math.max(e , diff); 
                    if(newEffort < dist[newRow][newCol]){
                        dist[newRow][newCol] = newEffort; 
                        pq.offer(new Pair(newRow , newCol , newEffort)); 
                    }
                }
            }
        }
        return 0; 
    }
}
