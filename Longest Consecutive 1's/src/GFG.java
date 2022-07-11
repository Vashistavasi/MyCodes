// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxOnes(int a[]){
        
        int count=0;
        int ans=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0)
            count=0;
            else{
                count++;
                ans=Math.max(ans,count);
            }
            
        }
        return ans;
    }
    public static int maxConsecutiveOnes(int N) {
        int temp=N;
        int bits[]=new int[32];
       int i=31;
        while(temp!=0){
            bits[i--]=temp%2;
            temp=temp/2;
        }
        int ans=maxOnes(bits);
         return ans;
        
        // Your code here
        
    }
}



// { Driver Code Starts.

class Main {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//input n
		    
		    Solution obj = new Solution();
		    
		    //calling maxConsecutiveOnes() function
		    System.out.println(obj.maxConsecutiveOnes(n));
		}
	}
}


  // } Driver Code Ends