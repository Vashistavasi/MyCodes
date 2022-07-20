//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of steps in stair
            int n = sc.nextInt();
            
            //calling method countWays() of class Hops
            System.out.println(new Solution().countWays(n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
  public static long jumps(int n,long [] memory) {
		if(n<=0)
			return 0l;
		else 
		{
			long ans=0;
			if(n-1>=0&&memory[n-1]==-1)
				memory[n-1]=jumps(n-1,memory)%1000000007;
			if(n-2>=0&&memory[n-2]==-1)
				memory[n-2]=jumps(n-2,memory)%1000000007;
			if(n-3>=0&&memory[n-3]==-1)
				memory[n-3]=jumps(n-3,memory)%1000000007;
			
			ans+=memory[n-1]+memory[n-2]+memory[n-3];
			return ans;
		}
	}
    static long countWays(int n)
    {
        // add your code here
        if(n==1)
        return 1l;
        if(n==2)
        return 2l;
        if(n==3)
        return 4l;
    	long memory[]=new long[n+1];
    	Arrays.fill(memory, -1l);
    	memory[1]=1;
    	memory[2]=2;
    	memory[3]=4;
    	return jumps(n, memory)%1000000007;
    

    }
    
}

