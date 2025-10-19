import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOneDataStructure {
    class Node {
    int count;      
    Set<String> keys;   
    Node prev, next;

    Node(int count) {
        this.count = count;
        this.keys = new HashSet<>();
    }
}

class AllOne {
    private Map<String, Node> mpp; 
    private Node head, tail;   

    public AllOne() {
        mpp = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    private void insertAfter(Node prev, Node newNode) {
        newNode.next = prev.next;
        newNode.prev = prev;
        prev.next.prev = newNode;
        prev.next = newNode;
    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void inc(String key) {
        if (!mpp.containsKey(key)) {
            Node first = head.next;
            if (first == tail || first.count > 1) {
                Node newNode = new Node(1);
                insertAfter(head, newNode);
                first = newNode;
            }
            first.keys.add(key);
            mpp.put(key, first);
        } else {
            Node curr = mpp.get(key);
            Node nextNode = curr.next;
            if (nextNode == tail || nextNode.count > curr.count + 1) {
                Node newNode = new Node(curr.count + 1);
                insertAfter(curr, newNode);
                nextNode = newNode;
            }
            nextNode.keys.add(key);
            mpp.put(key, nextNode);
            curr.keys.remove(key);
            if (curr.keys.isEmpty()) remove(curr);
        }
    }

    public void dec(String key) {
        if (!mpp.containsKey(key)) return;
        Node curr = mpp.get(key);
        if (curr.count == 1) {
            mpp.remove(key);
            curr.keys.remove(key);
            if (curr.keys.isEmpty()) remove(curr);
        } else {
            Node prevNode = curr.prev;
            if (prevNode == head || prevNode.count < curr.count - 1) {
                Node newNode = new Node(curr.count - 1);
                insertAfter(curr.prev, newNode);
                prevNode = newNode;
            }
            prevNode.keys.add(key);
            mpp.put(key, prevNode);
            curr.keys.remove(key);
            if (curr.keys.isEmpty()) remove(curr);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}

}
