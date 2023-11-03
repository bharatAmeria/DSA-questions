 class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

     public Node(int item) {

     }

     public void print() {
        Node ptr = this;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
 }

 class main1 {
    public static Node reverseInGroups(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node current = head;
        Node prev = null;
        int count= 0;

        while (current != null && count++ < k) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = reverseInGroups(current, k);
        return prev;
    }

     public static void main(String[] args) {
         int[] keys = {1,2,3,4,5,6,7,8};
         Node head = null;
         for (int i = keys.length - 1; i >= 0; i--) {
             head = new Node(keys[i], head);
         }

         head = reverseInGroups(head, 3);
         head.print();
     }
 }