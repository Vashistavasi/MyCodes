//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GFG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
	public static Node reverse(Node n) {
		Node curr=n,prev=null,next=null;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}
	public static int length(Node n) {
		int count=0;
		while(n!=null) {
			count++;
			n=n.next;
		}
		return count;
	}
	
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
    	Node reverse1=reverse(first);
    	Node reverse2=reverse(second);
    	int size1=length(first);
    	 int sum=reverse1.data+reverse2.data;
    	  int carry=sum/10;
    	  Node head  = new Node(sum%10);
          Node tail = head;
           reverse1=reverse1.next;
              reverse2=reverse2.next;
          while(reverse1!=null&&reverse2!=null)
          {
             
              sum=reverse1.data+reverse2.data+carry;
              carry=sum/10;
              tail.next = new Node(sum%10);
              tail = tail.next;
               reverse1=reverse1.next;
              reverse2=reverse2.next;
          }
    	if(reverse1==null&&reverse2!=null) {
    		while(reverse2!=null) {
    		
    	          sum=reverse2.data+carry;
    	           carry=sum/10;
    	           tail.next = new Node(sum%10);
    	           tail = tail.next;
    	           	 reverse2=reverse2.next;
    		}
    		
           
    	}
    	if(reverse1!=null&&reverse2==null) {
    		while(reverse1!=null) {
    	          sum=reverse1.data+carry;
    	           carry=sum/10;
    	           tail.next = new Node(sum%10);
    	           tail = tail.next;
    	            reverse1=reverse1.next;
    		}
    		
           
    	}
    	if(carry!=0)
    	{
    	    Node n=new Node(carry);
    	    tail.next=n;
    	}
    	
    	
//    	StringBuffer sb=new StringBuffer();
//    	Node n=first;
//    	while(n!=null) {
//    		sb.append(n.data);
//    		n=n.next;
//    	}
//    	Integer num1=Integer.parseInt(new String(sb));
//    	StringBuffer sb2=new StringBuffer();
//    	Node n2=second;
//    	while(n2!=null) {
//    		sb2.append(n2.data);
//    		n2=n2.next;
//    	}
//    	Integer num2=Integer.parseInt(new String(sb2));
//    	int count=num1+num2;
//    	String s=new String(Integer.toString(count));

    	
    	
    	return head;
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}