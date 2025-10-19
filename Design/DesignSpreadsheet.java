import java.util.HashMap;

public class DesignSpreadsheet {
    class Spreadsheet {
        HashMap<String, Integer> mpp;
        int mat[][];

        public Spreadsheet(int rows) {
            mpp = new HashMap<>();
            mat = new int[rows][26];
        }

        public void setCell(String cell, int value) {
            mpp.put(cell, value);
            int r = Integer.parseInt(cell.substring(1)) - 1;
            int c = cell.charAt(0) - 'A';
            mat[r][c] = value;
        }

        public void resetCell(String cell) {
            int r = Integer.parseInt(cell.substring(1)) - 1;
            int c = cell.charAt(0) - 'A';
            mat[r][c] = 0;
            mpp.remove(cell);
        }

        private boolean isCellRef(String s) {
            return Character.isLetter(s.charAt(0));
        }

        public int getValue(String formula) {
            formula = formula.substring(1);
            String[] parts = formula.split("\\+");
            String op1 = parts[0];
            String op2 = parts[1];
            int val1 = isCellRef(op1) ? mpp.getOrDefault(op1, 0) : Integer.parseInt(op1);
            int val2 = isCellRef(op2) ? mpp.getOrDefault(op2, 0) : Integer.parseInt(op2);
            return val1 + val2;
        }
    }
}
