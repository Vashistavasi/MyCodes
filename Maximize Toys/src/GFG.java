//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String st[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(st[0]);
            int K = Integer.parseInt(st[1]);
            String st1[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.toyCount(N, K, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
 class pair{
        int sum;
        int count;
        pair(int sum,int count){
            this.sum=sum;
            this.count=count;
        }
        public String toString(){
            return this.sum+" "+ this.count;
        }
    }
class Solution{
    public static int recursiveCall(int weight, int start, int []arr,int count){
       // System.out.println(count);
        int end=arr.length-1;
        if(weight<0)
        return Integer.MIN_VALUE;
        if(start>end )
        return count;
        else{
        return Math.max(recursiveCall(weight-arr[start],start+1,arr,count+1),recursiveCall(weight,start+1,arr,count));
    }
    }
   
    static int toyCount(int N, int K, int arr[])
    {
        Arrays.sort(arr);
        int sum=0;
        int count=0;
        for(int i:arr){
            if(sum>K)
            break;
            count++;
            sum+=i;
            
        }
       
        if(sum<=K)
        return N;
         return count-1;
    //     boolean dd[]=new boolean[K+1],dp[]=new boolean[K+1];
    //     dp[0]=dd[0]=true;
    //     pair [] possibleSums=new pair[K+1];
    //     for(int i=0;i<K+1;i++){
    //         possibleSums[i]=new pair(i,0);
    //     }
        
    //     for(int i=0;i<N;i++){
    //         for(int j=0;j+arr[i]<K+1;j++){
    //           if(dp[j]){
    //             dd[arr[i]+j]=true;
    //             possibleSums[arr[i]+j].count=Math.max(1+possibleSums[j].count,possibleSums[arr[i]+j].count);
                
    //         }   
    //         }
    //     for(int j=0;j<K+1;j++)
    //     {
    //         if(dd[j])
    //         dp[j]=true;
    //         dd[j]=false;
    //     }
         
    //     }
    //   //System.out.println(Arrays.toString(dp));
    //     //System.out.println(Arrays.toString(possibleSums));
    //   // System.out.println(dp[K]);
    //     int ans=Integer.MIN_VALUE;
    //     for(int i=0;i<K+1;i++){
    //         ans=Math.max(possibleSums[i].count,ans);
    //     }
    //     return ans;
        
        // int count=0;
        //  count=recursiveCall(K,0,arr,count);
        //  return count;
        // code here
        // int dp[][]=new int [N+1][K+1];
        // for(int i=0;i<N+1;i++){
        //     for(int j=0;j<K+1;j++){
        //         if(i==0||j==0)
        //         dp[i][j]=0;
        //         else if(j-arr[i-1]>=0) {
        //             dp[i][j]=Math.max(1+dp[i-1][j-arr[i-1]],dp[i-1][j]);
        //         }
        //         else
        //         dp[i][j]=dp[i-1][j];
        //     }
        // }
        // return dp[N][K];
    }
}