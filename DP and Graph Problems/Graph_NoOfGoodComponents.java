import java.util.ArrayList;

public class Graph_NoOfGoodComponents {
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] countNodes, int[] degSum) {
        visited[node] = true;
        countNodes[0]++;                   
        degSum[0] += adj.get(node).size();  

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                dfs(neigh, adj, visited, countNodes, degSum);
            }
        }
    }

    public static int findNumberOfGoodComponent(int E , int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V + 1];
        int goodComponents = 0;

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {

                int[] countNodes = new int[1];
                int[] degSum = new int[1];

                dfs(i, adj, visited, countNodes, degSum);

                int k = countNodes[0];                
                int actualEdges = degSum[0] / 2;         
                int expectedEdges = k * (k - 1) / 2;    

                if (actualEdges == expectedEdges) {
                    goodComponents++;
                }
            }
        }

        return goodComponents;
    }
}

// gfg 