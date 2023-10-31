// Detect cycle in a linked list (floyd's cycle detection algorithm)

import java.util.HashSet;
import java.util.Set;

class Ques_31 {
    public static boolean detectCycle(Node head) {
        Node curr = head;
        Set<Node> set = new HashSet<>();

        while (curr != null) {
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] keys = {1,2,3,2,4,5};
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        head.next.next.next.next = head.next.next;

        if (detectCycle(head)) {
            System.out.println("Cycle Found");
        }
        else {
            System.out.println("No Cycle Found");
        }


        if (detectCycle_(head)) {
            System.out.println("Cycle Found");
        }
        else {
            System.out.println("No Cycle Found");
        }
    }
//    method 2: floyd's cycle detection or tortoise and the hare algo,
    public static boolean detectCycle_(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
