// Delete every `N` nodes in a linked list after skipping `M` nodes
class Ques_26 {
    public static void printList(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.println(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    public static Node deleteNode(Node head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null, next;
        Node curr = head;

        for (int i = 1; i <= m && curr != null; i++) {
            prev =curr;
            curr = curr.next;
        }
        for (int i = 1; i <= n && curr != null; i++) {
            next = curr.next;
            curr = next;
        }
        prev.next = curr;
        deleteNode(curr,m,n);
        return head;
    }

    public static void main(String[] args) {
        int[] keys = {1,2,3,4,5,6,7,8,9,10};
        Node head = null;
        for (int i = keys.length - 1; i >= 0 ; i--) {
            head = new Node(keys[i], head);
        }
        head = deleteNode(head, 1,3);
        printList(head);
    }
}
