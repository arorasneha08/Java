import java.util.Arrays;

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
