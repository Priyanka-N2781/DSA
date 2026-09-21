import java.util.*;

class BracketNode {
    char data;
    BracketNode next;

    BracketNode(char data) {
        this.data = data;
        this.next = null;
    }
}

public class BracketRemoval {

    static BracketNode top = null;

    static void push(char ch) {
        BracketNode newNode = new BracketNode(ch);
        newNode.next = top;
        top = newNode;
    }

    static char pop() {
        char ch = top.data;
        top = top.next;
        return ch;
    }

    static boolean match(char open, char close) {

        if (open == '(' && close == ')')
            return true;

        if (open == '{' && close == '}')
            return true;

        if (open == '[' && close == ']')
            return true;

        return false;
    }

    static int findRemovals(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                push(ch);
            }
            else {
                if (top == null) {
                    count++;
                }
                else if (match(top.data, ch)) {
                    pop();
                }
                else {
                    count++;
                }
            }
        }

        while (top != null) {
            count++;
            pop();
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(findRemovals(s));
    }
}
