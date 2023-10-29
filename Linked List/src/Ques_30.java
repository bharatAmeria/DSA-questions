// Rearrange linked list in a specific manner

class Ques_30 {
    public static void printList(Node1 head) {
        Node1 ptr = head;
        while (ptr != null) {
            System.out.println(head.data + " -> ");
        }
        System.out.println("null");
    }
    public static void rearrange(Node1 head) {
        if (head == null || head.next == null) {
            return;
        }
        Node1 dummyFirst = new Node1();
        Node1 dummySecond = new Node1();

        Node1 first = dummyFirst;
        Node1 second = dummySecond;

        Node1 curr = head;

        while (curr != null) {
            first.next = curr;
            first = first.next;

            if (curr.next != null) {
                second.next = curr.next;
                second = second.next;
                curr = curr.next;
            }
            curr = curr.next;
        }
        first.next = dummyFirst.next;
        second.next = null;
    }

    public static void main(String[] args) {
        int[] keys = {1,2,3,4,5,6};
        Node1 head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node1(keys[i], head);
        }
        rearrange(head);
        printList(head);
    }
}
