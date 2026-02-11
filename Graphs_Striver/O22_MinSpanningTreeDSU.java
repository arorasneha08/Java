import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O22_MinSpanningTreeDSU {
    public class Pair{
        int node ; 
        int dist; 
        Pair(int node , int dist){
            this.node = node; 
            this.dist = dist; 
        }
    }
    public class DSU{
        List<Integer> parent ; 
        List<Integer> size;  
        DSU(int n){
            parent = new ArrayList<>();
            size = new ArrayList<>(); 
            
            for(int i = 0 ; i< n ; i++){
                parent.add(i); 
                size.add(1); 
            }
        }
        public int findParent(int node){
            if(parent.get(node) == node) return node ;
            int ul_parent = findParent(parent.get(node)); 
            parent.set(node , ul_parent); 
            return ul_parent; 
        }
        public void union(int u , int v){
            int pu = findParent(u); 
            int pv = findParent(v);
            if(pu == pv) return  ; 
            if(size.get(pu) < size.get(pv)){
                parent.set(pu , pv); 
                size.set(pu , size.get(pu) + size.get(pv)); 
            }
            else{
                parent.set(pv , pu); 
                size.set(pv , size.get(pu) + size.get(pv)); 
            }
        }
    }
    public int spanningTree(int V, int[][] edges) {
        DSU ds = new DSU(V); 
        Arrays.sort(edges , (a , b) -> a[2] - b[2]); 
        
        int sum = 0 ; 
        
        for(int edge[] : edges){
            int u = edge[0]; 
            int v = edge[1]; 
            int w = edge[2]; 
            if(ds.findParent(u) != ds.findParent(v)){
                sum += w ; 
                ds.union(u , v) ;
            }
        }
        return sum ; 
    }
}
