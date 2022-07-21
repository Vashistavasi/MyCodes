//{ Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
public static int recursiveCall(int n, int[] memory,int price[]) {
		 {
			int ans=0;
			for(int i=1;i<=n;i++) {
				if(memory[n-i]==-1)
				memory[n-i]=sum(n-i,memory,price);
				ans=Math.max(ans, memory[n-i]+price[i-1]);
			}
			return ans;
			
		}
	}
	public static int sum(int n, int []memory,int price[]) {
		if(n<=0)
			return 0;
		else
			return recursiveCall(n,memory,price);
		
	}
	
	
    public int cutRod(int price[], int n) {
    	
    	int memory[]=new int [n+1];
    	Arrays.fill(memory, -1);
    	return sum(n,memory,price);
    	
    	
        //code here
    }

}