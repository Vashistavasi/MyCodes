//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking total count-1 of elements 
		    int n=sc.nextInt();
		    
		    //Declaring and Initializing an ArrayList-1
		    ArrayList<Integer>v1=new ArrayList<>();
		    
		    //adding elements to the ArrayList-1
		    for(int i=0;i<n;i++)
		    {
		        v1.add(sc.nextInt());
		    }
		    
		    //taking total count-2 of elements 
		    int m=sc.nextInt();
		    
		    //Declaring and Initializing an ArrayList-2
		    ArrayList<Integer>v2=new ArrayList<>();
		    
		    //adding elements to the ArrayList-2
		    for(int i=0;i<m;i++)
		    {
		        v2.add(sc.nextInt());
		    }
		    Solution ob = new Solution();
		    //calling the method common_element
		    //and passing ArrayList 1, 2 as arguments
		    //and storing the results in a new ArrayList
		    ArrayList<Integer>ans=ob.common_element(v1, v2);
		    
		    //printing the elements of the new ArrayList
		    for(int i:ans)
		    System.out.print(i+" ");
		    
		    System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static ArrayList<Integer> common_element(ArrayList<Integer>v1, ArrayList<Integer>v2)
    {
        //Your code here
          HashMap<Integer,Integer>hs=new HashMap<Integer,Integer>();
        int size=v1.size();
        for(int i=0;i<size;i++){
            if(!hs.containsKey(v1.get(i)))
            hs.put(v1.get(i),1);
            else
            hs.put(v1.get(i),hs.get(v1.get(i))+1);
        }
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<v2.size();i++){
            if(hs.containsKey(v2.get(i))&&hs.get(v2.get(i))>0){
                ans.add(v2.get(i));
                hs.put(v2.get(i),hs.get(v2.get(i))-1);
            }
        }
       
         Collections.sort(ans);
        return ans;
    }
}