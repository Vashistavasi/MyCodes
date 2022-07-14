// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution {
   public static void updateHm(int i,HashMap<Integer, Integer> hm) {
		 if(!hm.containsKey(i)) {
			 hm.put(i, 1);
		 }
		 else {
			 hm.put(i, hm.get(i)+1);
		 }
	}
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
    	HashMap<Integer, Integer>hm=new HashMap<Integer, Integer>();
    	ArrayDeque<Integer> que=new ArrayDeque<Integer>();
    	int max=Integer.MIN_VALUE; 
    	ArrayList<Integer> ans=new ArrayList<Integer>();
    	for(int i=0;i<k&&i<n;i++) {
    		 max=Math.max(max, arr[i]);
    		 updateHm(arr[i],hm);
    		 que.add(arr[i]);
    	 }
    	ans.add(max);
    	     for(int i=k;i<n;i++) {
    	         
    	         
    	    	 if(arr[i]>max) {
    	    		int removed= que.poll();
    	    		 que.add(arr[i]);
    	    		 max=arr[i];
    	    		 ans.add(max);
    	    		 updateHm(arr[i],hm);
    	    		 hm.put(removed, hm.get(removed)-1);
    	    	 }
    	    	 
    	    	 
    	    	 
    	    	 
    	    	 else {
    	    		int removed=que.poll();
    	    		
    	    		if(removed==max && arr[i]<max) {
    	    			int count=hm.get(max);
    	    			if(count>1)
    	    			{
    	      	    		 que.add(arr[i]);
            	    		 ans.add(max);
            	    		 //updateHm(arr[i],hm);
            	    		 //hm.put(removed, hm.get(removed)-1);
    	    			}
    	    			else {
    	    			    hm.put(removed, hm.get(removed)-1);
    	    			    que.add(arr[i]);
    	    	           updateHm(arr[i], hm);
    	    				int calMax=Integer.MIN_VALUE;
    	    				for(Integer f:hm.keySet()) {
    	    					if(hm.get(f)>0) {
    	    						calMax=Math.max(f, calMax);
    	    					}}
    	    	max=calMax;
    	    	ans.add(max);
    	   // 	que.add(arr[i]);
    	   // 	updateHm(arr[i], hm);

    	    			}
    	    		 }
    	    		else{
        	    		 que.add(arr[i]);
        	    		 ans.add(max);
        	    		 updateHm(arr[i], hm);
        	    		 if(hm.containsKey(removed))
        	    		 hm.put(removed,hm.get(removed)-1);
    	    		 }
    	    	 }
    	     }
    	     return ans;
}
}