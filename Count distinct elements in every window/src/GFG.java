// { Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
{
    public static void main(String args[])
    {
            Solution g = new Solution();
            
            int a[]= {1, 2 ,1 ,3 ,4 ,2 ,3 };
            int n=a.length;
            int k=4;
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
       
    }
}// } Driver Code Ends


class Solution
{
     ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here 
        ArrayList<Integer> ans=new ArrayList<Integer>();
        HashSet<Integer> hs=new HashSet<Integer>();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        for(int j=0;j<k;j++){
             temp.add(A[j]); 
             hs.add(A[j]);
        }
        ans.add(hs.size());
        for(int i=k;i<n;i++){
           temp.remove(0);
           temp.add(A[i]);
            ans.add(findSize(temp));
        }
        return ans;
    }

	public  Integer findSize(ArrayList<Integer> temp) {
		// TODO Auto-generated method stub
		HashSet<Integer> hs=new HashSet<>(temp);
		return hs.size();
	}
}

