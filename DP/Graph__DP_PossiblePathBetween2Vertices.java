import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph__DP_PossiblePathBetween2Vertices {
    public int dfs(int node , int dest , ArrayList<ArrayList<Integer>> adj , int dp[]){
        if(node == dest) return 1 ;
        if(dp[node] != -1) return dp[node] ;
        
        int ways = 0 ; 
        for(int adjNode : adj.get(node)){
            ways += dfs(adjNode , dest , adj, dp); 
        }
        return dp[node] = ways ; 
    }
    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source, int destination) {
        int dp[] = new int[V]; 
        Arrays.fill(dp , -1); 
        return dfs(source , destination , adj , dp); 
    }
    public int bfs(int V, ArrayList<ArrayList<Integer>> adj, int source, int destination) {
        int indegree[] = new int[V]; 
        for(int i = 0 ; i < V ; i++){
            for(int adjNode : adj.get(i)){
                indegree[adjNode] ++; 
            }
        }
        Queue<Integer> q = new LinkedList<>(); 
        for(int i = 0 ; i< V ; i++){
            if(indegree[i] == 0){
                q.offer(i); 
            }
        }
        long dp[] = new long[V]; 
        dp[source] = 1 ; 
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int adjNode :adj.get(curr)){
                dp[adjNode] += dp[curr] ; 
                indegree[adjNode] -- ;
                if(indegree[adjNode] == 0){
                    q.offer(adjNode);     
                }
            }
        }
        return (int) dp[destination];
    }
}

// gfg 