// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            String arr[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(arr[i]);
            int x = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.isSuperSimilar(n, m, mat, x));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    public static void rotate(int row,int column, int mat[][],int x){
        if(row%2==0)
        rotateLeft(row, column,  mat, x);
        else
      rotateRight(row, column,  mat, x);
    }
    public static void rotateLeft(int row,int column,int mat[][],int x){
        // ArrayList<Integer> al=new ArrayList<Integer>();
        int []arr=new int[column];
        for(int i=0;i<column;i++){
            int k=(column-(x%column)+i)%column;
            arr[k]=mat[row][i];
        }
        for(int i=0;i<column;i++){
            mat[row][i]=arr[i];
        }
    } 
    
        public static void rotateRight(int row,int column,int mat[][],int x){
        // ArrayList<Integer> al=new ArrayList<Integer>();
        int []arr=new int[column];
        for(int i=0;i<column;i++){
            int k=(x+i)%column;
            arr[k]=mat[row][i];
        }
        for(int i=0;i<column;i++){
            mat[row][i]=arr[i];
        }
    } 
    
    static int isSuperSimilar(int n, int m, int mat[][], int x)
    {
        // code here
        int ans[][]=new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=mat[i][j];
            }
        }
        for(int i=0;i<n;i++){
            rotate(i,m,ans,x);
        }
        int res=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(ans[i][j]!=mat[i][j]){
               res=0;
               return res;
               }
               
            }
        }
        
        return res;

    }
}