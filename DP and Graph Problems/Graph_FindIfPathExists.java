import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph_FindIfPathExists {
    public class DisjointSet{
        List<Integer> rank ; 
        List<Integer> parent ; 

        DisjointSet(int n){
            rank = new ArrayList<>(); 
            parent = new ArrayList<>(); 
            for(int i = 0 ; i < n ; i++){
                rank.add(0); 
                parent.add(i); 
            }
        }

        public int findParent(int node){
            if(node == parent.get(node)){
                return node; 
            }
            int ul_parent = findParent(parent.get(node)); 
            parent.set(node , ul_parent); 
            return ul_parent; 
        }
        public void union(int u , int v){
            int p_u = findParent(u);
            int p_v = findParent(v);

            if(p_u == p_v) return ;   
            if(rank.get(p_u) < rank.get(p_v)){
                parent.set(p_u , p_v); 
            }
            else if(rank.get(p_u) > rank.get(p_v)){
                parent.set(p_v , p_u); 
            }
            else {
                parent.set(p_v , p_u); 
                rank.set(p_u , rank.get(p_u) + 1); 
            }
        }
    }
    public boolean bfs(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<>()); 
        }
        for(int edge[] : edges){
            int u = edge[0]; 
            int v = edge[1]; 
            adj.get(u).add(v); 
            adj.get(v).add(u); 
        }
        Queue<Integer> q = new LinkedList<>(); 
        q.offer(source); 
        int visited[] = new int[n]; 
        visited[source] = 1;  

        while(!q.isEmpty()){
            int curr = q.poll(); 
            visited[curr] = 1; 
            for(int adjNode : adj.get(curr)){
                if(visited[adjNode] == 0){
                    q.offer(adjNode); 
                    visited[adjNode] = 1;
                }   
            }
        }
        if(visited[destination] == 1) return true; 
        return false; 
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSet ds = new DisjointSet(n); 
        for(int edge[] : edges){
            int u = edge[0]; 
            int v = edge[1]; 
            ds.union(u , v); 
        }
        return ds.findParent(source) == ds.findParent(destination); 
    }
}
