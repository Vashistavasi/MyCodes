//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int key = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.binarysearch(arr, n, key));
            T--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static int search(int arr[], int start, int end, int value){
        if(end>=start){
            
            int mid=start+(end-start)/2;
            if(arr[mid]==value)
            return mid;
            else if(value<arr[mid]){
                end =mid-1;
                return search(arr, start, end, value);
            }
            else{
                start=mid+1;
                return search(arr,start, end, value);
            }
        }
        else
        return -1;
        
    }
    int binarysearch(int arr[], int n, int k) {
        // code here
        return search(arr,0,n-1,k);
    }
}