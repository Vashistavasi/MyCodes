// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
    	  ArrayList<ArrayList<Integer>> g=new ArrayList<ArrayList<Integer>> ();
    	  for(int i=0;i<5;i++) {
    		  g.add(i,new ArrayList<Integer>());
    	  }
    	  g.get(1).add(0);
    	  g.get(0).add(2);
    	  g.get(2).add(1);
    	  g.get(0).add(3);
    	  g.get(3).add(4);
        
    
          System.out.println("Following are strongly connected components "+
                             "in given graph ");
          Solution.mainFunction(g);
    }
    }
        

// } Driver Code Ends


//User function Template for Java


class Solution
{

 
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
    	System.out.println(mainFunction(adj));
    	return mainFunction(adj);
    	
    }
    public static void Dfs(int v, boolean visited[],ArrayList<
    		ArrayList<Integer>>adj) {
    	visited[v]=true;
    	System.out.print(v+" ");
    	Iterator<Integer> it=adj.get(v).listIterator();
    	while(it.hasNext()) {
    		int cnode=it.next();
    		if(!visited[cnode]) {
    			Dfs(cnode,visited,adj);
    		}
    	}
    }
    public static ArrayList<ArrayList<Integer>> getTranspose(
    		ArrayList<ArrayList<Integer>> adj){
    	ArrayList<ArrayList<Integer>> transpose=
    			new ArrayList<ArrayList<Integer>>();
    	 for(int i =0; i < adj.size(); i++)
             transpose.add(i, new ArrayList<Integer>());
    	for(int i=0;i<adj.size();i++) {
    		Iterator<Integer> it=adj.get(i).listIterator();
    		while(it.hasNext()) {
    			transpose.get(it.next()).add(i);
    		}
    	}
    	return transpose;
    }
   public static void fillOrder(int v,
    boolean visited[], Stack<Integer> stack,ArrayList<ArrayList<Integer>> adj) {
    	visited[v]=true;
    	Iterator<Integer> it= adj.get(v).listIterator();
    	while(it.hasNext()) {
    		int cnode=it.next();
    		if(!visited[cnode])
    			fillOrder(cnode,visited,stack,adj);
    	}
    	stack.push(v);
    }
    
    public static int mainFunction(ArrayList<ArrayList<Integer>> adj) {
    	int ans=0;
    	Stack stack=new Stack();
    	boolean visited[]=new boolean[adj.size()];
    	
    	for(int i=0;i<adj.size();i++) 
    		if(visited[i]==false)
    			fillOrder(i,visited,stack,adj);
    		ArrayList<ArrayList<Integer>> transpose=getTranspose(adj);
    		for(int i=0;i<visited.length;i++) {
    			visited[i]=false;
    		}
    		while(stack.empty()==false) {
    			int cnode=(int)stack.pop();
    			if(visited[cnode]==false)
    			{
    				Dfs(cnode,visited,transpose);
    				ans++;
    				System.out.println();
    			}
    		}
    		return ans;
    	
    }
}
