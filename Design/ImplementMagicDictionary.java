import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementMagicDictionary {
    class MagicDictionary {
        Map<String, List<int[]>> mpp;

        public MagicDictionary() {
            mpp = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (String str : dictionary) {
                for (int i = 0; i < str.length(); i++) {
                    String key = str.substring(0, i) + str.substring(i + 1);
                    int pair[] = new int[] { i, str.charAt(i) };
                    List<int[]> list = mpp.getOrDefault(key, new ArrayList<>());
                    list.add(pair);
                    mpp.put(key, list);
                }
            }
        }

        public boolean search(String searchWord) {
            for (int i = 0; i < searchWord.length(); i++) {
                String key = searchWord.substring(0, i) + searchWord.substring(i + 1);
                if (mpp.containsKey(key)) {
                    for (int pair[] : mpp.get(key)) {
                        if (pair[0] == i && pair[1] != searchWord.charAt(i))
                            return true;
                    }
                }
            }
            return false;
        }
    }
}
