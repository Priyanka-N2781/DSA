import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LL {
    Node head = null;
    Node temp = null;
    void insert(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = newnode;
            temp = newnode;
        } else {
            temp.next = newnode;
            temp = newnode;
        }
    }
    void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    void alternative(){
        Node odd=head;
        Node even=head.next;
        Node evenhead=even;
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next; 
        }
        Node prev=null;
        Node curr=evenhead;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        odd.next=prev; 
    }
}
public class Alternative_linkedlist{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LL obj = new LL();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            obj.insert(val);
        }
        obj.alternative();
        obj.display();
    }
}
