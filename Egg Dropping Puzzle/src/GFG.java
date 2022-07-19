//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
    	int dp[][]=new int[n+1][k+1];
    	for(int i=1;i<n+1;i++) {
    		dp[i][1]=1;
    		dp[i][0]=0;
    	}
    	for(int i=1;i<k+1;i++) {
    		dp[1][i]=i;
    	}
    	for(int i=2;i<n+1;i++) {
    		for(int j=2;j<k+1;j++) {
    			dp[i][j]=Integer.MAX_VALUE;
    			for(int x=1;x<=j;x++) {
    				int res=1+Math.max(dp[i-1][x-1],dp[i][j-x]);
    				if(res<dp[i][j])
    					dp[i][j]=res;
    					
    			}
    		}
    	}
    	return dp[n][k];
    	
    	
    	
	    // Your code here
	}
}