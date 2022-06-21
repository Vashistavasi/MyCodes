// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public static void topologicalSort(int node,boolean visited[],ArrayList<ArrayList<Integer>> graph,
			ArrayDeque<Integer> stack) {
		visited[node]=true;
		Iterator<Integer> it=graph.get(node).listIterator();
		while(it.hasNext()) {
		    
			int cnode=it.next();
			if(!visited[cnode])
			topologicalSort(cnode,visited,graph,stack);
		}
		stack.push(node);
		
	}
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
    	
    	ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
    	for(int i=0;i<K;i++){
    	    graph.add(i,new ArrayList<Integer>());
    	}
    	for(int i=0;i<N-1;i++) {
    		
    		String firstString=dict[i];
    		String secondString=dict[i+1];
    		for(int j=0;j<(Math.min(firstString.length(), secondString.length()));j++) {
    			if(firstString.charAt(j)!=secondString.charAt(j)) {
    				graph.get(firstString.charAt(j)-'a').add(secondString.charAt(j)-'a');
    				break;
    			}
    		}
    	}
    	ArrayDeque<Integer> stack=new ArrayDeque<Integer> ();
    	boolean visited[]=new boolean[K];
    	 for (int i = 0; i < K; i++){
    	    if(!visited[i]){
    	        topologicalSort(i,visited,graph,stack);
    	    } 
    	 }

    	StringBuilder sb=new StringBuilder();
    	while(!stack.isEmpty())
    		sb.append((char)('a'+ stack.pop()));
    		//System.out.println(new String(sb));
    	return new String(sb);
    	
       
    }
}