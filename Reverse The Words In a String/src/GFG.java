// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        StringTokenizer st=new StringTokenizer(S,".");
        String[] tokens=new String[st.countTokens()];
        int i=0;
        while(st.hasMoreElements()) {
        	tokens[i]=st.nextToken();
        	i++;
        }
    StringBuffer sb=new StringBuffer();
    for(int k=tokens.length-1;k>=0;k--) {
    	sb.append(tokens[i]);
    	if(k!=0)
    	sb.append(".");
    }
    return new String(sb);
    }
}