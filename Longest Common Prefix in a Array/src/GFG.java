//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public static String findPrefix(String s, String x){
        int len1=s.length();
        int len2=x.length();
        int i=0;
        StringBuffer sb=new StringBuffer();
        while(i<len1 && i< len2 &&(s.charAt(i)==x.charAt(i))){
            sb.append(s.charAt(i));
            i++;
        }
        return new String(sb);
    }
    
    String longestCommonPrefix(String arr[], int n){
        // code here
        if(n==1)
        return arr[0];
        String ans=findPrefix(arr[0],arr[1]);
        
        for(int i=2;i<n;i++){
            ans=findPrefix(ans,arr[i]);
            if(ans.length()==0)
            return "-1";
        }
        return ans;

    }
}