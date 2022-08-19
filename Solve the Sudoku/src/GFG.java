// { Driver Code Starts
//Initial Template for Java

import java.sql.Timestamp;
import java.time.Instant;

class GFG
{
    public static void main(String args[])
    {
        
      

        
       
        {
//            int grid[][] ={{3, 0 ,6, 5, 0, 8, 4 ,0, 0},
//            		{5, 2 ,0, 0, 0 ,0, 0 ,0, 0},
//            		{0 ,8 ,7, 0 ,0 ,0, 0 ,3 ,1 },
//            		{0, 0 ,3 ,0 ,1 ,0 ,0 ,8, 0},
//            		{9, 0 ,0 ,8 ,6 ,3, 0 ,0 ,5},
//            		{0 ,5 ,0 ,0 ,9 ,0 ,6, 0, 0},
//            		{1, 3, 0, 0 ,0 ,0 ,2 ,5 ,0},
//            		{0 ,0 ,0 ,0 ,0 ,0, 0,7, 4},
//            		{0 ,0, 5 ,2, 0, 6 ,3 ,0 ,0}};
//    
            		
//        	int grid[][] ={{1, 0 ,5, 0, 0, 0, 2 ,6, 0},
//            		{0, 0 ,0, 0, 0 ,0, 0 ,0, 0},
//            		{0 ,0 ,0, 0 ,0 ,8, 4 ,7 ,0 },
//            		{0, 9 ,0 ,2 ,1 ,0 ,0 ,0, 8},
//            		{0, 1 ,4 ,0 ,8 ,0, 3 ,9 ,0},
//            		{6 ,0 ,0 ,0 ,7 ,3 ,0, 2, 0},
//            		{0, 6, 2, 1 ,0 ,0 ,0 ,0 ,0},
//            		{0 ,0 ,0 ,0 ,0 ,0, 0,0, 0},
//            		{0 ,4, 7 ,0, 0, 0 ,5 ,0 ,6}};
//        	int grid[][] ={{6, 2 ,5, 0, 0, 0, 7 ,4, 0},
//            		{0, 0 ,4, 0, 0 ,0, 0 ,1, 2},
//            		{0 ,0 ,0, 0 ,0 ,4, 0 ,0 ,0 },
//            		{0, 0 ,0 ,4 ,8 ,0 ,9 ,0, 7},
//            		{0, 0 ,0 ,0 ,0 ,0, 0 ,0 ,0},
//            		{4 ,0 ,2 ,0 ,1 ,3 ,0, 0, 0},
//            		{0, 0, 0, 3 ,0 ,0 ,0 ,0 ,0},
//            		{1 ,8 ,0 ,0 ,0 ,0, 6,0, 0},
//            		{0 ,6, 3 ,0, 0, 0 ,4 ,8 ,9}};
//    
        	int grid[][] ={{0, 0 ,0, 1, 7, 0, 2 ,0, 0},
            		{0, 0 ,0, 0, 0 ,5, 0 ,8, 6},
            		{5 ,1 ,0, 0 ,0 ,0, 0 ,4 ,0 },
            		{0, 7 ,0 ,0 ,0 ,1 ,0 ,0, 9},
            		{0, 0 ,0 ,9 ,0 ,3, 0 ,0 ,0},
            		{4 ,0 ,0 ,7 ,0 ,0 ,0, 3, 0},
            		{0, 4, 0, 0 ,0 ,0 ,0 ,2 ,8},
            		{7 ,5 ,0 ,6 ,0 ,0, 0,0, 0},
            		{0 ,0, 9 ,0, 3, 7 ,0 ,0 ,0}};
    
//        	int grid[][] ={{1, 0 ,0, 0},
//    		{0, 0,2, 0},
//    		{0 ,3 ,0, 0 },
//    		{0, 0 ,0 ,0}};
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
	public static boolean isSafe(int grid[][], int row,int col,int num) {
		
		for(int  i=0;i<grid.length;i++) {
			if(grid[row][i]==num||grid[i][col]==num) {
				return false;
			}
		}
		int startRow=(int) (row-(row%(Math.sqrt(grid.length))));
		int startCol=(int) (col-col%Math.sqrt(grid.length));
		for(int i=0;i<Math.sqrt(grid.length);i++) {
			for(int j=0;j<Math.sqrt(grid.length);j++) {
				if(grid[startRow+i][startCol+j]==num)
					return false;
			}
		}
		return true;
		
	}
	public static boolean sudoko(int grid[][],int row,int col) {
		if(row==grid.length-1&&col==grid.length)
			return true;
		if(col==grid.length) {
			row++;
			col=0;
		}
		if(grid[row][col]!=0) {
			return sudoko(grid,row,col+1);
		}
		for(int i=0;i<grid.length;i++) {
			
			if(isSafe(grid, row, col, i+1)) {
				grid[row][col]=i+1;
				
				if(sudoko(grid,row,col+1))
					return true;
		}
			grid[row][col]=0;
		}
		return false;

	}
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
    	  Timestamp instant= Timestamp.from(Instant.now());  
          System.out.println("1. from() method will return "+instant);  
    	return sudoko(grid, 0, 0);
    	
    	
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid.length;j++) {
    			    			System.out.print(grid[i][j]+" ");
			    		}
    	System.out.println();	
    	}
    	  Timestamp instant= Timestamp.from(Instant.now());  
          System.out.println(" return "+instant);  
    }
    
}