public class O3_StartLoopInLL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head; 
        while(fast != null && fast.next != null){
            slow = slow.next ; 
            fast = fast.next.next; 
            if(slow == fast){
                break ;
            }
        }
        if(fast == null ||  fast.next == null) return null;
        ListNode temp = head; 

        while(temp != slow){
            slow = slow.next ; 
            temp = temp.next ; 
        }
        return slow; 
    }
}
