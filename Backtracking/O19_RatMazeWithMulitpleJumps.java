package Backtracking;

public class O19_RatMazeWithMulitpleJumps {
    private boolean isSafe(int i, int j, int n, int[][] mat, int[][] visited) {
        return (i >= 0 && i < n && j >= 0 && j < n && mat[i][j] != 0 && visited[i][j] == 0);
    }

    private boolean func(int i, int j, int n, int[][] mat, int[][] visited) {

        if (i == n - 1 && j == n - 1) {
            visited[i][j] = 1;
            return true;
        }

        if (isSafe(i, j, n, mat, visited)) {

            visited[i][j] = 1;
            int moves = mat[i][j];

            for (int k = 1; k <= moves; k++) {
                if (func(i, j + k, n, mat, visited))
                    return true;

                if (func(i + k, j, n, mat, visited))
                    return true;
            }

            visited[i][j] = 0;
        }

        return false;
    }

    public int[][] ShortestDistance(int[][] mat) {
        int n = mat.length;
        int[][] visited = new int[n][n];

        if (func(0, 0, n, mat, visited))
            return visited;

        return new int[][]{{-1}};
    }
}
