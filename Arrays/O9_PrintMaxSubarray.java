package Arrays;

import java.util.ArrayList;

public class O9_PrintMaxSubarray {
    public ArrayList<Integer> findSubarray(int arr[]) {
        int n = arr.length;
        int ansStart = -1, ansEnd = -1;
        int start = 0;
        long sum = 0, max = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                sum = 0;
                start = i + 1;
                continue;
            }
            sum += arr[i];
            if (sum >= max) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }
        }

        if (ansStart == -1) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(-1);
            return res;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = ansStart; i <= ansEnd; i++) {
            res.add(arr[i]);
        }
        return res;
    }
    public static long maxSubarraySum(int[] arr, int n) {
        long maxi = Long.MIN_VALUE; 
        long sum = 0;

        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < n; i++) {

            if (sum == 0) start = i;

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]n");

        return maxi;
    }

    public static void main(String args[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = maxSubarraySum(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }
}
