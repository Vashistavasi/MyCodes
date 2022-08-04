//{ Driver Code Starts
import java.lang.Math;
import java.util.*;
class UniqueRows{
public static void main(String[] args)
 {  Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int r=sc.nextInt();
			int c=sc.nextInt();
			int[][] a=new int [r][c];
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					a[i][j]=sc.nextInt();
			GfG g=new GfG();
			ArrayList<ArrayList<Integer>> arr = g.uniqueRow(a,r,c);
			for(int i = 0;i<arr.size();i++){
			    ArrayList<Integer> demo = arr.get(i);
			    for(int j = 0;j<demo.size();j++){
			        System.out.print(demo.get(j)+" ");
			    }
			    System.out.print("$");
			}
			System.out.println();
		}
 }
}
// } Driver Code Ends


/*Complete the given function*/
class GfG
{
    public static String convert(int a[][],int row,int col){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<col;i++){
            sb.append(a[row][i]);
        }
        return new String(sb);
    }
    public static ArrayList<Integer> inverseConvert(String s){
        ArrayList<Integer> ans=new ArrayList<Integer> ();
        for(int  i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
            ans.add(1);
            else
            ans.add(0);
        }
        return ans;
    }
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
        //add code here.
        HashSet<String> hs=new HashSet<String>();
        ArrayList<Integer> row=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer> >ans=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<r;i++){
            String curr=convert(a,i,c);
            if(!hs.contains(curr)){
                hs.add(curr);
                ans.add(inverseConvert(curr));
            }
        }
        return ans;
    }
}