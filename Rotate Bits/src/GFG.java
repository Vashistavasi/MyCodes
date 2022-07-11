// { Driver Code Starts
//Initial Template for Java

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
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    
  ArrayList<Integer> rotate(int N, int D)
    {
        // your code here
        D=D%16;
        int bits[]=new int[16];
        int index=15;
        int temp=N;
        while(temp!=0){
            bits[index]=temp%2;
            temp=temp/2;
            index--;
        }
        int ansL=0;
        int ansR=0;
       int value=1;
        int bitsR[]=new int[16];
        int bitsL[]=new int[16];
        for(int i=15;i>=0;i--){
            bitsL[i]=bits[(i+D)%16];
            bitsR[i]=bits[(16+i-D)%16];
        }
        for(int i=15;i>=0;i--){
           ansL+=value*bitsL[i];
           ansR+=value*bitsR[i];
           value*=2;
        }
// for(int i: bits)
// {
//     System.out.print(i+" ");
    
// }


//     System.out.println();
 
//     for(int i: bitsL)
//     {
//         System.out.print(i+" ");
        
//     }


//         System.out.println();
    
//         for(int i: bitsR)
//         {
//             System.out.print(i+" ");
            
//         }


            // System.out.println();
    ArrayList<Integer> al=new ArrayList<Integer>();
        al.add(ansL);
        al.add(ansR);
        return al;
        
        
        
        
    }
}