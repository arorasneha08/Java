package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Unique3DigitEvenNumber {
    private void func(int[] digits, List<Integer> list, int[] visited, Set<Integer> res) {
        if (list.size() == 3) {
            int number = list.get(0) * 100 + list.get(1) * 10 + list.get(2);
            if (number % 2 == 0) {
                res.add(number);
            }
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (visited[i] == 1) continue;
            if (list.isEmpty() && digits[i] == 0) continue; 

            visited[i] = 1;
            list.add(digits[i]);

            func(digits, list, visited, res);

            list.remove(list.size() - 1);
            visited[i] = 0; 
        }
    }

    public int totalNumbers(int[] digits) {
        Set<Integer> res = new HashSet<>();
        int[] visited = new int[digits.length];
        func(digits, new ArrayList<>(), visited, res);
        return res.size();
    }
}
