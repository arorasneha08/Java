public class O6_ReverseKthGroup {
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
            curr = agla ; 
        }
        return prev ;
    }
    private ListNode kthNode(ListNode head , int k){
        k--;
        while(head != null && k > 0){
            head = head.next ; 
            k--; 
        }
        return head; 
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head; 
        ListNode d = new  ListNode(-1);
        d.next = head ; 
        ListNode prev = d; 

        while(temp != null){
            ListNode kth = kthNode(temp , k); 
            if(kth == null) break ; 
            ListNode nextNode = kth.next ; 
            kth.next = null ; 
            ListNode rev = reverse(temp);
            
            prev.next = rev ; 
            temp.next = nextNode; 

            prev = temp ; 
            temp = nextNode; 
        }
        return d.next; 
    }
}
