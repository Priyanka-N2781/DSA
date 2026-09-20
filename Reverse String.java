import java.util.*;

class Main {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;

    static void push(char ch) {
        Node newNode = new Node(ch);
        newNode.next = top;
        top = newNode;
    }

    static char pop() {
        char ch = top.data;
        top = top.next;
        return ch;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            push(str.charAt(i));
        }

        while (top != null) {
            System.out.print(pop());
        }
    }
}
