import java.util.*;

public class O19_NumberOfIslandsII {
    public class DSU{
        List<Integer> parent ; 
        List<Integer> rank ; 
        
        DSU(int n){
            parent = new ArrayList<>();
            rank = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                parent.add(i);
                rank.add(0); 
            }
        }
        public int findParent(int node){
            if(parent.get(node) == node) return node; 
            int ul_parent = findParent(parent.get(node));
            parent.set(node , ul_parent); 
            return ul_parent ; 
        }
        public void union(int u , int v){
            int pu = findParent(u);
            int pv = findParent(v); 
            if(pu == pv) return ; 
            
            if(rank.get(pu) < rank.get(pv)){
                parent.set(pu , pv); 
            }
            else if(rank.get(pv) < rank.get(pu)){
                parent.set(pv , pu); 
            }
            else{
                parent.set(pv , pu); 
                rank.set(pu , rank.get(pu) + 1); 
            }
        }
    }
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        List<Integer> res = new ArrayList<>();
        int mat[][] = new int[rows][cols]; 
        DSU ds = new DSU(rows * cols); 
        
        int delRow[] = {-1 , 0 , 1 , 0}; 
        int delCol[] = {0 , -1 , 0 , 1};
        
        int count = 0 ; 
        for(int i = 0 ; i < operators.length ; i++){
            int x =  operators[i][0]; 
            int y = operators[i][1]; 
            int node = x * cols + y ; 
            count ++; 
            
            if(mat[x][y] == 1){
                res.add(count) ;
                continue; 
            }
            mat[x][y] = 1; 
            
            for(int j = 0 ; j < 4 ; j++){
                int nr = delRow[j] + x; 
                int nc = delCol[j] + y ;
                int newNode = nr * cols + nc ;
                
                if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && mat[nr][nc] == 1){
                    ds.union(node , newNode); 
                    count -- ; 
                }
            }
        }
        return res; 
    }
}