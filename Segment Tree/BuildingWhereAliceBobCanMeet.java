public class BuildingWhereAliceBobCanMeet {
    private void buildTree(int idx, int low, int high, int[] arr, int[] st) {
        if (low == high) {
            st[idx] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        buildTree(2 * idx + 1, low, mid, arr, st);
        buildTree(2 * idx + 2, mid + 1, high, arr, st);
        st[idx] = Math.max(st[2 * idx + 1], st[2 * idx + 2]);
    }

    private int[] constructTree(int[] arr) {
        int n = arr.length;
        int[] st = new int[4 * n];
        buildTree(0, 0, n - 1, arr, st);
        return st;
    }

    private int rangeMaxQuery(int idx, int low, int high, int l, int r, int[] st) {
        if (r < low || high < l) return Integer.MIN_VALUE;
        if (l <= low && high <= r) return st[idx];
        int mid = (low + high) / 2;
        return Math.max(
            rangeMaxQuery(2 * idx + 1, low, mid, l, r, st),
            rangeMaxQuery(2 * idx + 2, mid + 1, high, l, r, st)
        );
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] st = constructTree(heights);
        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int a = queries[q][0];
            int b = queries[q][1];

            int minIdx = Math.min(a, b);
            int maxIdx = Math.max(a, b);

            // Case 1 - both of them are in the same building
            if (minIdx == maxIdx) {
                ans[q] = minIdx;
                continue;
            }

            // Case 2 - if the height of the second building is larger , so the person in the first building can easily enter the 2nd one 
            if (heights[maxIdx] > heights[minIdx]) {
                ans[q] = maxIdx;
                continue;
            }

            // Case 3: Binary search + RMQ - to check in the further part of the array element greater than the maxIdx
            int need = Math.max(heights[minIdx], heights[maxIdx]);
            int low = maxIdx + 1, high = n - 1;
            int res = -1;

            while (low <= high) {
                int mid = (low + high) / 2;
                int maxVal = rangeMaxQuery(0, 0, n - 1, low, mid, st);

                if (maxVal > need) {
                    res = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            ans[q] = res;
        }
        return ans;
    }
}
