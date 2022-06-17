// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	
    public static void main(String args[]) throws IOException {
    	int mat[][]  = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
      System.out.println(Solution.shortestDistance(9, 10, mat, 4, 4));
    }
  
 
}// } Driver Code Ends


// User function Template for Java
class Point{
	int x;
	int y;
	int value;
	int distance;
}

class Solution {
	  public static int shortestDistance(int N, int M, int A[][], int X, int Y) {
	        // code here
	    	boolean visited[][]=new boolean[N][M];
	        Point[][] pt=new Point[N][M];
	        for(int i=0;i<N;i++) {
	        	for(int j=0;j<M;j++) {
	        		pt[i][j]=new Point();
	        		pt[i][j].x=i;
	        		pt[i][j].y=j;
	        		pt[i][j].value=A[i][j];
	        		pt[i][j].distance=Integer.MAX_VALUE;
	        	}
	        }
	        pt[0][0].distance=0;
	       return Dfs(pt,visited,0,0,X,Y);
	        
	    	
	    	
	    	
	    }
	    public static boolean isValid(int x, int y, Point point[][]) {
	    	int rows=point.length;
	    	int columns=point[0].length;
	    	return(x<rows && x>=0 && y<columns && y>=0);
	    }
	    
	    public static int Dfs(Point point[][],boolean[][] visited,int x, int y,int desX,int desY) {
	    	visited[x][y]=true;
	    	ArrayDeque<Point> stack=new ArrayDeque<Point>();
	    	stack.add(point[x][y]);
	    	int [] adjX= {-1,1,0,0};
	    	int[] adjY= {0,0,-1,1};
	    	while(stack.isEmpty()==false) {
	    		Point p=stack.poll();
	    		int x1=p.x;
	    		int y1=p.y;
	    		for(int i=0;i<4;i++) {
	        		int cnodeX=x1+adjX[i];
	        		int cnodeY=y1+adjY[i];
	        		if(isValid(cnodeX,cnodeY,point) && !visited[cnodeX][cnodeY]&&
	        				point[cnodeX][cnodeY].value==1) {
	        			if(cnodeX==desX &&cnodeY==desY) {
	        				visited[cnodeX][cnodeY]=true;
	        				  point[cnodeX][cnodeY].distance=point[x1][y1].distance+1;
	        				  stack.add(point[cnodeX][cnodeY]);
	        	    		     return point[cnodeX][cnodeY].distance;	
	        			}
	        			else {
	        				visited[cnodeX][cnodeY]=true;
	        				 point[cnodeX][cnodeY].distance=point[x1][y1].distance+1;
	        				 stack.add(point[cnodeX][cnodeY]);
	        				 
	        				 
	        			}
	        				 
	       		   
	        		   
	        		}
	        	}
	    	}
	    	
	    	return -1;
	    	
	    }

    
}