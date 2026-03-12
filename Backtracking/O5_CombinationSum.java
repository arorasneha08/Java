package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O5_CombinationSum {
    private void func(int index, int target, int arr[], List<Integer> list, List<List<Integer>> res, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index >= arr.length)
            return;
        if (sum > target)
            return;

        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            sum += arr[i];
            func(i, target, arr, list, res, sum);
            list.remove(list.size() - 1);
            sum -= arr[i];
        }
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        func(0, target, arr, list, res, 0);
        return res;
    }

    class Solution {
        private static void func(int idx, int sum, int arr[], int target,
                ArrayList<ArrayList<Integer>> res,
                ArrayList<Integer> list) {

            if (sum == target) {
                res.add(new ArrayList<>(list));
                return;
            }

            if (sum > target)
                return;

            for (int i = idx; i < arr.length; i++) {

                list.add(arr[i]);

                func(i, sum + arr[i], arr, target, res, list);

                list.remove(list.size() - 1);
            }
        }

        public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {
            Arrays.sort(arr);
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            func(0, 0, arr, target, res, list);
            return res;
        }
    }
}
