import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Binary_tree {
    Node root = null;

    public void create(int[] arr) {
        Queue<Node> q = new LinkedList<>();
        if (arr.length == 0) {
            return;
        }
        if (root == null) {
            root = new Node(arr[0]);
            q.add(root);
        }
        int i = 1;
        while (i < arr.length) {
            Node cur = q.poll();
            if (arr[i] != -1) {
                cur.left = new Node(arr[i]);
                q.add(cur.left);
            }
            i++;
            if (i >= arr.length) {
                break;
            }
            if (arr[i] != -1) {
                cur.right = new Node(arr[i]);
                q.add(cur.right);
            }
            i++;
        }
    }

    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        System.out.println();
    }

    public Node findTarget(Node root, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            return root;
        }
        Node left = findTarget(root.left, target);
        if (left != null) {
            return left;
        }
        return findTarget(root.right, target);
    }

    public void parents(Node root, Node parent, HashMap<Node, Node> map) {
        if (root == null) {
            return;
        }
        map.put(root, parent);
        parents(root.left, root, map);
        parents(root.right, root, map);
    }

    public void findKthNode(Node root, int target, int k) {
        Node tar = findTarget(root, target);
        if (tar == null) {
            System.out.println("Target not found");
            return;
        }
        HashMap<Node, Node> map = new HashMap<>();
        parents(root, null, map);
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> vis = new HashSet<>();
        q.add(tar);
        vis.add(tar);
        int dis = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            if (dis == k) {
                while (!q.isEmpty()) {
                    System.out.print(q.poll().data + " ");
                }
                System.out.println();
                return;
            }
            for (int i = 0; i < n; i++) {
                Node cur = q.poll();
                if (cur.left != null && !vis.contains(cur.left)) {
                    q.add(cur.left);
                    vis.add(cur.left);
                }
                if (cur.right != null && !vis.contains(cur.right)) {
                    q.add(cur.right);
                    vis.add(cur.right);
                }
                Node parent = map.get(cur);
                if (parent != null && !vis.contains(parent)) {
                    q.add(parent);
                    vis.add(parent);
                }
            }
            dis++;
        }
        System.out.println("No nodes found at distance " + k);
    }
}

public class BinaryTreeKthNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Binary_tree ob = new Binary_tree();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int k = sc.nextInt();
        ob.create(arr);
        ob.levelOrder();
        ob.findKthNode(ob.root, target, k);
    }
}
