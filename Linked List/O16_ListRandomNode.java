import java.util.ArrayList;
import java.util.List;

public class O16_ListRandomNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    List<Integer> list = new  ArrayList<>(); 

    public void Solution(ListNode head) {
        while(head != null){
            list.add(head.val); 
            head = head.next; 
        }
    }
    
    public int getRandom() {
        int idx = (int)(Math.random() * list.size());
        return list.get(idx); 
    }
}
