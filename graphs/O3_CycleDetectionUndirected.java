import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O3_CycleDetectionUndirected {
    private boolean dfs(int node , int parent , List<List<Integer>> adj , int visited[] , int V){
        visited[node] = 1 ; 
        
        for(int adjNode : adj.get(node)){
            if(visited[adjNode] == 0){
                if(dfs(adjNode ,node ,  adj , visited , V)){
                    return true; 
                }
            }
            else if(visited[adjNode] == 1 && adjNode != parent){
                return true; 
            }
        }
        return false ;
    }
    private class Pair{
        int node ;
        int parent ; 
        Pair(int node , int parent){
            this.node = node; 
            this.parent = parent ; 
        }
    }
    private boolean bfs(int node , List<List<Integer>> adj , int visited[] , int V){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(node , -1));
        visited[node] = 1; 
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int currNode = curr.node; 
            int parentNode = curr.parent; 
            
            for(int adjNode : adj.get(currNode)){
                if(visited[adjNode] == 0){
                    q.offer(new Pair(adjNode , currNode)); 
                    visited[adjNode] = 1; 
                }
                else if(visited[adjNode] == 1 && adjNode != parentNode){
                    return true; 
                }
            }
        }
        return false; 
    }
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0 ; i< V ; i++){
            adj.add(new ArrayList<>()); 
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1]; 
            adj.get(u).add(v); 
            adj.get(v).add(u);
        }
        int visited[] = new int[V] ; 
        // for(int i = 0 ; i < V ; i++){
        //     if(visited[i] == 0){
        //         if(dfs(i , -1 , adj , visited , V)){
        //             return true; 
        //         } 
        //     }
        // }
        // return false; 
        
        for(int i = 0 ; i < V ; i++){
            if(visited[i] == 0){
                if(bfs(i , adj , visited , V)){
                    return true; 
                }
            }
        }
        return false; 
    }
}
