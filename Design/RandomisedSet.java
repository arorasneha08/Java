import java.util.* ; 

public class RandomisedSet {
    class RandomizedSet {
        HashMap<Integer, Integer> mpp;
        List<Integer> list;

        public RandomizedSet() {
            mpp = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (mpp.containsKey(val))
                return false;
            mpp.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!mpp.containsKey(val)) {
                return false;
            }
            int idx = mpp.get(val);
            int lastElem = list.get(list.size() - 1);

            // swap the value to be removed to the last postition and then remove -> O(1)
            // time complexity
            list.set(idx, lastElem);
            mpp.put(lastElem, idx);
            list.remove(list.size() - 1);
            mpp.remove(val);
            return true;
        }

        public int getRandom() {
            int idx = (int) (Math.random() * list.size());
            return list.get(idx);
        }
    }
}