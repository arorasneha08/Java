
// public class O20_SplitCircularLLTwoHalves {
//     class Node {
//     int data;
//     Node next;
//     Node prev;

//     Node(int data) {
//         this.data = data;
//         this.next = null;
//         this.prev = null;
//     }
//     public Pair<Node, Node> splitList(Node head) {
//         if (head == null) {
//             return new Pair<>(null, null);
//         }
//         if (head.next == head) { 
//             return new Pair<>(head, null);
//         }

//         Node slow = head;
//         Node fast = head;

//         while (fast.next != head && fast.next.next != head) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         if (fast.next.next == head) {
//             fast = fast.next;
//         }

//         Node head1 = head;
//         Node head2 = slow.next;

//         fast.next = head2;
//         slow.next = head1;

//         return new Pair<>(head1, head2);
//     }
// }

// gfg 