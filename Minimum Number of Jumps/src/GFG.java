//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        	int steps=arr[0];
        	if(arr.length==1)
        	return 0;
    	int jumps=1;
    	if(steps==0)
    		return -1;
    	int possibleReach=arr[0];
    	for(int i=1;i<arr.length;i++) {
    		if(steps==0)
    		{
    			jumps++;
    			steps=possibleReach-i+1;
    			//System.out.println(" Updated steps to "+ steps+ " where i is "+ i );
    		}
    		if(steps<=0)
    			return -1;
    		steps--;
    		possibleReach=Math.max(possibleReach,i+arr[i]);
    		//System.out.println(" possible reach is "+ possibleReach);
    		
    		
    		
    	}
    	return jumps;
    }
}