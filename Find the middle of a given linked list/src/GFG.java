import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution g = new Solution();
            int ans = g.getMiddle(head);
            System.out.println(ans);
            //printList(head); 
            t--;
        }
    } 
} 
   
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution
{
    public static int count(Node head){
        int n=0;
        while(head.next!=null){
            n++;
            head=head.next;
        }
        return n+1;
    }
    int getMiddle(Node head)
    {
         // Your code here.
         int n=count(head);
         //System.out.println(n);
         int ans=0;
         int value=0;
        if(n%2==0) {
             int element=(n/2)+1;
             while(element!=ans){
                 ans++;
                 value=head.data;
                 head=head.next;
             }
             return value;
         }
         else{
             int element=n/2;
            while(element!=ans){
                 ans++;
                 head=head.next;
             }
             return head.data;
         }
         
         
    }
}
