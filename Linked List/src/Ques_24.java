// Merge alternate nodes of two linked lists into the first list

class Ques_24 {
    public static void printList(Node1 head) {
        System.out.print("\n msg ");

        Node1 ptr = head;
        while (ptr != null) {
            System.out.printf(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.print("null");
    }

    public static Node1[] merge(Node1 a, Node1 b) {
        Node1 dummy = new Node1();
        Node1 tail = dummy;

        while (true) {
            if (a == null) {
                tail.next = null;
                break;
            }
            else if (b == null) {
                tail.next = a;
                break;
            }
            else {
                tail.next = a;
                tail = a;
                a = a.next;

                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        a = dummy.next;
        return new Node1[] {a,b};
    }

    public static void main(String[] args) {
        Node1 a = null, b = null;
        for (int i = 3; i >= 0 ; i--) {
            a = new Node1(i, a);
        }
        for (int i = 10; i >= 4; i--) {
            b = new Node1(i, b);
        }
        printList(a);
        printList(b);

        Node1[] arr = merge(a, b);
        a = arr[0];
        b = arr[1];

        System.out.println("\n After Merge: \n");

        printList(a);
        printList(b);
    }
}
