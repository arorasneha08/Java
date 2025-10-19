public class O15_SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head ; 
        ListNode temp = head ; 
        ListNode d = new ListNode(-1); 
        ListNode prev = d ; 

        while(temp != null && temp.next != null){
            ListNode first = temp.next ; 
            ListNode second = temp.next.next; 
            first.next = temp ; 
            temp.next = second ; 
            prev.next = first ; 

            prev = temp; 
            temp = second ; 
        }
        return d.next ; 
    }
}
