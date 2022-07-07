// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
       
         {
           
            
            int N = 17;
            int L = 2;
            int R = 3;

            Solution ob = new Solution();
            System.out.println(ob.toggleBits(N,L,R));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int toggleBits(int N , int L , int R) {
        // code here
        ArrayList<Integer> al=new ArrayList<Integer>();
        while(N!=0) {
        	al.add(N%2);
        	N=N>>1;
        }
        
        int value=1;
        int answer=0;
       for(int i=L-1;i<=R-1;i++) {
    	   if(al.get(i)==1)
    		   al.set(i, 0);
    	   else
    		   al.set(i,1);
       }
       
       for(int i=0;i<al.size();i++) {
    	   if(al.get(i)==1)
    		   answer+=value;
    	   value*=2;
       }
       
       
       
        return answer;
        
        
    }
};