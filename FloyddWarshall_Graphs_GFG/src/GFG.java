// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
 public void shortest_distance(int[][] matrix)
    {
        // Code here 
        int rows=matrix.length;
        int columns=matrix[0].length;
        int distance[][]=new int[rows][rows];
     
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){

                distance[i][j]=matrix[i][j];
            }
        }
        for(int k=0;k<rows;k++){
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                	if(distance[i][j]==-1&& distance[i][k]!=-1&&distance[k][j]!=-1)
                		distance[i][j]=distance[i][k]+distance[k][j];	
                 if(distance[i][k]!=-1&&distance[k][j]!=-1 && distance[i][j]!=-1&&distance[i][j]>distance[i][k]+distance[k][j]){
                        distance[i][j]=distance[i][k]+distance[k][j];
                    }
                }
            }
        }
          for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
              
               matrix[i][j] =distance[i][j];
            }
        }
    }
}