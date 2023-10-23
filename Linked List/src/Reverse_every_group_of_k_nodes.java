 class Node4 {
    int data;
    Node4 next;

    Node4(int data, Node4 next) {
        this.data = data;
        this.next = next;
    }
    public void print() {
        Node4 ptr = this;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
 }

 class main1 {
    public static Node4 reverseInGroups(Node4 head, int k) {
        if (head == null) {
            return null;
        }
        Node4 current = head;
        Node4 prev = null;
        int count= 0;

        while (current != null && count++ < k) {
            Node4 next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = reverseInGroups(current, k);
        return prev;
    }

     public static void main(String[] args) {
         int[] keys = {1,2,3,4,5,6,7,8};
         Node4 head = null;
         for (int i = keys.length - 1; i >= 0; i--) {
             head = new Node4(keys[i], head);
         }

         head = reverseInGroups(head, 3);
         head.print();
     }
 }