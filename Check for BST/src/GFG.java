//{ Driver Code Starts
//Initial Template for Java
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
        	    if(g.isBST(root))
			        System.out.println(1);
			    else
			        System.out.println(0);
                t--;
            
        }
    }
  
}



// } Driver Code Ends


//User function Template for Java


public class Solution
{
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root, Node min, Node max){
        if(root==null)
        return true;
        else if(min!=null && min.data>=root.data)
        return false;
        else if(max!=null && max.data<=root.data)
        return false;
        else
        return isBST(root.left,min,root) && isBST(root.right,root,max);
    }
    boolean isBST(Node root)
    {
        // code here.
             // code here.
             Node min=null;
             Node max=null;
             return isBST(root,min,max);
             
             
             
       // boolean flag=true;
        // if(root.left!=null){
        //     if(root.data>root.left.data)
        //     flag=flag&& isBST(root.left);
        //     else
        //     return false;
        // }
        // if(root.right!=null){
        //     if(root.data<root.right.data)
        //     flag=flag&& isBST(root.right);
        //     else
        //     return false;
        // }
        // if(root==null)
        // return true;
        // if(root.left!=null){
        //     if(root.data<root.left.data)
        //     return false;
        // }
        // if(root.right!=null){
        //     if(root.data>root.right.data)
        //     return false;
        // }
        // if(root.right!=null){
        //   flag=flag&& isBST(root.right);
        // }
        // if(root.left!=null){
        //     flag=flag&& isBST(root.left);
        // }
        // return flag;
    }
}