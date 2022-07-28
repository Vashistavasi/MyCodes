//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            String S1 = input_line[0];
            String S2 = input_line[1];
            Solution ob = new Solution();
            System.out.println(ob.merge(S1,S2));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String merge(String S1, String S2)
    { 
        // code here
        int n=S1.length();
        int m=S2.length();
        int l=n+m;
        int i=0;
        int j=0;
        int k=0;
        char c[]=new char[l];
        while(i<l){
            if(j==n && k<m){
                c[i]=S2.charAt(k);
                k++;
                i++;
            }
            else if(k==m && j<n){
                c[i]=S1.charAt(j);
                j++;
                i++;
                
            }
           else if(i%2==0 && j<n){
                c[i]=S1.charAt(j);
                j++;
                i++;
            }
            else{
                c[i]=S2.charAt(k);
                k++;
                i++;
            }
            
            
        }
        
        return new String(c);
    }
} 