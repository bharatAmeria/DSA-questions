// Queue Implementation using a Linked List
public class Ques_34 {
    public static void main(String[] args) {
        Queue q = new Queue();
        Queue.enqueue(1);
        Queue.enqueue(2);
        Queue.enqueue(3);
        Queue.enqueue(4);

        System.out.printf("The front element is %d\n", Queue.peek());

        Queue.dequeue();
        Queue.dequeue();
        Queue.dequeue();
        Queue.dequeue();

        if (Queue.isEmpty()) {
            System.out.println("The queue is empty");
        }
        else {
            System.out.println("The queue is not empty");
        }
    }
}

class Queue{
    private static Node rear = null, front = null;
    private static int count = 0;

    public static int dequeue() {
        if(front == null) {
            System.out.println("\n Queue Underflow");
            System.out.println(-1);
        }
        Node temp = front;
        System.out.printf("Removing %d\n", temp.data);
        front = front.next;
        if (front == null) {
            rear = null;
        }
        count -= 1;
        return temp.data;
    }
    public static void enqueue(int item) {
        Node node = new Node(item);
        System.out.printf("Inserting %d\n", item);

        if (front == null) {
            front = null;
            rear = node;
        }
        else {
            rear.next = node;
            rear = node;
        }
        count += 1;
    }
    public static int peek() {
        if (front == null) {
            System.exit(-1);
        }
        return front.data;
    }
    public static boolean isEmpty() {
        return rear == null && front == null;
    }
    private static int size() {
        return count;
    }
}