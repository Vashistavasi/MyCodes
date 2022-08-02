//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
      public static int recursiveCall(int start1,int start2, String s1, String s2,int dp[][]){
        int l1=s1.length();
        int l2=s2.length();
        if(start1<0||start2<0)
        return 0;
        if(dp[start1][start2]!=-1)
        return dp[start1][start2];
        
        else if(s1.charAt(start1)==s2.charAt(start2)){
         dp[start1][start2]=1+recursiveCall(start1-1,start2-1,s1,s2,dp);
         return dp[start1][start2];
            
        }
        
        else
        {
        dp[start1][start2]=Math.max(recursiveCall(start1,start2-1,s1,s2,dp),recursiveCall(start1-1,start2,s1,s2,dp));
            return dp[start1][start2];  
            
        }
        
    }
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int dp[][]=new int[x+1][y+1];
        for(int []row: dp)
        Arrays.fill(row,-1);
       int l1=s1.length();
       int l2=s2.length();
    //   for(int i=l1-1;i<=0;i--){
    //       for(int j=l2-1;j=0;j--){
    //           if(dp[i][j]==-1){
    //               dp[i][j]=recursiveCall(i,j,s1,s2,0,dp);
    //               System.out.println(dp[i][j]);
    //           }
    //       }
    //   }
        // for(int row[]:dp)
        // System.out.println(Arrays.toString(row));
        // System.out.println();
       
       return recursiveCall(l1-1,l2-1,s1,s2,dp);
       
       
    //   return dp[0][0];
        //return recursiveCall(0,0,s1,s2,0,dp);
    }
}