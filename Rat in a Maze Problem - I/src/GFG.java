// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    	public static boolean isSafe(int m[][], int n,int row,int col,int [][]sol) {
		if(row<n&& row>=0&&col<n&&col>=0&&m[row][col]!=0&&sol[row][col]!=1)
			return true;
		return false;
	}
	public static void path(int m[][],int n,int row,int col, int[][] sol,String ans,ArrayList<String>al) {
		if(row==n-1&&col==n-1&&
		m[n-1][n-1]==1) {
			sol[row][col]=1;
		//	System.out.println(ans);
			al.add(ans);
			return ;
		}
		if(isSafe(m,n,row,col,sol)) {
			sol[row][col]=1;
//			sb.append("L");
			path(m,n,row-1,col,sol,ans+"U",al);
			sol[row][col]=0;
		}
		if(isSafe(m,n,row,col,sol)) {
			sol[row][col]=1;
//			sb.append("R");
			path(m,n,row,col+1,sol,ans+"R",al);
			sol[row][col]=0;
		}
		if(isSafe(m,n,row,col,sol)) {
			sol[row][col]=1;
//			sb.append("D");
			path(m,n,row+1,col,sol,ans+"D",al);
			sol[row][col]=0;
		}
		if(isSafe(m,n,row,col,sol)) {
			sol[row][col]=1;
//			sb.append("U");
			path(m,n,row,col-1,sol,ans+"L",al);
			sol[row][col]=0;
		}

		return ;
	}
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
            	ArrayList<String> al=new ArrayList<String>();
    	int sol[][]=new int[n][n];
    	String sb=new String();
    	path(m,n,0,0,sol,sb,al);
    	return al;
    }
}