package Math;

public class O5_LastCellInMatrix {
    static int[] endPoints(int[][] matrix, int R, int C) {
        int dir = 0;
        int i = 0, j = 0;

        while (i >= 0 && i < R && j >= 0 && j < C) {
            if (matrix[i][j] == 1) {
                matrix[i][j] = 0;   // set to 0
                dir = (dir + 1) % 4; // turn clockwise
            }

            // move in current direction
            if (dir == 0) j++;      // right
            else if (dir == 1) i++; // down
            else if (dir == 2) j--; // left
            else i--;               // up
        }

        // step went out → undo last move
        if (dir == 0) j--;
        else if (dir == 1) i--;
        else if (dir == 2) j++;
        else i++;

        return new int[]{i, j};
    }
}
