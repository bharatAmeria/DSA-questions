class Node3 {
    int data;
    Node3 next;

    Node3(int data) {
        this.data = data;
    }
}

class main {
    public static void printList (Node3 head) {
        Node3 ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data + " -> ");
            ptr =ptr.next;
        }
        System.out.println("null");
    }
    public static Node3 push(Node3 head, int data) {
        Node3 node = new Node3(data);
        node.next = head;
        return node;
    }

    public static Node3 reverse(Node3 head, Node3 headRef) {
        Node3 first, rest;

        if (head == null) {
            return headRef;
        }
        first = head;
        rest = first.next;

        if (rest == null) {
            headRef = first;
            return headRef;
        }
        headRef = reverse(rest, headRef);

        rest.next = first;
        first.next = null;

        return headRef;
    }
    public static Node3 reverse(Node3 head) {
        return reverse(head, head);
    }

    public static void main(String[] args) {
        int[] keys = {1,2,3,4,5,6};
        Node3 head = null;
        for (int i = keys.length - 1; i >=0; i--) {
            head = push(head, keys[i]);
        }

        head = reverse(head);
        printList(head);
    }

}
