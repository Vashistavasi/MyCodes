//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



class Node{
    int x;
    int y;
    int distance;
    Node(int x,int y, int distance){
        this.x=x;
        this.y=y;
        this.distance=distance;
    }
    Node(){
        
    }
}
class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
	public static boolean isValid(int i,int j,int n){
	    if(i<n && j<n && i>-1 && j>-1)
	    return true;
	    else
	    return false;
	}
	    
	public static int[]getMinPath(boolean[][] pathSet,int [][]mindis){
	    int ans[]=new int[2];
	    int n=mindis.length;
	    int min=Integer.MAX_VALUE;
	    for(int i=0;i<n;i++){
	        for (int j=0;j<n;j++){
	            if(!pathSet[i][j] && mindis[i][j]<=min){
	                min=mindis[i][j];
	                ans[0]=i;
	                ans[1]=j;
	            }
	        }
	    }
	    return ans;
	}
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n=grid.length;
        boolean pathSet[][]=new boolean[n][n];
        int mindis[][]=new int[n][n];
        for(int [] row: mindis)
        Arrays.fill(row,Integer.MAX_VALUE);
        mindis[0][0]=0;
        int xd[]={1,-1,0,0};
        int yd[]={0,0,-1,1};
        PriorityQueue<Node> pq=new PriorityQueue<Node>(n*n,new Comparator<Node>(){
            public int compare (Node n1,Node n2){
                return n1.distance-n2.distance;
            }
        });
        
        
        pq.add(new Node(0,0,mindis[0][0]));
        while(!pq.isEmpty()){
               Node curr=pq.poll();
               //int res[]=getMinPath(pathSet,mindis);
               pathSet[curr.x][curr.y]=true;
               if(curr.x==n-1 && curr.y==n-1){
                   return mindis[n-1][n-1]+grid[0][0];
               }
               int curdis=mindis[curr.x][curr.y];
               for(int k=0;k<4;k++){
                   int x=curr.x+xd[k];
                   int y=curr.y+yd[k];
                   if(isValid(x,y,n) 
                   && curdis!=Integer.MAX_VALUE && mindis[x][y]>=curdis+grid[x][y] ){
                       if(mindis[x][y]!=Integer.MAX_VALUE){
                           Node rm=new Node(x,y,mindis[x][y]);
                           pq.remove(rm);
                       }
                     mindis[x][y]=curdis+grid[x][y];
                     pq.add(new Node(x,y,mindis[x][y]));
                   }
               }
               
            }
        
        return mindis[n-1][n-1]+grid[0][0];
    }
}