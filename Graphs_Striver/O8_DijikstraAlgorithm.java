// import java.util.*;

// public class O8_DijikstraAlgorithm {
//     private class Pair implements Comparable<Pair>{
//         int node ;
//         int dist; 
//         Pair(int n , int d){
//             node = n ; 
//             dist = d; 
//         }
//         public int compareTo(Pair other){
//             return this.dist - other.dist; 
//         }
//     }
//     public int[] dijkstra(int V, int[][] edges, int src) {
//         List<List<Pair>> adj = new ArrayList<>(); 
//         int dist[] = new int[V]; 
//         Arrays.fill(dist , Integer.MAX_VALUE); 
//         for(int i = 0 ; i< V ; i++){
//             adj.add(new ArrayList<>()); 
//         }
//         for(int edge[] : edges){
//             int u = edge[0];
//             int v = edge[1]; 
//             int w = edge[2]; 
//             adj.get(u).add(new Pair(v , w)); 
//         }
//         dist[src] = 0 ;
//         PriorityQueue<Pair> pq = new PriorityQueue<>();
//         pq.offer(new Pair(src , 0)); 
        
//         while(!pq.isEmpty()){
//             Pair curr = pq.poll(); 
//             int n = curr.node;
//             int d = curr.dist; 
            
//             for(Pair neighbour : adj.get(n)){
//                 int adjNode = neighbour.node; 
//                 int weight = neighbour.dist; 
                
//                 if(d + weight < dist[adjNode]){
//                     dist[adjNode] = d + weight; 
//                     pq.offer(new Pair(adjNode , dist[adjNode])); 
//                 }
//             }
//         }
//         return dist; 
//     }
// }
