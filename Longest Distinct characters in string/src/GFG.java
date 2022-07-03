// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
      //  BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
   
   
        {
           
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars("aewergrththy"));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
      ArrayDeque<Character> stack=new ArrayDeque<Character>();
      char s[]=S.toCharArray();
      int ans=0;
      for(int i=0;i<s.length;i++) {
    	  if(!stack.contains(s[i])) {
    		  stack.add(s[i]);
    		  ans=Math.max(ans, stack.size());
    	  }
    	  else {
    		  char c=s[i];
    		  char k;
    		  do {
    			   k=stack.poll();
    		  }while(c!=k);
    		  stack.add(c);
    		  
    	  }

      }
      return ans;
        
    }
}