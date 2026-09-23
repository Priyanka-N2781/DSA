import java.util.*;

public class AncientScientificCalculator {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top1 = null;
    static Node top2 = null;

    static void push1(char value) {
        Node newNode = new Node(value);
        newNode.next = top1;
        top1 = newNode;
    }

    static char pop1() {
        char value = top1.data;
        top1 = top1.next;
        return value;
    }

    static boolean isEmpty1() {
        return top1 == null;
    }

    static void push2(char value) {
        Node newNode = new Node(value);
        newNode.next = top2;
        top2 = newNode;
    }

    static char pop2() {
        char value = top2.data;
        top2 = top2.next;
        return value;
    }

    static char peek2() {
        return top2.data;
    }

    static boolean isEmpty2() {
        return top2 == null;
    }

    static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().replaceAll("\\s+", "");

        boolean expectOperand = true;
        boolean valid = true;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (isOperand(ch)) {

                if (!expectOperand) {
                    valid = false;
                    break;
                }

                expectOperand = false;
            }

            else if (ch == '(') {

                if (!expectOperand) {
                    valid = false;
                    break;
                }

                push1('(');
                push2('0');

                expectOperand = true;
            }

            else if (isOperator(ch)) {

                if (expectOperand) {
                    valid = false;
                    break;
                }

                if (!isEmpty2()) {
                    pop2();
                    push2('1');
                }

                expectOperand = true;
            }

            else if (ch == ')') {

                if (expectOperand || isEmpty1()) {
                    valid = false;
                    break;
                }

                char hasOperator = pop2();

                if (hasOperator == '0') {
                    valid = false;
                    break;
                }

                pop1();

                expectOperand = false;
            }

            else {
                valid = false;
                break;
            }
        }

        if (expectOperand || !isEmpty1()) {
            valid = false;
        }

        if (valid) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
