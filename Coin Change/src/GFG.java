//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) {
      
         {
            
            int Arr[] = {2,5,3,6};
            int n = 10;
            int m = Arr.length;
            Solution ob = new Solution();
            System.out.println(ob.count(Arr, m, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int S[], int m, int n) {
        // code here.
        long[] table = new long[n+1];
        table[0] = 1;
 
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];
 
        return table[n];
    	
    	
    }
}