public class O5_SortLL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    private ListNode middle(ListNode head){
        ListNode slow = head; 
        ListNode fast = head; 
        while(fast.next != null && fast.next.next != null){
            slow = slow.next ; 
            fast = fast.next.next; 
        }
        return slow; 
    }
    private ListNode merge(ListNode t1 , ListNode t2){
        ListNode d = new ListNode(-1); 
        ListNode temp = d ; 
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                temp.next = t1 ; 
                t1 = t1.next ; 
            }
            else {
                temp.next = t2;
                t2  = t2.next ;   
            }
            temp = temp.next ; 
        }
        if(t1 != null){
            temp.next = t1 ; 
        }
        if(t2 != null){
            temp.next = t2; 
        }
        return d.next ; 
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head ; 
        ListNode midd = middle(head); 
        ListNode t = midd.next ; 
        midd.next = null ; 
        ListNode left  = sortList(head); 
        ListNode right = sortList(t); 
        return merge(left , right); 
    }
}
