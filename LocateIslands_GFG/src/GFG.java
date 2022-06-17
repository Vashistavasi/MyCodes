// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
	 public int numIslands(char[][] grid) {
	    	boolean [][] visited=new boolean[grid[0].length][];
	    	int answer=0;
	    		    	for(int i=0;i<grid.length;i++) {
	    		for(int j=0;j<grid[i].length;j++) {
	    			if(grid[i][j]=='1'&&!visited[i][j]) {
	    				dfs(grid,i,j,visited);
	    				answer++;
	    				
	    			}
	    		}
	    	}
	    	return answer;
	        // Code here
	    }
	    
	    public static boolean isSafe(char[][] grid, int row, int column,boolean [][] visited) {
	    	return ((!visited[row][column])&&(row>=0&&row<grid.length)&&(column>=0&&column<grid[row].length)&&(grid[row][column]=='1'));
	    }
	    public static void dfs(char[][] grid,int row, int column, boolean [][]visited) {
	    	int [] adj_rows= {-1,-1,-1,0,0,1,1,1};
	    	int [] adj_cols= {-1,0,1,-1,1,-1,0,1};
	    	if(isSafe(grid,row,column,visited)) {
	    		visited[row][column]=true;
	    		for(int i=0;i<9;i++) {
	    			dfs(grid, row+adj_rows[i],column+adj_cols[i],visited);
	    		}
	    		
	    	}
	    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}