// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class So
{
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        // Your code goes here
        long sum1=0;
        long sum2=0;
         long ans=-1l;
 
        for(long i: A){
            sum1+=i;
        }
        for(long i: B){
            sum2+=i; 
        }
         long diff=Math.abs(sum1-sum2);
        if(diff%2==1){
            System.out.println(" here inside difference module 2 ");
          return -1l;  
        }
        
        if((sum1+sum2)%2==1){
            System.out.println(" here inside sum module 2 ");
             return -1l; 
        }
      
        if(sum1>sum2) {
        	 HashSet<Long> hs=new HashSet<Long>();
             for(int i=0;i<A.length;i++){
                 hs.add(A[i]);
             }
              for(int i=0;i<B.length;i++){
                if(hs.contains(B[i]+(long)(diff/2))){
                  
                    ans =1l;
                }
             }
        }else {
        	 HashSet<Long> hs=new HashSet<Long>();
             for(int i=0;i<B.length;i++){
                 hs.add(B[i]);
             }
              for(int i=0;i<A.length;i++){
                if(hs.contains(A[i]+(long)(diff/2))){
                  
                    ans =1l;
                }
             }
        }
       
        return ans;
        
      
        
        
       
        // long difference=sum1>sum2?(sum1-sum2):(sum2-sum1);
        // for(int i=0;i<A.length;i++){
        //     for(int j=0;j<B.length;j++){
        //         long temp=Math.abs(2*(A[i]-B[j]));
        //         // if(sum1>sum2)
        //         //  temp=2*(A[i]-B[j]);
        //         // else
        //         // temp=2*(B[j]-A[i]);
                
        //         if(temp==difference)
        //         {
        //             ans=1l;
        //             break;
        //         }
        //     }
        //      if(ans==1l)
        //     break;
        // }

        //   return ans;
  
}

}

// { Driver Code Starts.

// Driver class
class An {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
  
        // looping through all testcases
//      
            So ob = new So();
        long []a1= { 4, 1 ,2 ,1 ,1 ,2};
        long []b1= { 3, 6, 3, 3};
        int n1=a1.length;
            int m1=b1.length;
            long ans = ob.findSwapValues(a1,n1,b1,m1);
            System.out.println(ans);
            
    }
}




  // } Driver Code Ends