//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            String result = ob.removeDups(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String removeDups(String S) {
        // code here
        HashSet<Character> hs=new HashSet<Character>();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<S.length();i++){
            if(!hs.contains(S.charAt(i))){
                hs.add(S.charAt(i));
                sb.append(S.charAt(i));
            }
            
        }
        return new String(sb);
    }
}