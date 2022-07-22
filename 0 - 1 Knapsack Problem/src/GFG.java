//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
           static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
         
         int dp[][]=new int[n+1][W+1];
         for(int i=0;i<=n;i++){
             for(int j=0;j<=W;j++){
                 if(i==0||j==0){
                     dp[i][j]=0;
                 }
                 else if(wt[i-1]<=j){
                     dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                 }
                 else{
                     dp[i][j]=dp[i-1][j];
                 }
             }
         }
          return dp[n][W];
         
//          int total=0;
//          int valTotal=0;
//          HashMap<Integer,Integer>hm=new HashMap<Integer,Integer>();
//          for(int i=0;i<n;i++){
//              total+=wt[i];
//              valTotal+=val[i];
//              hm.put(wt[i],val[i]);
//          }
//          if(W>=total)
//         	 return valTotal;
//          boolean dp[]=new boolean[total+1],dd[]=new boolean[total+1];
//          dp[0]=dd[0]=true;
//          hm.put(0,0);
         
    
//   boolean fa=false;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<total+1;j++) {
//             	 if(dp[j]){
//                      if(j+wt[i]==49)
//                     	fa=true;
//                      dd[j+wt[i]]=true;
//                      if(hm.containsKey(j+wt[i])){
//                          int temp=hm.get(j+wt[i]);
//                          if(temp<hm.get(j)+hm.get(wt[i]))
//                          hm.put(j+wt[i],hm.get(j)+hm.get(wt[i]));
//                      }
//                      else
//                      hm.put(j+wt[i],hm.get(j)+hm.get(wt[i]));
//                  }}
//                  for(int j=0;j<total+1;j++){
//                       if(dd[j])
//                  dp[j]=true;
//                  dd[j]=false;
//                  }	}
//           Set<Integer> al= hm.keySet();
//           int ans=Integer.MIN_VALUE;
//           Iterator <Integer> it=al.iterator();
//           while(it.hasNext()){
//         	   int key=it.next();
//               if(key<=W)
//               {
//                   ans=Math.max(ans,hm.get(key));
//               }
//           }
         
       
// return ans;
}
}


