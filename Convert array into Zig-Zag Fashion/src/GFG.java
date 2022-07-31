// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().zigZag(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution {
    public static void swap(int from, int to, int[]a){
        int temp=a[from];
        a[from]=a[to];
        a[to]=temp;
    }
    void zigZag(int a[], int n) {
        
        
        for(int i=1;i<n;i+=2){
            
            if(a[i-1]>a[i])
            swap(i-1,i,a);
            if(i+1<n && a[i+1]>a[i])
            swap(i+1,i,a);
        }
        
    //   int i;
    //   int last=0,slast=0,tlast=0;
    //   int size=n%3;
    //   if(n==1||n==0)
    //   return ;
    //   if(n==2)
    //   {
    //       if(a[0]<a[1])
    //       return ;
    //       else{
    //           int tem=a[0];
    //           a[1]=tem;
    //           a[1]=a[0];
    //           a[0]=tem;
    //         return;
    //       }
    //   }
       
    //   for( i=0;i<n-2;i+=2){
    //       int x=a[i];
    //       int y=a[i+1];
    //       int z=a[i+2];
    //       if(x>y){
    //       a[i]=y;
    //       a[i+1]=x;
         
    //       }
    //       y=a[i+1];
    //       if(z>y){
    //           a[i+2]=y;
    //           a[i+1]=z;
    //       }
    //     //   int max=Math.max(z,Math.max(x,y));
    //     //   int smax=0;
    //     //   int tmax=Math.min(x,Math.min(y,z));
    //     //   if(max==x)
    //     //   smax=Math.max(y,z);
    //     //   else if(max==y)
    //     //   smax=Math.max(x,z);
    //     //   else
    //     //   smax=Math.max(x,y);
          
    //     //   a[i]=tmax;
    //     //   a[i+1]=max;
    //     //   a[i+2]=smax;
    //      // System.out.println(i+ " waht "+  Arrays.toString(a));
    //       last=a[n-1];
    //     slast=a[n-2];
    //     tlast=a[n-3];
    //   }
     
    //   if(size==1){
    //       if(a[n-1]<a[n-2]){
    //           int temp=a[n-1];
    //           a[n-1]=a[n-2];
    //           a[n-2]=temp;
    //       }
         
    //   }
    //   if(size==2){
    //       int max=Math.max(last,Math.max(slast,tlast));
    //       int min=Math.min(last,Math.min(slast,tlast));
    //       int smax;
    //           if(max==last)
    //       smax=Math.max(tlast,slast);
    //       else if(max==tlast)
    //       smax=Math.max(last,slast);
    //       else
    //       smax=Math.max(tlast,last);
    //       a[n-3]=smax;
    //       a[n-1]=min;
    //       a[n-2]=max;
    //   }
      
          
          
      
        // code here
    }

}