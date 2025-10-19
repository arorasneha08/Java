// public class O9_InsertionSortLL {
//     public class ListNode {
//         int val;
//         ListNode next;
//         ListNode() {}
//         ListNode(int val) { this.val = val; }
//         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     }
//     public class Node {
//         int data;
//         Node next;
//         Node() {}
//         Node(int data) { this.data = data; }
//     }
//     private void swap(ListNode a , ListNode  b){
//         int temp = a.val; 
//         a.val = b.val ;
//         b.val = temp; 
//     }
//     public ListNode insertionSortList(ListNode head) {
//         ListNode temp = head ;
//         ListNode curr = head ;
//         while(temp != null){
//             while(curr != null){
//                 if(curr.val > temp.val){
//                     swap(curr, temp); 
//                 }
//                 curr = curr.next; 
//             }
//             curr = head;
//             temp = temp.next; 
//         }
//         return head; 
//     }

//     public static Node insertionSort(Node head) {
//         if(head == null || head.next == null) return head; 
//         Node d = new Node(0); 
//         Node curr = head ;
        
//         while(curr != null){
//             Node prev = d ; 
//             Node nextNode = curr.next ;
            
//             while(prev.next != null && prev.next.data < curr.data){
//                 prev = prev.next ; 
//             }
//             curr.next = prev.next ;
//             prev.next = curr; 
//             curr = nextNode ; 
//         }
//         return d.next ; 
//     }
// }
