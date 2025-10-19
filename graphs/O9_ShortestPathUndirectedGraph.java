import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class O9_ShortestPathUndirectedGraph {
    private class Pair implements Comparable<Pair>{
        int node ; 
        int dist ; 
        Pair(int n , int d){
            node = n ; 
            dist = d ; 
        }
        public int compareTo(Pair other){
            return this.dist - other.dist; 
        }
    }
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size(); 
        int dist[] = new int[V]; 
        Arrays.fill(dist , Integer.MAX_VALUE) ;
        dist[src] = 0 ; 
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        pq.offer(new Pair(src , 0));
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll(); 
            int n = curr.node ;
            int d = curr.dist ; 
            
            for(int adjNode : adj.get(n)){
                if(d + 1 < dist[adjNode]){
                    dist[adjNode] = d + 1; 
                    pq.offer(new Pair(adjNode , dist[adjNode])); 
                }
            }
        }
        for(int i = 0 ; i < V ; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1; 
            }
        }
        return dist; 
    }
}
