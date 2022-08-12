//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String S)
    {
        // your code here
        int n=S.length();
        int m=pat.length();
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(S.charAt(i)==pat.charAt(0) && i+m<n+1){
                
                String s1=S.substring(i,i+m);
                if(s1.equals(pat))
                ans.add(i+1);
            }
        }
        if(ans.size()>0)
        return ans;
        else{
            ans.add(-1);
            return ans;
        }
    }
}