import java.util.*;

class Node {
    String data;
    Node next;
    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueLinkedList {

    static Node front = null;
    static Node rear = null;
    static void enqueue(String name) {
        Node newNode = new Node(name);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    static void dequeue() {
        if (front == null) {
            System.out.println("Served Customer: Queue is empty. No customer to serve.");
            return;
        }
        System.out.println("Served Customer: " + front.data);
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    static void display() {

        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Current Queue: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            if (input.startsWith("ENQUEUE")) {
                String name = input.substring(8).trim();
                enqueue(name);
            }else if (input.equals("DEQUEUE")) {
                dequeue();
            }else if (input.equals("DISPLAY")) {
                display();
            }
        }
    }
}
