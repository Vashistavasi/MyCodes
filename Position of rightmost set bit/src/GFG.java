// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		
		{
			int n=12;//input n
			Solution ob=new Solution();
			System.out.println(ob.getFirstSetBit(n));//calling method
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
            
        // Your code here
    	int ans=0;
    	int value=0;
    	while(ans!=1){
    		
    		value++;
    		if(n%2==1)
    			break;
    		n=n/2;
    	}
    	return value;
            
    }
}