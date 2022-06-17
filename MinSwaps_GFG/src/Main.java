// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
  public static void swap(int[]nums,int from, int to) {
		int temp=nums[from];
		nums[from]=nums[to];
		nums[to]=temp;
	}
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
    	HashMap<Integer,Integer> hm=new HashMap<Integer, Integer>();
    	for(int i=0;i<nums.length;i++) {
    		hm.put(nums[i],i);
    	}
    	int ans=0;
    	int temp[]=Arrays.copyOfRange(nums, 0, nums.length);
    	Arrays.sort(temp);
    	for(int i=0;i<nums.length;i++) {
    		
    		if(nums[i]==temp[i]) {
    			continue;
    		}
    		else {
    			int index=hm.get(temp[i]);
    			swap(nums,i,index);
    			hm.put(nums[i],i);
    			hm.put(nums[index],index);
    			ans++;
    		}
    			
    		
    	}    	
    	return ans;
    }
}