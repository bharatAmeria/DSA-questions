// Sort linked list containing 0’s, 1’s, and 2’s in a single traversal
class Node0{
    int data;
    Node0 next;
    Node0(int data, Node0 next) {
        this.data = data;
        this.next = next;
    }

    Node0() {}
}
public class Ques_32 {
    public static void printList(Node0 head) {
        Node0 ptr = head;
        while (ptr != null) {
            System.out.println(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    public static Node0 sortList(Node0 head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node0 first = new Node0(), second = new Node0(), third = new Node0();
        Node0 zero = first, one = second, two = third;

        Node0 curr = head;
        while (curr != null) {

            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        zero.next = (second.next != null) ? (second.next) : (third.next);
        one.next = third.next;
        two.next = null;
        return first.next;
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 0, 0, 1, 2, 1, 2, 1};
        Node0 head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node0(keys[i], head);
        }
        head = sortList(head);
        printList(head);
    }
}