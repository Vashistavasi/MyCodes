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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static boolean isPalindrome(String s1) {
		
		char c[]=s1.toCharArray();
		boolean flag=true;
		for(int i=0;i<c.length/2;i++) {
			if(c[c.length-1-i]!=c[i]) {
				flag=false;
						break;
			}
		}
		return flag ;
	}
    static String longestPalin(String S){
        // code here
        String ans="";
        for(int i=0;i<S.length();i++)
        {
            for(int j=S.length()-1;j>=0&&j>=i;j--){
                if(ans.length()<j-i+1 && isPalindrome(S.substring(i,j+1)))
                ans=S.substring(i,j+1);
            }
        }
        return ans;
    }
}