// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
       // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        while(t-- > 0) {
       
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(t);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
   
	public static void findAns(int n, ArrayList<ArrayList<Integer>> ans,int row,ArrayList<Integer> temp,
boolean[] leftDiagonal,boolean[]rightDiagonal,boolean[]col) {
		
		if(row==n)
		{
			ans.add(new ArrayList<>(temp));
			return;
		}
		
		for(int cols=0;cols<n;cols++) {
			
			if(col[cols]||leftDiagonal[row+cols]||rightDiagonal[row-cols+n]) {
				continue;
			}
			
			temp.set(cols,row+1);
			col[cols]=leftDiagonal[row+cols]=rightDiagonal[row-cols+n]=true;
			findAns(n,ans,row+1,temp,leftDiagonal,rightDiagonal,col);
			col[cols]=leftDiagonal[row+cols]=rightDiagonal[row-cols+n]=false;
			
			
			
			
		}
		
		
	}
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
    	boolean []leftDiagonal=new boolean[2*n];
    	boolean [] rightDiagonal=new boolean[2*n];
    	boolean [] col=new boolean[n];
    	ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> temp=new ArrayList<Integer> ();
    	for(int i=0;i<n;i++)temp.add(0);
    	findAns(n, ans, 0, temp,leftDiagonal,rightDiagonal,col);
    	Collections.sort(ans,new Comparator<ArrayList<Integer>>() {

			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				// TODO Auto-generated method stub
				for(int i=0;i<o1.size();i++) {
					 if(o1.get(i)!=o2.get(i)) {
						 return o1.get(i)-o2.get(i);
					 }
				}
				return 0;
			}
		});
    	return ans;
    }
}