//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int A[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    A[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(N, M, A);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayDeque<Integer> rotate(int startRow,int startCol,int endRow,int endCol,int [][]Mat){
        ArrayDeque<Integer> que=new ArrayDeque<Integer>();
        int N=Mat[0].length;
        int M=Mat.length;
        for(int i=startCol;i<N;i++){
           que.add(Mat[startRow][i]);
        }
        
        for(int i=startRow+1;i<M;i++){
        que.add(Mat[i][endCol]);    
        }
        for(int i=endCol-1;i>=0;i--){
            que.add(Mat[endRow][i]);
        }
        for(int i=endRow-1;i>0;i--){
            que.add(Mat[i][startCol]);
        }
        return que;
    }
    int[][] rotateMatrix(int m, int n, int mat[][]) {
        // code here
             int row = 0, col = 0;
        int prev, curr;
 
        while (row < m && col < n)
        {
     
            if (row + 1 == m || col + 1 == n)
                break;
     
            prev = mat[row + 1][col];
     
            for (int i = col; i < n; i++)
            {
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;
            for (int i = row; i < m; i++)
            {
                curr = mat[i][n-1];
                mat[i][n-1] = prev;
                prev = curr;
            }
            n--;
     
            if (row < m)
            {
                for (int i = n-1; i >= col; i--)
                {
                    curr = mat[m-1][i];
                    mat[m-1][i] = prev;
                    prev = curr;
                }
            }
            m--;
            if (col < n)
            {
                for (int i = m-1; i >= row; i--)
                {
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;
        
    }
  return mat;  
}}