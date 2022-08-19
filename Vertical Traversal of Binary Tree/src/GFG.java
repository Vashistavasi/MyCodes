//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
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

class GFG {
    
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
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java
class LevelNode{
	int data;
	int level;
	LevelNode left;
	LevelNode right;
	LevelNode(int data,int level){
		this.data=data;
		this.level=level;
		left=null;
		right=null;
	}

	
}
   


class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
	static int min=0;
	static int max=0;
//	public static void min(Node root,int d) {
//		if(root==null)
//			return ;
//		if(min>d)
//			min=d;
//		if(max<d)
//			max=d;
//		min(root.left,d-1);
//		min(root.right,d+1);
//
//	}
	public static LevelNode build(Node root,int hd) {
		if(root==null)
			return null;
		LevelNode head=new LevelNode(root.data,hd);
		if(min>hd)
			min=hd;
		if(max<hd)
			max=hd;
		head.left=build(root.left,hd-1);
		head.right=build(root.right,hd+1);
		return head;
	}
//	public static void max(Node root,int d) {
//		if(root==null)
//			return ;
//		
//		max(root.right,d+1);
//		max(root.left,d-1);
//
//	}
//	public static void printVertical(Node root, int line,ArrayList<Integer> al,int i) {
//		if(root==null)
//			return;
//		if(line==i)
//			al.add(root.data);
//		printVertical(root.left,line,al,i-1);
//		printVertical(root.right,line,al,i+1);
//	}
//	public static ArrayList<Integer> al;
	public static ArrayList<LevelNode>al;
//	public static void traverse(LevelNode root,int level){
//		if(root==null)
//			return;
//		ArrayDeque<LevelNode> que=new ArrayDeque<LevelNode>();
//		que.add(root);
//		while(!que.isEmpty()) {
//			LevelNode curr=que.poll();
//		//if(curr.level==level)
//				al.add(curr.data);
//			if(curr.left!=null)
//				que.add(curr.left);
//			if(curr.right!=null)
//				que.add(curr.right);
//		}
//	}
	public static void traverse(LevelNode root,int level){
		if(root==null)
			return;
		ArrayDeque<LevelNode> que=new ArrayDeque<LevelNode>();
		que.add(root);
		while(!que.isEmpty()) {
			LevelNode curr=que.poll();
		//if(curr.level==level)
				al.add(curr);
			if(curr.left!=null)
				que.add(curr.left);
			if(curr.right!=null)
				que.add(curr.right);
		}
	}
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here

//    	 al=new ArrayList<Integer>();
    	al=new ArrayList<LevelNode>();
    	//min(root,0);
    //	max(root,0);
    	LevelNode head=build(root,0);
//    	for(int i=min;i<=max;i++) {
//    	traverse(head, i);	
//    	}
    	traverse(head,0);
    	Collections.sort(al,new Comparator<LevelNode>() {

			@Override
			public int compare(LevelNode o1, LevelNode o2) {
				// TODO Auto-generated method stub
				return o1.level-o2.level;
			}
	
    	});
    	ArrayList<Integer> ans=new ArrayList<Integer>();
    	for(int i=0;i<al.size();i++) {
    		ans.add(al.get(i).data);
    	}
    	return ans;
    }
}