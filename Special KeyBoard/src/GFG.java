// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.optimalKeys(N));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    public static int count(int N,int dp[]){
        if(dp[N]!=0)
        return dp[N];
        if(N<=6)
      return N;
     int acount=1;
     int currAns=0,prevAns=0;
          do {
       currAns=Math.max(currAns,(N-acount-1)*count(acount,dp));
      // prevAns=findCount(acount-1,N);
       acount++;
      } while(acount<=N-3);
      
      return currAns;
    }
    static int optimalKeys(int N){
        // code here
      int ans[]=new int[N+1];
      for(int i=0;i<N+1;i++){
          ans[i]=count(i,ans);
      }
      //System.out.println(Arrays.toString(ans));
      return ans[N];
    }
}