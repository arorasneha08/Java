public class FruitsIntoBasketsII {
    private void buildTree(int idx, int low, int high, int[] arr, int[] seg) {
        if (low == high) {
            seg[idx] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        buildTree(2 * idx + 1, low, mid, arr, seg);
        buildTree(2 * idx + 2, mid + 1, high, arr, seg);
        seg[idx] = Math.max(seg[2 * idx + 1], seg[2 * idx + 2]);
    }

    private int rangeMaxQuery(int idx, int low, int high, int l, int r, int[] seg) {
        if (high < l || r < low) return Integer.MIN_VALUE;
        if (l <= low && high <= r) return seg[idx];
        int mid = (low + high) / 2;
        return Math.max(
            rangeMaxQuery(2 * idx + 1, low, mid, l, r, seg),
            rangeMaxQuery(2 * idx + 2, mid + 1, high, l, r, seg)
        );
    }

    private void update(int idx, int low, int high, int pos, int val, int[] seg) {
        if (low == high) {
            seg[idx] = val;
            return;
        }
        int mid = (low + high) / 2;
        if (pos <= mid) update(2 * idx + 1, low, mid, pos, val, seg);
        else update(2 * idx + 2, mid + 1, high, pos, val, seg);
        seg[idx] = Math.max(seg[2 * idx + 1], seg[2 * idx + 2]);
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int[] seg = new int[4 * n];
        buildTree(0, 0, n - 1, baskets, seg);

        int unplaced = 0;

        for (int fruit : fruits) {
            if (seg[0] < fruit) {
                unplaced++;
                continue;
            }

            int low = 0, high = n - 1, ans = -1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (rangeMaxQuery(0, 0, n - 1, low, mid, seg) >= fruit) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            update(0, 0, n - 1, ans, 0, seg);
        }

        return unplaced;
    }
}
