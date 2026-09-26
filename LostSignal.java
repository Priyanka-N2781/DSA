import java.util.Scanner;
public class LostSignal {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    static Node createTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1)
            return null;
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                nodes[i] = new Node(arr[i]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (nodes[i] != null) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                if (left < arr.length)
                    nodes[i].left = nodes[left];
                if (right < arr.length)
                    nodes[i].right = nodes[right];
            }
        }
        return nodes[0];
    }

    static void printDown(Node root, int k) {
        if (root == null)
            return;
        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }
        printDown(root.left, k - 1);
        printDown(root.right, k - 1);
    }

    static int find(Node root, int target, int k) {
        if (root == null)
            return -1;
        if (root.data == target) {
            printDown(root, k);
            return 0;
        }

        int left = find(root.left, target, k);
        if (left != -1) {
            if (left + 1 == k) {
                System.out.print(root.data + " ");
            } 
            else {
                printDown(root.right, k - left - 2);
            }
            return left + 1;
        }
        int right = find(root.right, target, k);
        if (right != -1) {
            if (right + 1 == k) {
                System.out.print(root.data + " ");
            } 
            else {
                printDown(root.left, k - right - 2);
            }
            return right + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int k = sc.nextInt();
        Node root = createTree(arr);
        find(root, target, k);
    }
}
