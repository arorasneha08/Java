public class O13_MaxMinDistCriticalPoints {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode left = head;
        ListNode midd = head.next;
        ListNode right = head.next.next;

        int first = -1;
        int last = -1;
        int idx = 2; 
        int minDist = Integer.MAX_VALUE;

        while (right != null) {
            if ((midd.val < left.val && midd.val < right.val) ||
                (midd.val > left.val && midd.val > right.val)) {

                if (first == -1) {
                    first = idx;
                } else {
                    minDist = Math.min(minDist, idx - last);
                }
                last = idx; 
            }

            left = left.next;
            midd = midd.next;
            right = right.next;
            idx++;
        }
        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        int maxDist = last - first;
        return new int[]{minDist, maxDist};
    }
}
