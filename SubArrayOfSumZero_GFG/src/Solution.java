// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
           HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
       
       int i = -1;
       int sum = 0;
       hs.put(sum,i);
       int res = 0;
       
       while(i<arr.length-1)
       {
           i++;
           sum = sum + arr[i];
        //   System.out.println(sum);
           if(!hs.containsKey(sum))
           {
               hs.put(sum,i);
           }
           else
           {
               int ans = i - hs.get(sum);
               res = Math.max(res,ans);
           }
           
       }
          return res;
    //   System.out.println("------");
    //     for(Map.Entry m : hs.entrySet()){    
    // System.out.println(m.getKey()+" "+m.getValue());    
   }  
    
        
        // int prefix[]= new int [n];
        //  prefix[0]= a[0];
        // for(int i=1;i<a.length;i++){
        //     prefix[i]=prefix[i-1]+a[i];
        // }
        // if(prefix[n-1]==0)
        // return n;
        // int ans=0;
        // // for(int i=n-1;i>=0;i--){
        // //     if(prefix[i]==0){
        // //         ans=i;
        // //         break;
        // //     }
        // // }
        // for(int i=0;i<a.length;i++){
        //     for(int j=i+1;j<a.length;j++){
        //         if(prefix[j]-prefix[i]==0)
        //         {
        //             ans=Math.max(ans,j-i);
        //         }
        //     }
        // }
        // return ans;
        // int min[]=new int[n];
        // min[0]=a[0];
        // for(int i=1;i<n;i++){
        //     min[i]=Math.min(min[i-1]+a[i],a[i]);
        // }
        
        
        // Your code here
        // int ans=0;
        // int dp[][]=new int[n][n];
        // for(int start=0;start<n;start++){
        //     dp[start][start]=a[start];
        //     for(int end=start+1;end<n;end++){
        //         dp[start][end]=dp[start][end-1]+a[end];
        //         if(dp[start][end]==0){
        //             ans=Math.max((end-start+1),ans);
        //         }
        //     }
        // }
       
        //  return ans;
    
    
}