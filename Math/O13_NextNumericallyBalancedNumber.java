package Math ; 

public class O13_NextNumericallyBalancedNumber {
    private static boolean isBalanced(int num) {
        int[] count = new int[10];
        char[] digits = String.valueOf(num).toCharArray();

        for (char c : digits) {
            int d = c - '0';
            count[d]++;
        }
        for (char c : digits) {
            int d = c - '0';
            if (count[d] != d) return false; 
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while (true) {
            if (isBalanced(num)) return num;
            num++;
        }
    }
}

// leetcode 2048 
