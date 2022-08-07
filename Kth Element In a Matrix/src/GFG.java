//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class KthSmallestElement{
	public static void main(String[] args){

		{
			
			int[][] a= {{16, 28, 60, 64},
	                   {22, 41, 63, 91},
	                   {27, 50, 87, 93},
	                   {36, 78, 87, 94 }};
			int n=a.length;

    		
			int k=6;
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(a,n,k));
		    
		    
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public static int [] merge(int [][]mat, int r,int []prev){
        int c=mat[0].length;
        int size=prev.length;
        int []m=new int[size+c];
        int k=0;
        int i=0,j=0;
        {
            while(i<c && j<size ){
                System.out.println(k);
            if(mat[r][i]<prev[j]){
                m[k++]=mat[r][i++];
            }
           else {
                m[k++]=prev[j++];
            }    
            }
            
            while(i<c){
                m[k++]=mat[r][i++];
            }
            while(j<size) {
                m[k++]=prev[j++];
            }
            
        }
        return m;
        
        
    }
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        //code here.
        int row=0;
        int prev[]=new int[0];
        while(row<n){
            //int size=prev.length;
            prev=merge(mat,row,prev);
            row++;
        }
        Arrays.toString(prev);
        return prev[k-1];   
        
    }
}