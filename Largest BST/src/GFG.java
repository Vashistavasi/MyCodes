//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    public static boolean isBST(Node root,Node min, Node max){
    	if(root==null)
    		return true;
    	if(min!=null&& min.data>=root.data)
    		return false;
    	if(max!=null && max.data<=root.data)
    		return false;
    	return (isBST(root.left,min,root)&&isBST(root.right,root,max));
        
    }
    public static int leftHeight(Node root) {
    	int ht=0;
    	 
    		while(root!=null) {
    			ht++;
    			root=root.left;
    		
    	}
    	return ht;
    }
    public static int rightHeight(Node root) {
    	int ht=0;
    
    		while(root!=null) {
    			ht++;
    			root=root.right;
    		}
    	
    	return ht;
    }
    public static int a=0;
    public static void nodeCount(Node root) {
    	
    	if(root==null)
    		return ;
    	a++;
    	nodeCount(root.right);
    	nodeCount(root.left);
    	
//    	if(root==null)
//    		return 0;
//    	int lh=leftHeight(root);
//    	int rh=rightHeight(root);
//    	if(lh==rh)
//    		return 1<<lh-1;
//    	else
//    		return 1+nodeCount(root.left)+nodeCount(root.right);
//    	
    	
    	
    	
    }
    public static int size=Integer.MIN_VALUE;
    public static void preOrderTraversal(Node root) {
    	
    	if(root==null)
    		return;
    	Node min=null,max=null;
    	if(isBST(root,min,max)) {
    		a=0;
    		nodeCount(root);
        	size=Math.max (size,a);
        }
    	preOrderTraversal(root.left);
    	preOrderTraversal(root.right);
    	
    }
    
    static int largestBst(Node root)
    {
        // Write your code here
    	size=0;
    	a=0;
    	preOrderTraversal(root);
        return size;
        
        
        
    }
    
}