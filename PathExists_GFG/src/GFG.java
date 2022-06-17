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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}// } Driver Code Ends

class Point{
	int x;
	int y;
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
}


class Solution
{
    //Function to find whether a path exists from the source to destination.
	public static int[] findSource(int [][] grid){
		int [] ans=new int[2];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j]==1)
				{
					ans[0]=i;
					ans[1]=j;
				}
			}
		}
		return ans;
	}
	public static boolean areValid(int row, int column, int grid[][]) {
		int rows=grid.length;
		int columns=grid[row].length;
		
		return (row>=0&&column>=0&&row<rows&&column<columns);
	}
	public static boolean Bfs(int[][]grid,int x,int y,boolean visited[][]) {
		visited[x][y]=true;
				ArrayDeque<Point> queue=new ArrayDeque<Point>();
		queue.add(new Point (x,y));

		while(queue.isEmpty()==false) {
			Point cPoint=queue.poll();
			int []adjX= {-1,1,0,0};
			int []adjY= {0,0,-1,1};
			for(int i=0;i<4;i++) {
				int adjCpointX=cPoint.x+adjX[i];
				int adjCpointY=cPoint.y+adjY[i];
				if(areValid(adjCpointX,adjCpointY,grid)&&!visited[adjCpointX][adjCpointY]&&grid[adjCpointX][adjCpointY]==3) {
					visited[adjCpointX][adjCpointY]=true;
					queue.add(new Point(adjCpointX,adjCpointY));
				}
				if(areValid(adjCpointX,adjCpointY,grid)&&!visited[adjCpointX][adjCpointY]&&grid[adjCpointX][adjCpointY]==2)
					return true;
			}
		}
		
		return false;
	}
    public boolean is_Possible(int[][] grid)
    {
        // Code here
    	int[]source=findSource(grid);
		int x=source[0];
		int y=source[1];
		boolean visited[][]=new boolean[grid.length][grid[x].length];
           	return Bfs(grid, x, y, visited);
    }
}