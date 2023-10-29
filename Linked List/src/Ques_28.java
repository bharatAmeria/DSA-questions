// check if LL is palindrome or not
class Node5 {
    int data;
    Node5 next = null;
    Node5(int data) {
        this.data = data;
    }
}
class Ques_28 {
    static class NodeWrapper {
        public Node5 node;

        NodeWrapper(Node5 node) {
            this.node = node;
        }
    }
    public static Node5 push(Node5 head, int data) {
        Node5 node = new Node5(data);
        node.next = head;
        return node;
    }
    public static boolean checkPalindrome(NodeWrapper left, Node5 right) {
        if (right == null) {
            return true;
        }
        boolean result = checkPalindrome(left, right.next) && (left.node.data == right.data);
        left.node = left.node.next;
        return result;
    }
    public static boolean checkPalin(Node5 head) {
        return checkPalindrome(new NodeWrapper(head), head);
    }

    public static void main(String[] args) {
        int[] keys = {1, 3, 5, 3, 9};

        Node5 head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = push(head, keys[i]);
        }

        if (checkPalin(head)) {
            System.out.println("The linked list is a palindrome");
        }
        else {
            System.out.println("The linked list is not a palindrome");
        }
    }
}
