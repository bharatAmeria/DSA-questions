import java.util.HashSet;
import java.util.Set;

class Node9
{
    int data;
    Node9 next;

    Node9(int data, Node9 next)
    {
        this.data = data;
        this.next = next;
    }
}

public class Ques_35 {
        public static void printList(Node9 head) {
            Node9 ptr = head;
            while (ptr != null) {
                System.out.println(ptr.data + " -> ");
                ptr = ptr.next;
            }
            System.out.println("null");
        }
        public static void removeDuplicate(Node9 head) {
            Node9 previous = null;
            Node9 current = head;

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
        }

        public static void main(String[] args) {
            int[] keys = {5,3,4,2,5,4,1,3};
            Node9 head = null;
            for (int i = keys.length - 1; i >0 ; i--) {
                head = new Node9(keys[i], head);
            }
            removeDuplicate(head);
            printList(head);
        }
    }
