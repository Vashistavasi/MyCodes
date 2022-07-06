// { Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

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
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Tree g = new Tree();
			    ArrayList<Integer> diagonalNode = g.diagonal(root);
			    for(int i = 0 ;i<diagonalNode.size();i++){
			        System.out.print(diagonalNode.get(i)+ " ");
			    }
		        System.out.println();
	        }
	}
}


// } Driver Code Ends


//User function Template for Java

/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
class Tree
{
    public static void printDiagonally(Node root, int lineNum, HashMap<Integer,ArrayList<Integer>> hm){
        
        if(root==null)
        return;
        
        ArrayList<Integer> al=new ArrayList<Integer> ();
       
        if(!hm.containsKey(lineNum)){
             al.add(root.data);
            hm.put(lineNum,al);
        }
        else{
            al=hm.get(lineNum);
            al.add(root.data);
            hm.put(lineNum,al);
        }
        
        printDiagonally(root.left,lineNum+1,hm);
        
        printDiagonally(root.right,lineNum,hm);
        
        
        
    }
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           HashMap<Integer,ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>>();
           ArrayList<Integer> ans=new ArrayList<Integer>();
           printDiagonally(root, 0, hm);
           
           hm.forEach((key,value)->{
        	  
        	   for(int i:value)
        		   ans.add(i);
           });
           
//         Iterator<Entry<Integer,ArrayList<Integer>>>it=hm.entrySet().iterator();
//         while(it.hasNext()) {
//        	 Map.Entry<Integer,ArrayList<Integer>> map=it.next();
//        	 ArrayList<Integer>temp=map.getValue();
//        	 for(int i:temp)
//        		 ans.add(i);
//         }
         return ans;
           
           
           
      }
}
