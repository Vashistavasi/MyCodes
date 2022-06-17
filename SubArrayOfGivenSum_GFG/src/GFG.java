// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
    
            
            Solution obj = new Solution();
            int m[]= {1,2,3,7,5};
            int n=m.length;
            int s=12;
            ArrayList<Integer> res = Solution.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        int sum=0;
        for(int i: arr){
            sum+=i;
        }
        int prefix[]=new int[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
      HashSet<Integer> hs=new HashSet<Integer>();
        for(int i=0;i<n;i++){
        	if(prefix[i]-s==0)
        	{
        		al.add(1);
        		al.add(i+1);
        		return al;
        	}
        	else
            hs.add(prefix[i]-s);
        }
        int start=-1;
        int end=-1;
        int value=-1;
        boolean flag=false;
        for(int i=0;i<n;i++)
        {
            if(hs.contains(prefix[i])){
                end=prefix[i]+s;
                value=prefix[i];
                flag=true;
                break;
            }
        }
        if(flag){
             for(int i=0;i<n;i++){
            if(value==prefix[i]){
                start=i+2;
                break;
            }
           
        } for(int i=0;i<n;i++){
            if(end==prefix[i]){
                end=i+1;
                break;
            }
        }
        al.add(start);
        al.add(end);
        }
        else{
            al.add(-1);
        }
       
          return al;
    }
}