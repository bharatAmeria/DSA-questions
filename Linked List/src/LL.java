import org.w3c.dom.Node;

public class LL {
    public static Node1 newNode( int key) {
        Node1 node = new Node1(key, null);
        return node;
    }
    public static void printList(Node1 head) {
        Node1 ptr = head;
        while (ptr != null) {
            System.out.println(ptr.data + "->");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    public static Node1 appendNode(Node1 head, int key) {
        Node1 current = head;
        Node1 node = newNode(key);

        if (current == null) {
            head = node;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] keys = {1,2,3,4};
        Node1 head = null;
        for (int key: keys) {
            head = appendNode(head, key);
        }
        printList(head);
    }
//    method 2 -> by making a dummy node
    public static Node1 push(Node1 head, int data) {
        Node1 newNode = new Node1();
        newNode.data = data;

        newNode.next = head;

        return newNode;
    }
    public static Node1 constructList(int[] keys) {
        Node1 dummy = new Node1();
        Node1 tail = dummy;

        for (int key: keys)
        {
            tail.next = push(tail.next, key);
            tail = tail.next;
        }
        return (dummy.next);
    }

}
class Node1{
    int data;
    Node1 next;
     Node1(int data, Node1 next) {
         this.data = data;
         this.next = next;
     }

    public Node1() {
     }
}
