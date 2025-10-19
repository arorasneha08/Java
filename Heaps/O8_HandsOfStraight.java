import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class O8_HandsOfStraight {
    public boolean isPossibleDivide(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }
        int[] sortedKeys = new int[count.size()];
        int index = 0;
        for (int key : count.keySet()) {
            sortedKeys[index++] = key;
        }
        Arrays.sort(sortedKeys);
        for (int key : sortedKeys) {
            if (count.get(key) > 0) { 
                int startCount = count.get(key);
                for (int i = key; i < key + groupSize; i++) {
                    if (count.getOrDefault(i, 0) < startCount) {
                        return false;
                    }
                    count.put(i, count.get(i) - startCount);
                }
            }
        }
        return true;
    }
}
