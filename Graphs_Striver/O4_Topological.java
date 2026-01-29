import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class O4_Topological {
    private static void dfs(int node , List<List<Integer>> adj, Stack<Integer> st,
    int visited[]){
        visited[node] = 1 ; 
        for(int adjNode : adj.get(node)){
            if(visited[adjNode] == 0){
                dfs(adjNode , adj , st , visited); 
            }
        }
        st.push(node); 
    }
    private static ArrayList<Integer> bfs(List<List<Integer>> adj , int V){
        ArrayList<Integer> res = new ArrayList<>(); 
        int indegree[] = new int[V]; 
        for(int i = 0 ; i < V; i++){
            for(int adjNode : adj.get(i)){
                indegree[adjNode] ++; 
            }
        }
        Queue<Integer> q = new LinkedList<>() ;
        for(int i = 0 ; i < V ; i++){
            if(indegree[i] == 0){
                q.offer(i); 
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll() ;
            res.add(curr) ;
            
            for(int adjNode : adj.get(curr)){
                indegree[adjNode] -- ; 
                if(indegree[adjNode] == 0){
                    q.offer(adjNode); 
                }
            }
        }
        if(res.size() < V) return new ArrayList<>(); 
        return res; 
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>(); 
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>()); 
        }
        for(int edge[] : edges){
            int u = edge[0] ;
            int v = edge[1]; 
            adj.get(u).add(v); 
        }
        // int visited[] = new int[V]; 
        // Stack<Integer> st = new Stack<>(); 
        // for(int i = 0 ; i < V ; i++){
        //     if(visited[i] == 0){
        //         dfs(i , adj , st, visited); 
        //     }
        // }
        // while(!st.isEmpty()){
        //     res.add(st.pop()); 
        // }
        // return res; 
        
        return bfs(adj , V);
       
        
    }
}
