// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class GfG { 
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    int[] arr = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++)arr[i] = Integer.parseInt(inputLine[i]);
		    
		    Solution obj = new Solution();
		    System.out.println(obj.firstElementKTime(arr, n, m));
		}
	}
}
// } Driver Code Ends


class Solution
{
    public int firstElementKTime(int[] a, int n, int k) { 
      	
    	HashMap<Integer,Integer[]>hm=new HashMap<Integer,Integer[]>();
    	for(int i=0;i<n;i++) {
    		Integer[] arr=new Integer[2];
    		if(!hm.containsKey(a[i])) {
    			arr[0]=1;
    			arr[1]=i;
    			hm.put(a[i], arr);
    		}else {
    			arr=hm.get(a[i]);
    			arr[0]=arr[0]+1;
    			if(arr[0]==k)
    			arr[1]=i;
    		}
    	}
    	int freq=0;
    	int index=Integer.MAX_VALUE;
    	for(int i=0;i<n;i++) {
    		Integer arr[]=new Integer[2];
    		arr=hm.get(a[i]);
    		if(arr[0]>=k) {
    			if(arr[1]<index)
    			index=arr[1];
    			
    		}
    // 		if(arr[0]==freq) {
    // 			if(arr[1]<index) {
    // 				index=arr[1];
    // 			}
    // 		}
    	
    	}
    	if(index==Integer.MAX_VALUE)
    	return -1;
    	else
    	return a[index];
    	  
    } 
}