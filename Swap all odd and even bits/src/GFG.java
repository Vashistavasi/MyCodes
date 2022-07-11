// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to swap odd and even bits.
    public static int swapBits(int n) 
    {
	    // Your code
	   int value=1;
	   int ans=0;
	   for(int i=0;i<32;i+=2){
	       int last=(n&(1<<i));
	       int secondLast=(n&(1<<(i+1)));
	       if(last>0)
	    	   last=1;
	       if(secondLast>0)
	    	   secondLast=1;
	       ans+=secondLast*value;
	       value=value*2;
	       ans+=last*value;
	       value=value*2;
	   }
	   return ans;
	}
    
}

// { Driver Code Starts.

class GFG{

	public static void main (String[] args) {
		
	{
		    int n =23;//taking n
		    
		    Solution obj = new Solution();
		    
		    //calling swapBits() method of class
		    //Swap
		    System.out.println(obj.swapBits(n));
		}
	}
}  // } Driver Code Ends