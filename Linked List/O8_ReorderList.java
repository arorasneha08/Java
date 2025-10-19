public class O8_ReorderList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    private ListNode reverse(ListNode head){
        ListNode curr = head ; 
        ListNode prev = null ;
        ListNode agla = null ;
        while(curr != null){
            agla = curr.next ; 
            curr.next = prev; 
            prev = curr;
            curr = agla; 
        }
        return prev ; 
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return; 
        ListNode slow = head; 
        ListNode fast = head ;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next ; 
            fast = fast.next.next; 
        }
        ListNode nextNode = slow.next; 
        slow.next = null ; 
        ListNode rev = reverse(nextNode); 
        ListNode t1 = head ; 
        ListNode t2 = rev; 
        ListNode temp = head; 
        while(t1 != null && t2 != null){
            ListNode first = t1.next ; 
            ListNode second = t2.next; 
            t1.next = t2 ; 
            t2.next = first ; 
            t1 = first ; 
            t2 = second; 
        }
    }
}
