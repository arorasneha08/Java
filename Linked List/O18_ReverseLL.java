public class O18_ReverseLL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head; 
        ListNode prev = null ;
        ListNode newHead = reverseList(head.next);
        head.next.next = head ;
        head.next = prev; 
        return newHead ; 
    }
}
