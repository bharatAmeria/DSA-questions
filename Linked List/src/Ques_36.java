public class Ques_36 {
    public static void printList(Node2 head) {
        Node2 ptr = head;
        while (ptr != null) {
            System.out.println(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
    public static Node2 rearrange(Node2 head) {
        if (head == null) {
            return null;
        }
        Node2 prev = head;
        Node2 curr = head.next;

        while (curr != null) {
            if (prev.data > curr.data)
            {
                int temp = prev.data;
                prev.data = curr.data;
                curr.data = temp;
            }

            if (curr.next != null && curr.next.data > curr.data) {
                int temp = curr.next.data;
                curr.next.data = curr.data;
                curr.data = temp;
            }
            prev = curr.next;
            if (curr.next == null) {
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] keys = {1,2,3,4,5,6,7,8,6};
        Node2 head = null;
        for (int i = keys.length - 1; i >=0 ; i--) {
            head = new Node2(keys[i], head);
        }
        head = rearrange(head);
        printList(head);
    }
}
