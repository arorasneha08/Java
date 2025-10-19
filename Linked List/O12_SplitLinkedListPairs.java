public class O12_SplitLinkedListPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k]; 
        ListNode temp = head ;
        int count = 0 ;  
        while(temp != null){
            count ++ ;  
            temp = temp.next;
        }
        int listSize = count / k ; 
        int r = count % k ; 

        temp = head ; 
        for(int i = 0 ; i < k && temp != null ; i++){
            res[i] = temp ; 
            int partSize = listSize + (r > 0 ? 1 : 0) ; 
            if(r > 0){
                r -- ;  
            }
            for(int j = 0 ; j < partSize -1; j++){
                temp = temp.next ;
            }
            ListNode nextNode = temp.next ; 
            temp.next = null; 
            temp = nextNode ; 
        }
        return res ; 
    }
    
}