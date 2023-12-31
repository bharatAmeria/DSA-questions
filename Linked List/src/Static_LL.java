public class Static_LL {
    public static void printList(Node head) {
        Node ptr = head;
        while ( ptr != null) {
            System.out.println(ptr.data + "-> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node e = new Node(5, null);     // last node
        Node d = new Node(4, e);
        Node c = new Node(3, d);
        Node b = new Node(2, c);
        Node a = new Node(1, b);

        Node head = a;
        printList(head);
    }
}
