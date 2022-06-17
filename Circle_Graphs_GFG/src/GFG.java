// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    String A[] = in.readLine().trim().split(" ");
		    int N = Integer.parseInt(A[0]);
		    A = in.readLine().trim().split(" ");
		    
		    Solution ob = new Solution();
		    System.out.println(ob.isCircle(N, A));
		}
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
	static int findIndex(boolean visited[],String a[], char c) {
		for(int i=0;i<a.length;i++) {
			if(!visited[i]) {
				if(a[i].charAt(0)==c)
					return i;
			}
		}
		return -1;
	}
    static int isCircle(int N, String A[])
    {
        // code here
    	if(A.length==1) {
    		if(A[0].charAt(0)==A[0].charAt(A.length-1))
    			return 1;
    		else
    			return 0;
    	}
    	boolean visited[]=new boolean[A.length];
    	int ans=1;
    	char start=A[0].charAt(0);
    	visited[0]=true;
    	int index=findIndex(visited, A, A[0].charAt(A[0].length()-1));
    	if(index==-1)
    		return 0;
    	for(int i=0;i<A.length;i++) {
    		visited[index]=true;
    		char last=A[index].charAt(A[index].length()-1);
    		index=findIndex(visited, A, last);
    		if(index==-1&&i!=A.length-1)
    		{
    			ans=0;
    			return ans;
    		}
    			
    		if(i==A.length-1) {
    			if(last!=start) {
    				ans=0;
        			return ans;
    			}
    				
    		}
    		
    	}
    	
    	return ans;
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}