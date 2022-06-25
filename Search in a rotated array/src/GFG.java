// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
      
       
        {
           
            int A[]= {3,4,5,1,2};
            int n=A.length;
            System.out.println(new Solution().search(A, 0, n-1 , 5));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static void merge(int A[],int l,int mid,int h){
        int n1=mid-l;
        int n2=h-mid+1;
        int left[]=new int[n1];
        int right[]=new int[n2];
        for(int i=0;i<n1;i++){
            left[i]=A[i];
        }
        for(int i=0;i<n2;i++){
            right[i]=A[mid+i];
        }
        int i=0,j=0;
        int k=0;
        while(i<n1&&j<n2){
            if(left[i]<right[j]){
                A[k++]=left[i++];
            }
            else
            A[k++]=right[j++];
        }
        
        while(i<n1){
            A[k++]=left[i++];
        }
        while(j<n2){
            A[k++]=right[j++];
        }
    }
    public static int binarySearch(int a[],int l,int h, int key){

        if(l<=h){
              int  mid = l+(h-l)/2;
        if(a[mid]==key)
        return mid;
        if(a[mid]<key){
            return binarySearch(a,mid+1,h,key);
        }
        else{
            return binarySearch(a,l,mid-1,key);
        }
        }
        return -1;
     
    }
    int search(int A[], int l, int h, int key)
    {
        // Complete this function
        int i=0,j=1;
        while(A[i]<=A[j] &&j<h){
            i++;
            j++;
        }
        int shift=j;
        merge(A,l,shift,h);
        Arrays.stream(A).forEach(x->System.out.print(x+" "));
        System.out.println();
        int b=binarySearch(A,l,h,key);
        System.out.println(b);
        if(b==-1)
        return -1;
        else
        return (b+shift)%(h-l+1);
    }
}