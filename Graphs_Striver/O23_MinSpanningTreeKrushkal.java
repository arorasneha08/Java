import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class O23_MinSpanningTreeKrushkal {
    public class Pair implements Comparable<Pair>{
        int node ;
        int dist; 
        Pair(int node , int dist){
            this.node = node ; 
            this.dist = dist; 
        }
        public int compareTo(Pair other){
            return this.dist - other.dist;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>()) ; 
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1] ; 
            int w = edge[2]; 
            adj.get(u).add(new Pair(v , w)); 
            adj.get(v).add(new Pair(u , w)); 
        }
        boolean visited[] = new boolean[V]; 
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        pq.offer(new Pair(0 , 0)); 
        int max = 0 ; 
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll(); 
            int currNode = curr.node ;
            int weight = curr.dist; 
            
            if(visited[currNode]) continue; 
            visited[currNode] = true; 
            max += weight; 
            
            for(Pair neigh : adj.get(currNode)){
                int adjNode = neigh.node; 
                int adjDist = neigh.dist; 
                if(visited[adjNode] == false){
                    pq.offer(new Pair(adjNode , adjDist)); 
                }
            }
        }
        return max; 
    }
}
