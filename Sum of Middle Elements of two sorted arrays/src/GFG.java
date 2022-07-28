//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar1 = new int[n], ar2 = new int[n];
            String[] inputLine = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                ar1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                ar2[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().findMidSum(ar1, ar2, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] merge(int [] a ,int [] b, int n){
        int [] m=new int[2*n];
        int i=0;
        int j=0;
        int k=0;
        while(k<m.length){
            if(i<n && j<n && a[i]<b[j] ){
                m[k++]=a[i++];
            }
            else if(j<n && i<n && a[i]>=b[j] ){
                m[k++]=b[j++];
            }
            else if(i<n &&j==n ){
                m[k++]=a[i++];
            }
            else{
                m[k++]=b[j++];
            }
        }
        return m;
    }
    
    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
        int a[]=merge(ar1,ar2,n);
        //System.out.print(Arrays.toString(a));
        return a[n-1]+a[n];
        
        
        
    }
}