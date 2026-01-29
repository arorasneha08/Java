import java.util.ArrayList;
import java.util.List;

public class O5_DirectedGrapgCycle {
    private boolean dfs(int node , List<List<Integer>> adj , int visited[] , int pathVisited[]){
        visited[node] = 1; 
        pathVisited[node] = 1;  
        
        for(int adjNode : adj.get(node)){
            if(visited[adjNode] == 0){
                if(dfs(adjNode , adj , visited , pathVisited)){
                    return true ;
                } 
            }
            else if(visited[adjNode] == 1 && pathVisited[adjNode] == 1){
                return true ; 
            }
        }
        visited[node] = 0; 
        pathVisited[node] = 0;  
        
        return false; 
    }
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>() ; 
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>()); 
        }
        for(int edge[] : edges){
            int u = edge[0] ; 
            int v = edge[1]; 
            adj.get(u).add(v); 
        }
        int visited[] = new int[V]; 
        int pathVisited[] = new int[V]; 
        for(int i = 0 ; i < V ; i++){
            if(visited[i] == 0){
                if(dfs(i , adj , visited , pathVisited)){
                    return true; 
                } 
            }
        }
        return false; 
    }
}
