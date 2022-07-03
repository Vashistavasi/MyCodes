// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    String UncommonChars(String A, String B)
    {
        // code here
        StringBuffer sb=new StringBuffer();
        HashSet<Character> hs=new HashSet<Character>();
          HashSet<Character> hs1=new HashSet<Character>();
          HashSet<Character> a=new HashSet<Character>();
        for(int i=0;i<A.length();i++){
            hs.add(A.charAt(i));
        }
        for(int i=0;i<B.length();i++){
            if(!hs.contains(B.charAt(i))){
                             if(!a.contains(B.charAt(i)))
                sb.append(B.charAt(i));
                    a.add(B.charAt(i));
            }
        }
         for(int i=0;i<B.length();i++){
            hs1.add(B.charAt(i));
        }
        for(int i=0;i<A.length();i++){
            if(!hs1.contains(A.charAt(i))){
                if(!a.contains(A.charAt(i)))
                sb.append(A.charAt(i));
                    a.add(A.charAt(i));
            }
        }
        String s=new String(sb);
        if(s.length()==0)
        return "-1";
        char c[]=s.toCharArray();
       
        Arrays.sort(c);
        String ans=new String(c);

        
        return ans;
    }
}