import java.util.*;

class InsertionDeletionByPosition {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    static void insert(int pos, int value) {
        Node newNode = new Node(value);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode; 
    }

    static void delete(int pos) {
        if (pos == 0) {
            head = head.next;
            return;
        }
        Node temp = head
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insert(i, sc.nextInt());
        }
        int insertPos = sc.nextInt();
        int value = sc.nextInt();
        insert(insertPos, value);
        int deletePos = sc.nextInt();
        delete(deletePos);
        display();
    }
}
