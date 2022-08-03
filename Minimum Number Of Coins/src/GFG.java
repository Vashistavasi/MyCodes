//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
public static int highest(int N){
    int den[]= { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
    int start=0;
    if(N>=50)
    start=5;
    int i=start;
    for(i=start;i<10;i++){
        if(N-den[i]<0)
        break;
    }
     return i-1;
}     
    static List<Integer> minPartition(int N)
    {
        // code here
        ArrayList<Integer>ans=new ArrayList<Integer>();
        int  temp=N;
        int den[]= { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        //System.out.println(den[highest(21)]);
        while(temp>0){
            int sub=highest(temp);
            if(sub==-1)
            break;
            ans.add(den[sub]);
            temp=temp-den[sub];
            if(temp==0)
            break;
        }
   return ans;
    }
}