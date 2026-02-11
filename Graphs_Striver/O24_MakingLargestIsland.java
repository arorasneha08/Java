import java.util.HashMap;
import java.util.HashSet;

public class O24_MakingLargestIsland {
    class DSU {
        int[] parent, rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int findParent(int node){
            if(parent[node] != node)
                parent[node] = findParent(parent[node]);
            return parent[node];
        }

        void union(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu == pv) return;

            if(rank[pu] < rank[pv]){
                parent[pu] = pv;
            }
            else if(rank[pu] > rank[pv]){
                parent[pv] = pu;
            }
            else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }

    int[] drow = {1, 0, -1, 0};
    int[] dcol = {0, 1, 0, -1};

    private int dfs(int r, int c, int[][] grid, boolean[][] vis, DSU ds){
        int n = grid.length;
        vis[r][c] = true;
        int size = 1;

        for(int k = 0; k < 4; k++){
            int nr = r + drow[k];
            int nc = c + dcol[k];
            if(nr >= 0 && nc >= 0 && nr < n && nc < n &&
               !vis[nr][nc] && grid[nr][nc] == 1){
                ds.union(r*n + c, nr*n + nc);
                size += dfs(nr, nc, grid, vis, ds);
            }
        }
        return size;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU ds = new DSU(n*n);
        boolean[][] vis = new boolean[n][n];
        HashMap<Integer, Integer> compSize = new HashMap<>();

        // Step 1: Find all existing islands
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int size = dfs(i, j, grid, vis, ds);
                    int parent = ds.findParent(i*n + j);
                    compSize.put(parent, size);
                }
            }
        }

        int max = 0;

        // Step 2: Try flipping each 0
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> seen = new HashSet<>();
                    int curr = 1;

                    for(int k = 0; k < 4; k++){
                        int nr = i + drow[k];
                        int nc = j + dcol[k];
                        if(nr >= 0 && nc >= 0 && nr < n && nc < n &&
                           grid[nr][nc] == 1){
                            int p = ds.findParent(nr*n + nc);
                            if(seen.add(p)){
                                curr += compSize.get(p);
                            }
                        }
                    }
                    max = Math.max(max, curr);
                }
            }
        }

        return max == 0 ? n*n : max;
    }
}
