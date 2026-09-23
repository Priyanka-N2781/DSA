import java.util.*;

public class DeckOfCards {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node front = null;
    static Node rear = null;

    static void enqueue(int value) {
        Node newNode = new Node(value);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    static int dequeue() {
        int value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return value;
    }

    static boolean isEmpty() {
        return front == null;
    }

    static void display(int[] ans) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] deck = new int[n];
        for (int i = 0; i < n; i++) {
            deck[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (deck[i] > deck[j]) {
                    int temp = deck[i];
                    deck[i] = deck[j];
                    deck[j] = temp;
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            enqueue(i);
        }
        for (int i = 0; i < n; i++) {
            int index = dequeue();
            ans[index] = deck[i];
            if (!isEmpty()) {
                int nextIndex = dequeue();
                enqueue(nextIndex);
            }
        }
        display(ans);
    }
}
