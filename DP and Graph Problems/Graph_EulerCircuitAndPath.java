import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_EulerCircuitAndPath {
    private void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nxt : adj.get(curr)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.offer(nxt);
                }
            }
        }
    }
    public int isEulerCircuit(int V, ArrayList<ArrayList<Integer>> adj) {
        int start = -1;
        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() > 0) {
                start = i;
                break;
            }
        }
        if (start == -1) return 2;

        boolean[] visited = new boolean[V];
        bfs(start, adj, visited);

        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() > 0 && !visited[i]) {
                return 0; 
            }
        }
        int odd = 0;
        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() % 2 != 0) odd++;
        }

        if (odd == 0) return 2; // Euler circuit
        if (odd == 2) return 1; // Euler path
        return 0; // Neither
    }
}
