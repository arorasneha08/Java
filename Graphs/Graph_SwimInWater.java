package Graphs;
import java.util.PriorityQueue;

public class Graph_SwimInWater {
    public class Pair implements Comparable<Pair> {
        int row, col, val;

        Pair(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public int compareTo(Pair other) {
            return this.val - other.val;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0, grid[0][0]));

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        int res = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int val = curr.val;

            res = Math.max(res, val);

            if (row == n - 1 && col == n - 1)
                return res;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < n &&
                    !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    pq.offer(new Pair(newRow, newCol, grid[newRow][newCol]));
                }
            }
        }
        return res;
    }
}
