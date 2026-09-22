import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front = null;
    Node rear = null;

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    int dequeue() {
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    boolean isEmpty() {
        return front == null;
    }
}

class StringNode {
    String data;
    StringNode next;

    StringNode(String data) {
        this.data = data;
        this.next = null;
    }
}

class BinaryQueue {
    StringNode front = null;
    StringNode rear = null;

    void enqueue(String data) {
        StringNode newNode = new StringNode(data);
        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    void display() {
        StringNode temp = front;

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(", ");
            }
            temp = temp.next;
        }
    }
}

class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    StackNode top = null;

    void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        int data = top.data;
        top = top.next;
        return data;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class DecimalToBinary {

    static String convertBinary(int n) {

        Stack stack = new Stack();

        while (n > 0) {
            int rem = n % 2;
            stack.push(rem);
            n = n / 2;
        }

        String binary = "";

        while (!stack.isEmpty()) {
            binary = binary + stack.pop();
        }

        return binary;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue numberQueue = new Queue();
        BinaryQueue binaryQueue = new BinaryQueue();

        for (int i = 1; i <= n; i++) {
            numberQueue.enqueue(i);
        }

        while (!numberQueue.isEmpty()) {
            int number = numberQueue.dequeue();
            binaryQueue.enqueue(convertBinary(number));
        }

        binaryQueue.display();
    }
}
