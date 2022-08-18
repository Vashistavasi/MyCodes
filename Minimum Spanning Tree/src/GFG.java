//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
	public static int minKey(int key[],boolean mstSet[]) {
		int min=Integer.MAX_VALUE;
		int index=-1;
		for(int i=0;i<key.length;i++) {
			if(!mstSet[i] && min>key[i]) {
				min=key[i];
				index=i;
			}
		}
		return index;
	}
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here'
    	int size=adj.size();
    	int parent[]=new int[size];
    	int key[]=new int[size];
    	
    	boolean mstSet[]=new boolean[size];
    	
    	for(int i=0;i<size;i++) {
    		key[i]=Integer.MAX_VALUE;
    		mstSet[i]=false;
    	}
    	key[0]=0;
    	parent[0]=-1;
    	for(int count=0;count<size-1;count++) {
    		int u=minKey(key,mstSet);
    		mstSet[u]=true;
    		Iterator<ArrayList<Integer>> it=adj.get(u).listIterator();
    		
    		while(it.hasNext()) {
    			ArrayList<Integer> node=it.next();
    			int cnode=node.get(0);
    			int weight=node.get(1);
    			if(!mstSet[cnode]&& weight<key[cnode]) {
    				key[cnode]=weight;
    			}
    		}
    	}
    	int sum=0;
    	for(int i:key)
    	sum+=i;
    	return sum;
    }
}
