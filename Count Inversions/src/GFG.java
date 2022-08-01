//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    
    public static long merge(long arr[],long l,long m, long r){
     
        long left[]=Arrays.copyOfRange(arr,(int)l,(int)m+1);
        long right[]=Arrays.copyOfRange(arr,(int)m+1,(int)r+1);
        int i=0;
        int j=0;
        int k=(int)l;
        long swaps=0;
        while(i<(int)left.length && j<(int)right.length){
            if(left[i]<=right[j])
             {
                 arr[k++]=left[i++];
             }
             else{
                 arr[k++]=right[j++];
                 swaps+=m+1-(l+i);
             }
            
        }
        while(i<(int)left.length){
            arr[k++]=left[i++];
        }
        while(j<(int)right.length){
            arr[k++]=right[j++];
        }
        return swaps;
    }
    public static long mergeSort(long arr[],long l, long r){
        long count=0;
       
        if(l<r){
             int m=(int)l+(int)(r-l)/2;
          count+=  mergeSort(arr,l,m);
            count+=mergeSort(arr,m+1,r);
            count+=merge(arr,l,m,r);
        }
        return count;
    }
    static long inversionCount(long arr[], long N)
    {
        
       return mergeSort(arr,0,N-1);
        // Your Code Here
    //     Long count=0l;
    //     HashMap<Long,Integer>hm=new HashMap<Long,Integer>();
    //     Long temp[]=new Long[(int)N];
    //     for(int i=0;i<N;i++){
    //         hm.put(arr[i],i);
    //         temp[i]=arr[i];
    //     }
    //     Arrays.sort(arr);
    //     for(int i=0;i<N;i++){
    //         System.out.println(Arrays.toString(temp));
    //         if(arr[i]==temp[i]){
    //             continue;
    //         }
    //         else{
    //             int index=hm.get(arr[i]);
    //             swap(index,i,temp);
    //             hm.put(temp[index],index);
    //             hm.put(temp[i],i);
    //             System.out.println(index+" "+i);
    //             count++;
    //         }
    //     }
    //     return count*2;
    }
    // public static void swap(int from, int to, Long [] a){
        
    //     Long tem=a[from];
    //     a[from]=a[to];
    //     a[to]=tem;
        
        
    // }
}