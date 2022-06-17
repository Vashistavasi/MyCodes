// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
    int [][] Matrix= {{348 ,391 },{618, 193}};
            System.out.println(Solution.maximumPath(2, Matrix));
        }
    }

// } Driver Code Ends


//User function Template for Java

class Solution{
	public static int [] maxDistance(int distance[][],boolean maxPathSet[][],int n) {
		int[]ans=new int[2];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!maxPathSet[i][j]&&max<=distance[i][j]) {
					max=distance[i][j];
					ans[0]=i;
					ans[1]=j;
				}
			}
			
		} return ans;
	}
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
    	int distance[][]=new int[N][N];
    	boolean maxPathSet[][]=new boolean[N][N];
    	for(int i=0;i<N;i++)
    		for(int j=0;j<N;j++) {
    			distance[i][j]=Integer.MIN_VALUE;
    		}
    	distance[0][0]=0;
    	for(int i=0;i<N;i++)
    		for(int j=0;j<N;j++) {
    			int node[]=maxDistance(distance,maxPathSet,N);
    			maxPathSet[node[0]][node[1]]=true;
    	    	int adjX[]= {1,1,1};
    	    	int adjY[]= {-1,0,1};	
    	    	for(int k=0;k<3;k++) {
    	    		int cnodeX=node[0]+adjX[k];
    	    		int cnodeY=node[1]+adjY[k];
    	    		if(areValid(cnodeX,cnodeY,N)&&!maxPathSet[cnodeX][cnodeY]&&distance[node[0]][node[1]]!=Integer.MIN_VALUE) {
    	    			distance[cnodeX][cnodeY]=distance[node[0]][node[1]]+Matrix[cnodeX][cnodeY];
    	    		}
    	    	}
    	    		
    		}
    	int ans=Integer.MIN_VALUE;
    	int finalX=0;
    	int finalY=0;
    	for(int i=0;i<N;i++)
    		for(int j=0;j<N;j++) {
    			if(ans<=distance[i][j]) {
    				ans=distance[i][j];
    				finalX=i;
    				finalY=j;
    			}
    		}
    	return ans-Matrix[finalX][finalY];
     
    	
    	
    	
    }
	private static boolean areValid(int row,int column, int n) {
		// TODO Auto-generated method stub
		
		return (row>=0&&column>=0&&row<n&&column<n);
	}
}