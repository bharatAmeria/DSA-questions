import java.util.HashSet;
import java.util.Set;

public class Ques_35 {
        public static void printList(Node head) {
            Node ptr = head;
            while (ptr != null) {
                System.out.println(ptr.data + " -> ");
                ptr = ptr.next;
            }
            System.out.println("null");
        }
        public static Node removeDuplicate(Node head) {
            Node previous = null;
            Node current = head;

            Set<Integer> set = new HashSet<>();

            while (current != null) {
                if (set.contains(current.data)) {
                    previous.next = current.next;
                }
                else {
                    set.add(current.data);
                    previous = current;
                }
                current= previous.next;
            }
            return head;
        }

        public static void main(String[] args) {
            int[] keys = {5,3,4,2,5,4,1,3};
            Node head = null;
            for (int i = keys.length - 1; i >0 ; i--) {
                head = new Node(keys[i], head);
            }
            removeDuplicate(head);
            printList(head);
        }
    }
