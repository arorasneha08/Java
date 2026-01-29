package Graphs;
import java.util.*;

public class Graph_MinOpToMakeHospitalConnected {
    public class DSU{
        List<Integer> parent; 
        List<Integer> size; 
        
        DSU(int n){
            parent = new ArrayList<>(); 
            size = new ArrayList<>(); 
            for(int i = 0 ; i < n ;i++){
                parent.add(i); 
                size.add(1); 
            }
        }

        public int findParent(int node){
            if(node == parent.get(node)) return node ; 
            int ul_parent = findParent(parent.get(node)); 
            parent.set(node, ul_parent); 
            return ul_parent; 
        }
        public void union(int a , int b){
            int pa = findParent(a); 
            int pb = findParent(b); 
            if(pa == pb) return ; 
            
            if(size.get(pa) < size.get(pb)){
                parent.set(pa , pb); 
                size.set(pb , size.get(pb) + size.get(pa)); 
            }
            else{
                parent.set(pb , pa); 
                size.set(pa , size.get(pa) + size.get(pb)); 
            }
        }
    }
    public int minConnect(int V, int[][] edges) {
        int extra = 0 ; 
        DSU ds = new DSU(V); 
        for(int edge[] : edges){
            int a = edge[0];
            int b = edge[1]; 
            if(ds.findParent(a) == ds.findParent(b)){ // edges involved in cycle -> extra edges 
                extra ++ ; 
            }
            ds.union(a , b); 
        }
        int count = 0 ; 
        for(int i = 0 ; i < V ; i++){
            if(ds.findParent(i) == i){
                count ++;  // count components 
            }
        }
        int required = count - 1; 
        if(extra >= required){
            return required ; 
        }
        return -1; 
    }
}
