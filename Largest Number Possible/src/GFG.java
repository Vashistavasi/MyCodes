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
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        // code here
        int n=N;
        int s=S;
        if(S>9*n)
        return "-1";
        StringBuffer sb=new StringBuffer();
        while(n>0){
            int max=subtractMax(s);
           // System.out.println(max);
            s=s-max;
           // System.out.println(Integer.toString(s)+ " What ");
            sb.append(Integer.toString(max));
           // System.out.println(sb);
            n--;
        }
        String ans=new String(sb);
        if(ans.charAt(0)=='0'&&ans.charAt(ans.length()-1)=='0'){
             int a=Integer.parseInt(ans);
        if(a==0 && N!=1)
        return "-1";
        }        
       
    
        return ans;
    }
    public static int subtractMax(int n){
        int num=n;
     
        for(int i=9;i>=0;i--){
            
            
            num=num-i;
            // if(n==2)
            // System.out.println(num);
            if(num>=0)
            return i;
          
            num=n;
        }
        return -1;
        
    }
}