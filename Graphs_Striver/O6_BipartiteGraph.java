import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O6_BipartiteGraph {
    private boolean dfs(int node , int col , int graph[][] , int color[]){
        color[node] = col ; 
        
        for(int adjNode : graph[node]){
            if(color[adjNode] == -1){
                if(!dfs(adjNode , 1 - col , graph , color)){
                    return false; 
                } 
            }
            else if(color[adjNode] == color[node]){
                return false;
            }
        }
        return true; 
    }
    private boolean bfs(int node , int col , List<List<Integer>> adj , int color[]){
        Queue<Integer> q = new LinkedList<>(); 
        q.offer(node) ;
        color[node] = 0 ; 
        
        while(!q.isEmpty()){
            int curr = q.poll(); 
            
            for(int adjNode : adj.get(curr)){
                if(color[adjNode] == -1){
                    color[adjNode] = 1 - color[curr]; 
                    q.offer(adjNode); 
                }
                else if(color[adjNode] == color[curr]){
                    return false; 
                }
            }
        }
        return true; 
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length ; 
        int color[] = new int[n]; 
        Arrays.fill(color , -1); 
        for(int i = 0 ; i< n ; i++){
            if(color[i] == -1){
                if(!dfs(i , 0 , graph, color)){
                    return false; 
                } 
            }
        }
        return true; 
    }
}
