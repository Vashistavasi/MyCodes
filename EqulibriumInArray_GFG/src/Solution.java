// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}// } Driver Code Ends


class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        long sum=0;
        for(long i:arr){
            sum+=i;
        }
        if(n==0||n==2)
        return -1;
        if(n==1)
        return 1;
        
        long forward[]=new long[n];
        forward[0]=arr[0];
        long backward[]=new long[n];
        for(int i=1;i<n;i++){
            forward[i]=forward[i-1]+arr[i];
        }
        backward[0]=arr[n-1];
        int k=1;
        for(int i=n-2;i>=0;i--){
            backward[k]=backward[k-1]+arr[i];
            k++;
        }
        // for(long i: forward){
        //     System.out.print(" "+ i+" ");
        // }
      int ans=0;
      boolean flag=false;
        for(int i=0;i<n;i++){
            if(forward[i]==backward[n-i-1]){
                flag=true;
                ans=i+1;
            }
           
        }
        if(flag)
            return ans;
       else 
       return -1;
        
        // long pivot=0;
        // long left=0;
        // long right=0;
        // for(int i=1;i<n;i++){
        //     if(i<n/2){
        //       pivot=(long)arr[i];
        //     for(int j=0;j<i;j++)
        //     left+=(long)arr[j];
        //     right=(long)(sum-pivot-left);
        //     if(left==right){
        //       return i+1; 
        //     }  
        //     }
        //     else{
        //          pivot=(long)arr[i];
        
        //     for(int j=i+1;j<n;j++)
        //     right+=(long)arr[j];
        //         left+=(long)(sum-pivot-right);
        //     if(left==right){
        //       return i+1; 
        //     }
        //     }
             
        //   left=0;
        //   right=0;
        // }
        // return -1;
        
    }
}
