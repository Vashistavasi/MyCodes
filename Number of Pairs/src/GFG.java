//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main 
{
    	public static void main (String[] args) throws Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int g = 0;g < t;g++)
        {
            String[] str = (br.readLine()).trim().split(" ");
            int M = Integer.parseInt(str[0]);
            int N = Integer.parseInt(str[1]);
            
            int[] x = new int[M];
            str = (br.readLine()).trim().split(" ");
            for(int i = 0;i< M;i++)
                x[i] = Integer.parseInt(str[i]);
                
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[N];
            for(int i = 0;i< N;i++)
            {
                y[i] = Integer.parseInt(str[i]);
                
            }
            System.out.println(new Solution().countPairs(x, y, M, N));
           
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    
    
    
    
        public static int findIndex(int x[],int []y, int index){
        int k=0;
        for(int j=0;j<y.length;j++){
            if(x[index]>=y[j])
            k++;
            else break;
        }
        //int i=Arrays.binarySearch(y,x[index]);
        return k;
    }
    
    
    
    
    
    
    
    static long countPairs(int x[], int y[], int M, int N)
    {
        
         
        //your code here
        //Arrays.sort(x);
        Arrays.sort(y);
       // System.out.println(Arrays.toString(x)+" "+ Arrays.toString(y));
        int[]exceptions=new int[5];
        for(int i=0;i<y.length;i++){
            if(y[i]<5)
            exceptions[y[i]]++;
        }
        int ans=0;
        long finalAns=0;
        for(int i=0;i<x.length;i++){
           // System.out.println(finalAns+" starting loop ");
            int count;
            if(x[i]==1){
             finalAns+=exceptions[0];   
             continue;
            }
             
             else if(x[i]==0){
                 continue;
             }
        
             else{
                 //System.out.println(" In else ");
                  int idx = Arrays.binarySearch(y,x[i]);
        if (idx < 0) {
            idx = Math.abs(idx + 1);
        }
        else {
            while (idx < y.length&& y[idx] == x[i]) {
                idx++;
            }
            
        }
                 count=idx;
                 
                 ans=y.length-count;
                // System.out.println(count);
             finalAns+=ans;
             //System.out.println(finalAns+ " first ");
             finalAns+=exceptions[0]+exceptions[1];
             if(x[i]==2)
             finalAns-=(exceptions[3]+exceptions[4]);
             if(x[i]==3)
             finalAns+=exceptions[2];
            //System.out.println(finalAns+" second");
             }
             
        }   
        return finalAns;
    }
    } 
   