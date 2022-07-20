//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

		public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
		int sum=0;
		for(int i:arr)
			sum+=i;
		int x=(sum/2) +1;
	boolean dp[]=new boolean[sum],dd[]=new boolean [sum];	
		dd[0]=true;
		dp[0]=true;
		for(int i=0;i<n;i++) {
			for(int j=0;j+arr[i]<x;j++) {
				if(dp[j])
					dd[j+arr[i]]=true;
			}
			 for (int j = 0; j<x ; j++) {
	                if (dd[j])
	                    dp[j] = true;
	                dd[j] = false;
	            }
			
		}
		int ans=Integer.MAX_VALUE;
		for(int i=x-1;i>=0;i--) {
			
			if(dp[i])
				ans=Math.min(ans, Math.abs(sum-2*i));
	
		}
     
      return ans;
}
}