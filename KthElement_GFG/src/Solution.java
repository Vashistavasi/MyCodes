// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
         int i=0;
        int j=0;
        int l=0;
        int size=n+m;
        if(n==0)
        return arr2[k-1];
        if(m==0)
        return arr1[k-1];
        int arr3[]=new int[size];
        for(l=0;l<size;l++){
            if(i>=n&&j<m){
                 arr3[l]=arr2[j];
                 j++;
                 continue;
                }
            if(j>=m&&i<n){
                 arr3[l]=arr1[i];
                 i++;
                 continue; 
            }
            if(arr1[i]<=arr2[j]){
                arr3[l]=arr1[i];
                i++;
                
            }
            else{
                arr3[l]=arr2[j];
                j++;
            }
        }
        return arr3[k-1];
        
    }
}