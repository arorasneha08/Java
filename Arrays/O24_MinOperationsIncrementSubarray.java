package Arrays;

public class O24_MinOperationsIncrementSubarray {
    public int minNumberOperations(int[] arr) {
        int n = arr.length;
        int op = arr[0]; 

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                op += arr[i] - arr[i - 1];
            }
        }
        return op;
    }
}

// leetcode 1526 