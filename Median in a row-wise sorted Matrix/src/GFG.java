// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            String line[] = read.readLine().trim().split("\\s+");
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[c++]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static ArrayList<Integer> merge(ArrayList<Integer> al, int matrix[][],int row,int colSize){
        ArrayList<Integer> ans=new ArrayList<Integer>();
        int i=0,j=0;
        int k=0;
        while(k<colSize+al.size()){
            if(i<al.size()&& j<colSize && al.get(i)<matrix[row][j]){
                ans.add(al.get(i));
                i++;
            }
            else if(i<al.size()&&  j<colSize && al.get(i)>=matrix[row][j]){
                ans.add(matrix[row][j]);
                j++;
            }
            else if(j>=colSize){
                while(i<al.size()){
                    ans.add(al.get(i));
                    i++;
                }
            }
            else{
                while(j<colSize){
                  ans.add(matrix[row][j]);
                j++;  
                }
            }
            k++;
        }
        return ans;
        
    }
    int median(int matrix[][], int r, int c) {
        // code here        
        ArrayList<Integer> ans=new ArrayList<Integer>();
        
        
        for(int i=0;i<r;i++){
            ans=merge(ans,matrix,i,c);
        }
        return ans.get((((r*c)+1)/2)-1);
        
        
        
        
        
    }
}