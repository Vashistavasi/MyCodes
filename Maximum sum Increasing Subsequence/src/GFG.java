//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
     	int seq[]=new int[size];
    	for(int i=0;i<size;i++)
	seq[i]=a[i];
	for(int i=1;i<size;i++) {
		for(int j=0;j<i;j++) {
			if(a[i]>a[j])
			seq[i]=Math.max(seq[i], seq[j]+a[i]);
		}
	}
	int ans=Integer.MIN_VALUE;
	for(int i:seq) {
		ans=Math.max(ans, i);
	}
	return ans;
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
} 