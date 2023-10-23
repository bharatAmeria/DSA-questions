// Merge two sorted linked lists from their end

public class Ques_25 {
    public static void printList(Node4 head) {
        System.out.print("\n msg: ");

        Node4 ptr = head;
        while (ptr != null) {
            System.out.printf(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println(" null ");
    }
    public static Node4 reverseMerge(Node4 a, Node4 b) {
        Node4 result = null;

        while (a != null && b != null) {
            if (a.data < b.data) {
                Node4 newNode = a;
                a = a.next;

                newNode.next = result;
                result = newNode;
            }
            else {
                Node4 newNode = b;
                b = b.next;

                newNode.next = result;
                result = newNode;
            }
        }
        while (b != null) {
            Node4 newNode = b;
            b = b.next;

            newNode.next = result;
            result = newNode;
        }
        while (a != null) {
            Node4 newNode = a;
            a = a.next;

            newNode.next = result;
            result = newNode;
        }
        return result;
    }

    public static void main(String[] args) {
        Node4 a = null, b = null;
        for (int i = 6; i > 0; i = i - 2) {
            a = new Node4(i, a);
        }

        for (int i = 9; i >= 1; i = i - 2) {
            b = new Node4(i, b);
        }
        printList(a);
        printList(b);

        Node4 head = reverseMerge(a, b);
        printList(head);
    }
}
