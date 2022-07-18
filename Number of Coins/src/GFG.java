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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{
	public int recursiveCall(int x,int []sum, int index, int coins,int[]input) {
		int ans=Integer.MAX_VALUE;
        for(int i=0;i<input.length;i++)
		ans=Math.min(ans, count(x-input[i],sum,index,coins+1,input));
		return ans;
	}
	
    public int count(int x, int[]sum, int index, int coins, int[]input) {
    	if(index==0)
    		return Integer.MAX_VALUE;
    	if(x==0)
    		return coins;
    	else if(x<0)
    		return Integer.MAX_VALUE;
    	else if(x<index&&sum[x]!=Integer.MAX_VALUE) 
    		return sum[x]+1;
    		else
    			return recursiveCall(x,sum,index,coins,input);
    		
    	}
    
	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	
				int sum[]=new int[V+1];
		int count=0;
//		return count(V,sum,1,count,coins);
		for(int i=1;i<V+1;i++) {
			sum[i]=count(i,sum,i,count,coins);
		}
		if(sum[V]!=Integer.MAX_VALUE)
		return sum[V];
		return -1;
	} 
}