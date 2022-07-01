// { Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) 
    {
        // code here 
          ArrayList<Integer> al=new ArrayList<Integer> ();
        int i=0,j=0;
        boolean visited[][]=new boolean[r][c];
        int count=r*c;
      
        int check=0;
        while(check<count){
           
            while(j<c&&!visited[i][j]){
            al.add(matrix[i][j]);
            visited[i][j]=true;
            j++;
          //  System.out.println(i+" " + j+ " increment j");
            check++;
            }
            j--;
            i++;
            while(i<r &&!visited[i][j]){
            al.add(matrix[i][j]);
            visited[i][j]=true;
            i++;
          // System.out.println(i+" " + j+ " increment i");
           check++;
            }
            i--;
            j--;
             while(j>-1&&!visited[i][j]){
            al.add(matrix[i][j]);
            visited[i][j]=true;
            j--;
         //   System.out.println(i+" " + j+ " decrement j");
            check++;
            }
            j++;
            i--;
             while(i>-1&&!visited[i][j]){
            al.add(matrix[i][j]);
            visited[i][j]=true;
            i--;
            check++;
           
       // System.out.println(i+" " + j+ " decrement j");
            }
             j++;
            i=i+1;
            
        }
       
    
             return al;
        
    }
}
