//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class GFG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Solution
{
    //Function to merge K sorted linked list.
    
    public Node merge(Node first, Node second){
        Node head=new Node(0);
        Node dummy=new Node(0);
        dummy.next=head;
        while(first!=null && second!=null){
            if(first.data>second.data){
                head.next=second;
                second=second.next;
                head=head.next;
            }
            else{
                head.next=first;
                first=first.next;
                head=head.next;
            }
        }
        while(first!=null){
                head.next=first;
                first=first.next;
                head=head.next;
        }
        while(second!=null){
                head.next=second;
                second=second.next;
                head=head.next;
        }
        return dummy.next.next;
    }
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
    	Node head=null;
        
         for(int i=0;i<K;i++){
             head=merge(head,arr[i]);
         }
         return head;
    }
}
