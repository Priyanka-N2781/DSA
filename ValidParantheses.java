import java.util.*;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class ValidParantheses {

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

    static boolean isValid(String s) {

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                push(ch);
            }
            else {
                if (top == null) {
                    return false;
                }

                char x = pop();

                if (ch == ')' && x != '(') {
                    return false;
                }

                if (ch == '}' && x != '{') {
                    return false;
                }

                if (ch == ']' && x != '[') {
                    return false;
                }
            }
        }

        return top == null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        if (isValid(s)) {
            System.out.println("Valid");
        }
        else {
            System.out.println("Invalid");
        }
    }
}
