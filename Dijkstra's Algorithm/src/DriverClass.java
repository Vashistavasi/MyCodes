// { Driver Code Starts
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
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj =
            		new ArrayList<ArrayList<ArrayList<Integer>>>();
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
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
	 static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
	    {
	        // Write your code here
	    	
	    	return shortestPath(V, adj, S);
	    }
	    public static int minDistance(int dist[],boolean shortestPathSet[]) {
	    	int min=Integer.MAX_VALUE,minIndex=-1;
	    	for(int node=0;node<dist.length;node++) {
	    		if(!shortestPathSet[node]&&dist[node]<=min) {
	    			min=dist[node];
	    			minIndex=node;
	    		}
	    	}
	    	return minIndex;
	    	
	    }
	    public static int[] shortestPath(int V/*size*/, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S/*start*/) {
	    	int dist[]=new int[V];
	    	boolean shortestPathSet[]=new boolean[V];
	    	for(int i=0;i<V;i++) {
	    		dist[i]=Integer.MAX_VALUE;	
	    	}
	    		
	    	dist[S]=0;
	    	for(int count=0;count<V-1; count++) {
	    		int cnode=minDistance(dist,shortestPathSet);
	    		shortestPathSet[cnode]=true;
	    		Iterator<ArrayList<Integer>> it=adj.get(cnode).listIterator();
	    		while(it.hasNext()) {
	    		 ArrayList<Integer> adjNode=it.next();
	    		 int vertex=adjNode.get(0);
	    		 int weight=adjNode.get(1);
	    			if(!shortestPathSet[vertex] 
	    					&& dist[cnode]!=Integer.MAX_VALUE && dist[cnode]+weight<dist[vertex] ) {
	    				dist[vertex]=dist[cnode]+weight;
	    			}
	    		}
	    		
	    	}
	    	
	    	
	    	return dist;
	    }
}

