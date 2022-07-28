//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
	public static void main(String args[]) throws IOException { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int rows=sc.nextInt();
       		int columns=sc.nextInt();
			
			int matrix[][]=new int[rows][columns];
          
        	for(int i=0; i<rows;i++){            
            	for(int j=0; j<columns;j++){
                	matrix[i][j]=sc.nextInt();
            	}
         	}
         	int target = sc.nextInt();
         	
			Solution x = new Solution();
			
			if (x.search(matrix, rows, columns, target)) 
				System.out.println(1); 
			else
				System.out.println(0); 
			t--;
		}
	} 
}
// } Driver Code Ends




class Solution 
{ 
    //Function to search a given number in row-column sorted matrix.
    public static int binarySearch(int m[][],int row,int x,int l,int r){
        while(l<=r){
        int mid=l+(r-l)/2;
        if(m[row][mid]==x)
        return 1;
        else if(x<m[row][mid]){
            r=mid-1;
        }
        else
        l=mid+1;
        }
        return -1;
        
    }
	static boolean search(int matrix[][], int n, int m, int x) 
	{  
	    // code here
	    int ans=0;
	    for(int i=0;i<n;i++){
	        ans=binarySearch(matrix,i,x,0,m-1);
	        if(ans==1)
	        return true;
	    }
	    return false;
	} 
} 
