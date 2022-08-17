//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Node{
	int data;
	Node left;
	Node right;
	Node (int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
class Solution
{
	public Node build( int start, int end,int arr[]) {
		if(start>end) {
			return null;
		}
		int mid=start+(end-start)/2;
	Node root=new Node(arr[mid]);
		root.left=build(start,mid-1,arr);
		root.right=build(mid+1,end, arr);
		return root;
	}
	public void preOrderTraversal(Node root, ArrayList<Integer> al) {
		if(root==null)
			return ;
		al.add(root.data);
		preOrderTraversal(root.left,al);
		preOrderTraversal(root.right,al);
	}
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here
    	Node root=build(0,nums.length-1,nums);
    	ArrayList<Integer> al=new ArrayList<Integer>();
    	preOrderTraversal(root,al);
    	int ans[]=new int[al.size()];
    	for(int i=0;i<al.size();i++) {
    		ans[i]=al.get(i);
    	}
    	
    	return ans;
    }
}