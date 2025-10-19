import java.util.*;

public class O17_CheckPathExists {
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
