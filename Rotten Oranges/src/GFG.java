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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    
    	public static boolean isValid(int x, int y, int n, int m) {
		return (x<n&&y<m&&x>=0&&y>=0);
	}
	public static boolean findOnes(int[][]grid,int n, int m) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==1)
					return true;
			}
		}
		return false;
	}
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n=grid.length;
    	int m=grid[0].length;
    	int adjX[]= {0,0,-1,1};
    	int adjY[]= {1,-1,0,0};
    	for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
			    if(grid[i][j]==1){
			    boolean alone[]=new boolean[4]; 
				for(int k=0;k<4;k++) {
					if(isValid(i+adjX[k],j+adjY[k],n,m))
					{
						if(grid[i+adjX[k]][j+adjY[k]]==0)
							alone[k]=true;
					}
					else {
						alone[k]=true;
					}
				
			}
				boolean flag=true;
				for(boolean b:alone)
					flag=flag&b;
				if(flag)
					return -1;
			}}}
		
    	int count =0;
    	boolean checkOnesFlag=findOnes(grid, n, m);
    	while(checkOnesFlag) {
    	    boolean visited[][]=new boolean[n][m];
    		for(int i=0;i<n;i++) {
    			for(int j=0;j<m;j++) {
    				if(!visited[i][j]) {
    				visited[i][j]=true;
    				if(grid[i][j]==2) {
    					for(int k=0;k<4;k++) {
    						if(isValid(i+adjX[k],j+adjY[k],n,m)&&grid[i+adjX[k]][j+adjY[k]]==1)
    						{
    							grid[i+adjX[k]][j+adjY[k]]=2;
    							visited[i+adjX[k]][j+adjY[k]]=true;
    						}
    					}
    					
    				}
    				else
    					continue;
    				
    				
    			}
    		}
    			}
    		checkOnesFlag=findOnes(grid, n, m);
    		count++;
    			}
    	return count;
    }
}