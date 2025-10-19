public class O14_RemoveDuplicateElements {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head ; 
        ListNode temp = head ; 
        ListNode d = new ListNode(-1); 
        d.next = head ; 
        ListNode prev = d ; 
        while(temp != null){
            if(temp.next != null && temp.val == temp.next.val){
                while(temp.next != null && temp.val == temp.next.val){
                    temp = temp.next ; 
                }
                prev.next = temp.next; 
            }
            else{
                prev = prev.next ; 
            }
            temp = temp.next ;
        }
        return d.next ; 
    }
}
