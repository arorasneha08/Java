import java.util.ArrayDeque;
import java.util.Deque;

public class Graph_ShortestDistanceSourceToDest {
    private static class Pair {
        int row, col, dist;
        Pair(int r, int c, int d) { 
            row = r; 
            col = c; 
            dist = d; 
        }
    }

    int shortestDistance(int n, int m, int arr[][], int x, int y) {
        if (n <= 0 || m <= 0 || arr == null) return -1;
        if (x < 0 || x >= n || y < 0 || y >= m) return -1;

        if (arr[0][0] == 0 || arr[x][y] == 0) return -1;

        if (x == 0 && y == 0) return 0;

        boolean[][] visited = new boolean[n][m];
        Deque<Pair> q = new ArrayDeque<>();
        q.addLast(new Pair(0, 0, 0));
        visited[0][0] = true;

        int[] dr = {-1, 0, 1, 0}; 
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();
            int r = cur.row, c = cur.col, d = cur.dist;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (arr[nr][nc] == 0) continue;     

                if (nr == x && nc == y) return d + 1; 

                visited[nr][nc] = true;
                q.addLast(new Pair(nr, nc, d + 1));
            }
        }

        return -1; 
    }
}
