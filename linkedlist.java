
import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data= data;
    }
}

public class linkedlist {

    static Node insert(Node head,int data){
        Node newnode = new Node(data);
        if(head == null){
            head = newnode;
            return head;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;

        }
        temp.next=newnode;
        newnode.prev = temp;
        return head;
    }

    static void printnext(Node head){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }

    }

    static void printprev(Node head){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.prev;
        }
    }


  


    static void createCycle(Node head) {
        if (head == null || head.next == null) return;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Make the last node point to the second node
        temp.next = head.next;
    }


      static boolean cycleloop(Node head){
        Node slow = head;
        Node fast = head;
        // Node temp = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        
        return false;
    }


    static int middleelement(Node head){

        if(head == null){
            return  -1;
        }
        Node fast = head;
        Node slow = head;
        // int temp = 0;

        // for 1 2 3 4 5 output is 3 and 1 2 3 4 5 6 output is 4

        // while(fast!=null && fast.next!=null){
        //     slow = slow.next;
        //     fast = fast.next.next;
        //     // temp = slow.data;
        // }

    // for 1 2 3 4 5 output is 3 and 1 2 3 4 5 6 output is 3

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            // temp = slow.data;
        }
        return slow.data;
    }

    static void findelement(Node head, int num){
        Node slow = head;
        Node fast = head;
        for(int i=0;i<num;i++){
            if(slow==null){
                System.out.println("less number then k ");
            }
            slow = slow.next;
        }

        while(slow!=null){
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(fast.data+" et the end side");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            head = insert(head,val);
        }
        System.out.println();
        printnext(head);
        // System.out.println();
        // printprev(head);
        // System.out.println();
        // if(cycleloop(head)){
        //     System.out.println("Cycle detection");
        // }else{
        //     System.out.println("Not any cycle");
        // }
        System.out.println();
        int mid = middleelement(head);
        System.out.println(mid);

        int num = sc.nextInt();
        findelement(head,num);


        // to do questions 
        
        // print kth  element for starting 
        // reverselinkedlist(head);
        // checkploindrome(head);


    }
}



