// Sort linked list containing 0’s, 1’s, and 2’s in a single traversal

public class Ques_32 {
    public static void printList(Node1 head) {
        Node1 ptr = head;
        while (ptr != null) {
            System.out.println(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    public static Node1 sortList(Node1 head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node1 first = new Node1(), second = new Node1(), third = new Node1();
        Node1 zero = first, one = second, two = third;

        Node1 curr = head;
        while (curr != null) {

            if (curr.data == 0)
            {
                zero.next = curr;
                zero = zero.next;
            }
            else if (curr.data == 1)
            {
                one.next = curr;
                one = one.next;
            }
            else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        zero.next = (second.next != null) ? (second.next): (third.next);
        one.next = third.next;
        two.next = null;
        return first.next;
    }

    public static void main(String[] args) {
        int[] keys = {1,2,0,0,1,2,1,2,1};
        Node1 head = null;
        for (int i = keys.length - 1; i >= 0 ; i--) {
            head = new Node1(keys[i], head);
        }
        head = sortList(head);
        printList(head);
    }
}
