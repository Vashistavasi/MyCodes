// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.firstRepChar(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String firstRepChar(String S) 
    { 
        // code here
        HashMap<Character,Integer>hm=new HashMap<Character,Integer>();
        for(int i=0;i<S.length();i++){
            if(!hm.containsKey(S.charAt(i)))
            {
                hm.put(S.charAt(i),1);
            }
            else{
                StringBuffer sb=new StringBuffer();
                sb.append(S.charAt(i));
                String a=new String(sb);
                return a;
            }
        }
        return "-1";
    }
} 