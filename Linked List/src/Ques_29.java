// Move the last node to the front of a linked list

class Ques_29 {
    public static void printList(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.println(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    public static Node rearrange(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node ptr = head;

        while (ptr.next.next != null) {
            ptr = ptr.next;
        }
        ptr.next.next = head;
        head = ptr.next;
        ptr.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] keys = {1,2,3,4,5,6};
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new  Node(keys[i], head);
        }
        head = rearrange(head);
        printList(head);
    }
}
