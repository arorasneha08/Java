public class O17_CopyListRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null ;
        Node temp = head; 
        while(temp != null){
            Node node = new Node(temp.val); 
            node.next = temp.next ; 
            temp.next = node; 
            temp = node.next; 
        }
        temp = head; 
        while(temp != null){
            if(temp.random == null){
                temp.next.random = null; 
            }
            else{
                temp.next.random = temp.random.next ; 
            }
            temp = temp.next.next ; 
        }
        temp = head;
        Node d = new Node(-1); 
        Node t = d;   
        while(temp != null){
            t.next = temp.next;  
            t = t.next ; 
            temp.next = temp.next.next; 
            temp = temp.next ; 
        }
        return d.next; 
    }
}
