package Arrays;

import java.util.HashMap;
import java.util.Map;

public class O23_SplitArraySubsequences {
    public boolean isPossible(int[] arr, int k) {
        if (k <= 1) return true; 
        int n = arr.length;
        if (n < k) return false;

        Map<Integer, Integer> count = new HashMap<>();
        for (int x : arr) count.put(x, count.getOrDefault(x, 0) + 1);

        Map<Integer, Integer> tails = new HashMap<>(); 

        for (int num : arr) {
            if (count.getOrDefault(num, 0) == 0) continue;

            if (tails.getOrDefault(num - 1, 0) > 0) {
                tails.put(num - 1, tails.get(num - 1) - 1);
                tails.put(num, tails.getOrDefault(num, 0) + 1);
                count.put(num, count.get(num) - 1);
            } else {
                boolean canStart = true;
                for (int i = 0; i < k; i++) {
                    int cur = num + i;
                    int c = count.getOrDefault(cur, 0);
                    if (c <= 0) { 
                        canStart = false;
                        break;
                    }
                    count.put(cur, c - 1);
                }
                if (!canStart) return false;
                int end = num + k - 1;
                tails.put(end, tails.getOrDefault(end, 0) + 1);
            }
        }

        return true;
    }


    public boolean isPossibleLeetcode(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> tail = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (count.get(num) == 0) continue;
            count.put(num, count.get(num) - 1);

            if (tail.getOrDefault(num - 1, 0) > 0) {
                tail.put(num - 1, tail.get(num - 1) - 1);
                tail.put(num, tail.getOrDefault(num, 0) + 1);
            }
            else if (count.getOrDefault(num + 1, 0) > 0 && count.getOrDefault(num + 2, 0) > 0) {
                count.put(num + 1, count.get(num + 1) - 1);
                count.put(num + 2, count.get(num + 2) - 1);
                tail.put(num + 2, tail.getOrDefault(num + 2, 0) + 1);
            }
            else {
                return false;
            }
        }

        return true;
    }
}
