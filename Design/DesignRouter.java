import java.util.*;

public class DesignRouter {

    public class Pair {
        int source;
        int dest;
        int time;

        Pair(int source, int dest, int time) {
            this.source = source;
            this.dest = dest;
            this.time = time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, dest, time);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Pair))
                return false;
            Pair p = (Pair) o;
            return p.source == source && p.dest == dest && p.time == time;
        }
    }

    class Router {
        HashSet<Pair> set; // check for duplicate packets
        Deque<Pair> q; // FIFO queue
        int capacity;
        HashMap<Integer, List<Integer>> mpp; // destination -> sorted timestamps

        public Router(int memoryLimit) {
            set = new HashSet<>();
            q = new ArrayDeque<>();
            capacity = memoryLimit;
            mpp = new HashMap<>();
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            Pair p = new Pair(source, destination, timestamp);
            if (set.contains(p))
                return false;

            if (q.size() >= capacity) {
                Pair old = q.pollFirst();
                set.remove(old);
                List<Integer> list = mpp.get(old.dest);
                if (list != null) {
                    removeFromList(list, old.time);
                }
            }

            q.offerLast(p);
            set.add(p);

            mpp.putIfAbsent(destination, new ArrayList<>());
            insertSorted(mpp.get(destination), timestamp);

            return true;
        }

        public int[] forwardPacket() {
            if (q.isEmpty())
                return new int[] {};
            Pair curr = q.pollFirst();
            set.remove(curr);

            List<Integer> list = mpp.get(curr.dest);
            if (list != null) {
                removeFromList(list, curr.time);
            }

            return new int[] { curr.source, curr.dest, curr.time };
        }

        public int getCount(int destination, int startTime, int endTime) {
            List<Integer> list = mpp.get(destination);
            if (list == null || list.isEmpty())
                return 0;

            int left = lowerBound(list, startTime); // first index >= startTime
            int right = upperBound(list, endTime); // first index > endTime
            return Math.max(0, right - left);
        }

        // --- helper methods (manual binary search) ---

        private void insertSorted(List<Integer> list, int val) {
            int pos = lowerBound(list, val);
            list.add(pos, val); // insert at correct position
        }

        private void removeFromList(List<Integer> list, int val) {
            int pos = lowerBound(list, val);
            if (pos < list.size() && list.get(pos) == val) {
                list.remove(pos);
            }
        }

        // first index with value >= target
        private int lowerBound(List<Integer> list, int target) {
            int l = 0, r = list.size();
            while (l < r) {
                int m = (l + r) / 2;
                if (list.get(m) >= target)
                    r = m;
                else
                    l = m + 1;
            }
            return l;
        }

        // first index with value > target
        private int upperBound(List<Integer> list, int target) {
            int l = 0, r = list.size();
            while (l < r) {
                int m = (l + r) / 2;
                if (list.get(m) > target)
                    r = m;
                else
                    l = m + 1;
            }
            return l;
        }
    }

}
