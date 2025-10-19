public class O7_RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    private ListNode findKth(ListNode head , int k){
        while(head != null && k > 0){
            head = head.next ; 
            k--; 
        }
        return head ; 
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null ; 
        if(k == 0) return head ; 
        int count = 1 ; 
        ListNode temp = head; 
        while(temp.next != null){
            temp = temp.next ;
            count ++; 
        }
        k = k % count ; 
        if(k == 0) return head; 
        ListNode kthNode = findKth(head , count - k - 1); 
        ListNode newHead = kthNode.next ; 
        kthNode.next = null; 
        temp.next = head; 
        return newHead; 
    }
}
