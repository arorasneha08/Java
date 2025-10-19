
import java.util.*;

public class AvoidFloodInCity {

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> mpp = new HashMap<>(); // (lake , idx)
        List<Integer> list = new ArrayList<>();  // dry days 

        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                int lake = rains[i];
                ans[i] = -1; 

                if (mpp.containsKey(lake)) {
                    int lastRain = mpp.get(lake);
                    boolean dried = false;

                    for (int j = 0; j < list.size(); j++) {
                        int dryDay = list.get(j);
                        if (dryDay > lastRain) {
                            ans[dryDay] = lake; 
                            list.remove(j);
                            dried = true;
                            break;
                        }
                    }

                    if (!dried) return new int[0];
                }
                mpp.put(lake, i);
            } 
            else {
                list.add(i);
                ans[i] = 1; 
            }
        }
        return ans;
    }
}