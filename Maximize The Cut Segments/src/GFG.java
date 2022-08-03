//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    public static int recursiveCall(int n, int x, int y, int z,int count,int dp[]){
        
        if(n<0)
        return Integer.MIN_VALUE;
        else if(dp[n]!=0)
        return dp[n];
        else if(n==0)
        return count;
        else 
        return Math.max(Math.max(recursiveCall(n-x,x,y,z,count+1,dp),
        recursiveCall(n-y,x,y,z,count+1,dp)),recursiveCall(n-z,x,y,z,count+1,dp));
    }
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int dp[]=new int[n+1];
       for(int i=1;i<n+1;i++){
           if(i-x>=0 && dp[i-x]==0){
            dp[i-x]=recursiveCall(i-x,x,y,z,0,dp);
            
           }
          
            if(i-y>=0 && dp[i-y]==0){
            dp[i-y]=recursiveCall(i-y,x,y,z,0,dp);    
            }
          
            if(i-z>=0 &&dp[i-z]==0){
            dp[i-z]=recursiveCall(i-z,x,y,z,0,dp);
            }
            if(i-y>=0)
            dp[i]=Math.max(1+dp[i-y],dp[i]);
            if(i-z>=0)
            dp[i]=Math.max(1+dp[i-z],dp[i]);
            if(i-x>=0)
            dp[i]=Math.max(1+dp[i-x],dp[i]);
          //System.out.print(" "+ dp[i]+ " i "+ i+ " ");
       }
       return dp[n];
    }
}
