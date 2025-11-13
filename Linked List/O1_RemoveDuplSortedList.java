public class O1_RemoveDuplSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head ; 
        ListNode temp = head;  
        while(temp != null && temp.next != null){
            ListNode nextNode = temp.next ;
            while(nextNode != null && temp.val == nextNode.val){
                nextNode = nextNode.next ; 
            }
            if(nextNode != null){
                temp.next = nextNode ; 
            }
            else{
                temp.next = null; 
            }
            temp = temp.next ; 
        }
        return head ; 
    }
    public ListNode deleteDuplicates2(ListNode head) {
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

// leetcode 82 