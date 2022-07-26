//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	public static void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		
		{
			
			//list.printList();
			GfG g = new GfG();
		Node head=new Node(5);head.bottom=new Node(7);head.bottom.bottom=new Node(8);head.bottom.bottom.bottom=new Node(30);
		head.next=new Node(10); head.next.bottom=new Node(20);
		head.next.next=new Node(19);head.next.next.bottom=new Node(22);head.next.next.bottom.bottom=new Node(50);
		head.next.next.next=new Node(28);
		head.next.next.next.bottom=new Node(35);
		head.next.next.next.bottom.bottom=new Node(40);
		head.next.next.next.bottom.bottom.bottom=new Node(45);
		head.next.next.next.bottom.bottom.bottom.bottom=new Node(51);
		
			Node root = g.flatten(head);
			printList(root);
		
				}
	}	
}
// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    
    public static Node merge(Node n1, Node n2){
        
        Node ans=new Node(0);
        Node dummy=ans;
       int i=0;
        while(true){
         
            if(n1==null){
                while(n2!=null){
                dummy.bottom=new Node(n2.data);
                 //System.out.println("n2 "+n2.data);
                n2=n2.bottom;
               
                dummy=dummy.bottom;
                
                }
                //System.out.println("one");
               break;
            }
         if(n2==null){
                while(n1!=null){
                  dummy.bottom=new Node(n1.data);
                n1=n1.bottom;
                 dummy=dummy.bottom;
                 
                }
                //System.out.println("tone");
                break;
            }
              
            if(n1.data<n2.data){
                
                dummy.bottom=new Node(n1.data);
                //System.out.println(n1.data+ " w "+n2.data);
                  //System.out.println(n1.data+ " w "+n2.data+" "+ dummy.next.data);
                n1=n1.bottom;
                dummy=dummy.bottom;
                
            }
            else{
                dummy.bottom=new Node(n2.data);
                // System.out.println(n1.data+ " wt "+n2.data+" "+ dummy.next.data);
                n2=n2.bottom;
                 dummy=dummy.bottom;
               
            }
           
            
        }
//        System.out.println("exited while ");
//           dummy=ans.next;
//           while(dummy!=null){
//           System.out.print(" "+ dummy.data+ " ");
//           dummy=dummy.next;
//           }
//           System.out.println();
        return ans.bottom;
        
        
    }
    
    Node flatten(Node root)
    {
	// Your code here
	Node duplicate=root;
	Node temp=root;
    while(temp!=null) {
    	System.out.print(" "+ temp.data+" ");
    	temp=temp.next;
    }
	Node ans=null;
	while(duplicate!=null){
	    
	    ans=merge(ans,duplicate);
//	     temp=root;
//	    while(temp!=null) {
//	    	System.out.print(" "+ temp.data+" ");
//	    	temp=temp.next;
//	    }
//	    ans=merge(ans,duplicate.next);
	    duplicate=duplicate.next;
	    
	    
	}
	return ans;

    }
}