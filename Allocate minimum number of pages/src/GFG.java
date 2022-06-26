// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
 public static boolean isPossible(int a[],int n,int m, int currSum){
  int studentCount=1;
  int sum=0;
  for(int i=0;i<n;i++){
       sum+=a[i];
      if(sum<=currSum){
          continue;
      }
      else{
          studentCount++;
          sum=a[i];
      }
  }
  return studentCount<=m;
}
 public static int findPages(int[]A,int N,int M)
 {
     //Your code here
  
  int currSum=A[N-1];
 
  int max=0;
  for(int i:A) max+=i;
  //System.out.println(max);
  
 
  int answer=-1;
//   System.out.println(mid);
    //  if(true)
    //  return 113;
  while(currSum<=max) {
       int mid=currSum+(max-currSum)/2;
     // System.out.println(isPossible(A,N,M,mid));
	  if(isPossible(A,N,M,mid)) {
		  answer=mid;
		  max=mid-1;
	  }  
	  else { 
		  currSum=mid+1;
		    
	  }
  }
  return answer;
    
 }
};