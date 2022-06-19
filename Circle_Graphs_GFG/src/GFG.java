// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    String A[] = in.readLine().trim().split(" ");
		    int N = Integer.parseInt(A[0]);
		    A = in.readLine().trim().split(" ");
		    
		    Solution ob = new Solution();
		    System.out.println(ob.isCircle(N, A));
		}
    }
}// } Driver Code Ends


// User function Template for Java
class Solution
{
 
	public static void dfs(boolean visited[], ArrayList<ArrayList<Integer>> graph,Integer node ) {
		visited[node]=true;
		Iterator<Integer> it=graph.get(node).listIterator();
		while(it.hasNext()) {
			int adjNode=it.next();
			if(!visited[adjNode])
				dfs(visited,graph,adjNode);
		}
		
	 	
	}
	
//	
//	static int findIndex(boolean visited[],String a[], char c) {
//		for(int i=0;i<a.length;i++) {
//			if(!visited[i]) {
//				if(a[i].charAt(0)==c)
//					return i;
//			}
//		}
//		return -1;
//	}

		static int nodeCountOut[]=new int[26];
 static int isCircle(int N, String A[])
 {
 		 int nodeCountIn[]=new int[26];
 	ArrayList<ArrayList<Integer>> graph=toGraph(N,A,nodeCountIn);
 	if(!stronglyConnected(graph)) {
 	   // System.out.println("Here sc");
 		return 0;
 	}
//  	for(int i=0;i<26;i++) 
// 	 		{
// 	 		   System.out.println("Here in NodecountIn and Out "+nodeCountIn[i]+" "+ nodeCountOut[i] );
	 		  
	 		    
// 	 		}
 	for(int i=0;i<26;i++) {
 		if(graph.get(i).size()!=nodeCountIn[i]){

 		    return 0;
 		    
 		}
 		
 			
 	}
 	
 	return 1;
     // code here
// 	if(A.length==1) {
// 		if(A[0].charAt(0)==A[0].charAt(A.length-1))
// 			return 1;
// 		else
// 			return 0;
// 	}
// 	boolean visited[]=new boolean[A.length];
// 	int ans=1;
// 	char start=A[0].charAt(0);
// 	visited[0]=true;
// 	int index=findIndex(visited, A, A[0].charAt(A[0].length()-1));
// 	if(index==-1)
// 		return 0;
// 	for(int i=0;i<A.length;i++) {
// 		visited[index]=true;
// 		char last=A[index].charAt(A[index].length()-1);
// 		index=findIndex(visited, A, last);
// 		if(index==-1&&i!=A.length-1)
// 		{
// 			ans=0;
// 			return ans;
// 		}
// 			
// 		if(i==A.length-1) {
// 			if(last!=start) {
// 				ans=0;
//     			return ans;
// 			}
// 				
// 		}
// 	}
// 	
// 	return ans;    	
// }
 }
	private static boolean stronglyConnected(ArrayList<ArrayList<Integer>> graph) {
		// TODO Auto-generated method stub
		boolean visited[]=new boolean[26];
		int i;
		for( i=0;i<26;i++) {
			if(graph.get(i).size()>0)
				break;
		}
		dfs(visited, graph, i);
		for(int j=0;j<26;j++) {
			if(graph.get(j).size()>0 &&!visited[j])
				return false;
		}
		ArrayList<ArrayList<Integer>> transpose=getTranspose(graph);
		boolean visited2[]=new boolean[26];
		int i2;
		for( i2=0;i2<26;i2++) {
			if(transpose.get(i2).size()>0)
				break;
		}
		dfs(visited, transpose, i2);
		for(int j=0;j<26;j++) {
			if(transpose.get(j).size()>0 &&!visited[j])
				return false;
		}
		
		return true;
	}
	private static ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> graph) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> transpose=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<26;i++) {
			transpose.add(i,new ArrayList<Integer>());
		}
		for(int i=0;i<graph.size();i++) {
		    if(graph.get(i).size()>0){
		        	Iterator<Integer> it=graph.get(i).listIterator();
			while(it.hasNext()) {
				int current=it.next();
				transpose.get(current).add(i);
				nodeCountOut[i]++;
			}
		    }
		
		}
		return transpose;
	}
	private static ArrayList<ArrayList<Integer>> toGraph(int n, String[] a, int[] nodeCount) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<26;i++) {
			graph.add(i,new ArrayList<Integer>());
		}
		for(int i=0;i<n;i++) {
			String current=a[i];
			char parent=current.charAt(0);
			char child=current.charAt(current.length()-1);
			graph.get(parent-'a').add(child-'a');
			nodeCount[child-'a']++;
		}
		return graph;
	}}
