// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2*N];
            for(int i = 0;i < 2*N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}// } Driver Code Ends


// User function Template for Java
class que{
	int distance;
	int node;
}

class Solution{
    static int minThrow(int N, int arr[]){
        // code here
    	int move[]=new int[30];
    	HashMap<Integer,Integer> hm=new HashMap<>();
    	for(int i=0;i<arr.length-1;i=i+2) {
    		hm.put(arr[i]-1, arr[i+1]-1);
    		move[arr[i]-1]=-1;
    	}
    	boolean visited[]=new boolean[30];
    	ArrayDeque<que> stack=new ArrayDeque<que>();
    	que cnode=new que();
    	cnode.node=0;
    	cnode.distance=0;
    	while(stack.size()!=0) {
    		 cnode=stack.poll();
    		if(cnode.node==29)
    			break;
    		
    		for(int j=cnode.node+1;j<=cnode.node+6;j++) {
    			if(!visited[j]) {
        			que adjNode=new que();
        			adjNode.distance=cnode.distance+1;
        			visited[j]=true;
        			if(move[j]==-1) {
        				adjNode.node=hm.get(j);
        			}
        			else
        				adjNode.node=j;
        			stack.add(adjNode);
    			}

    		}
    	} 	
    	return cnode.distance;
    }
}