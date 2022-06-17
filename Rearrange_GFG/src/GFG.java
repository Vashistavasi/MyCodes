

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException
	{

//		Scanner in = new Scanner(System.in);
     
//		int t = in.nextInt();
    long arr[]= {1,2,3,4,5,6};
    int n= arr.length;
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    Solution.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}




//} Driver Code Ends


class Solution{
 
 // temp: input array
 // n: size of array
 //Function to rearrange  the array elements alternately.
 public static void rearrange(long arr[], int n){
     int i=0;
     int j=n-1;
     long brr[]=new long[n];
     
     for(int k=0;k<n;k++){
         if(j>=0&&i<n){
              if(k%2==0){
             brr[k]=arr[j];
             j--;
         }else
     {
         brr[k]=arr[i];
         i++ ;
     }
         }
        
     }
     for(int ii=0;ii<n;ii++){
         arr[ii]=brr[ii];
     }
     // Your code here
     
 }
 
}


