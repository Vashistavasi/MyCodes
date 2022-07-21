//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int total=0;
        for(int i:arr)
        total+=i;
        if(sum>total)
        return false;
        boolean dd[]=new boolean[total+1],dp[]=new boolean[total+1];
        dd[0]=dp[0]=true;
        for(int i=0;i<N;i++){
            for(int j=0;j+arr[i]<=total;j++){
                if(dp[j]){
                    dd[j+arr[i]]=true;
                }
            }
            for(int j=0;j<dd.length;j++){
                if(dd[j])
                dp[j]=true;
                dd[j]=false;
            }
            if(dp[sum])
        return true;
        }
        
        return false;
        
        
        
    }
}