import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

class tree{
    Node root;
    void createtree(int data){
        Node newnode=new Node(data);
        if(root==null){
            root=newnode;
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.left==null){
                curr.left=newnode;
                return;
            }else{
                q.add(curr.left);
            }
            if(curr.right==null){
                curr.right=newnode;
                return;
            }else{
                q.add(curr.right);
            }
        }
    }
    void levelorder(){
       Queue<Node> q=new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
        Node curr=q.poll();
        System.out.print(curr.data + " ");
        if(curr.left!=null){
            q.add(curr.left);
        }
        if(curr.right!=null){
            q.add(curr.right);
        }
       }
    }
}
public class Tree_levelorder {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        tree t=new tree();
        for(int i=0;i<n;i++){
            t.createtree(arr[i]);
        }
        t.levelorder();
    }
}


