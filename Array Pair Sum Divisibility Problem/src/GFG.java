// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
       
            Solution ob = new Solution();
            int nums[]= {9,7,5,3};
            int k=12;
         int nums1[] = {  12, 11 ,12, 4, 2 ,3 ,10 ,9};
            
            int k1=8;
            boolean ans = ob.canPair(nums1, k1);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }

// } Driver Code Ends


// User function Template for Java

class Solution {
      public boolean canPair(int[] nums, int k) {
        // Code here
 	
    	if(nums.length%2==1) {
    		return false;
    	}
    	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++) {
    		int rem=((nums[i]%k)+k)%k;
    		if(!hm.containsKey(rem)) {
    			hm.put(rem, 0);
    		}
    	
    			hm.put(rem, hm.get(rem)+1);
    		
    	}
    	boolean ans=true;
    	for(int i=0;i<nums.length;i++) {
    		int rem=((nums[i]%k)+k)%k;
    		
    		int freq=hm.get(rem);
    		//System.out.println(rem+" "+ hm.get(rem));
    		if(rem*2==k) {
    			if(freq%2==1) {
    				ans=false;
    				return ans;
    			}
    		}
    			else if(rem==0) {
    				if(freq%2==1) {
    					ans=false;
    					return ans;
    				}
    			}
    			else {
    				if(hm.get(rem)!=hm.get(k-rem)) {
    					ans=false;
                        return ans;
    				}}}
    		return ans;
    			
        
        
        
//     	boolean[] visited=new boolean[nums.length];
//     	if(nums.length%2==1)
//     	return false;
//     	int sum=0;
//     	for(int i:nums)
//     	sum+=i;
//     	if(sum%k!=0)
//     	return false;
   
//     	for(int i=0;i<nums.length;i++) {
//     	    if(!visited[i]) 
//     		if(findPair(nums,i,visited,k)) {
//     		return false;	
//     		}
//     	}
//         return true;
//     }

// 	private boolean findPair(int[] nums, int i, boolean[] visited,int k) {
// 		boolean flag=true;
// 		visited[i]=true;
// 		for(int j=0;j<nums.length;j++) {
// 			if(!visited[j]) {
// 				if(((nums[j]%k)+(nums[i]%k))%k==0) {
// 					visited[j]=true;
// 					flag=false;
// 					return flag;
// 				}
// 			}
		
// 		}
// 		return flag;
	}
}