// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution {
       public ArrayList<String> find_permutation(String S) {
        // Code here
    	int l=0,r=S.length();
    	ArrayList<String> al=new ArrayList<String>();
    	permute(l,r,S,al);
    	
    	Collections.sort(al);
    	return al;
    }
    public void permute(int l,int r, String s,ArrayList<String> al) {
    	if(l==r&&!al.contains(s))
    		al.add(s);
    	for(int i=l;i<r;i++) {
    		s=swap(l,i,s);
    		permute(l+1,r,s,al);
    		swap(l,i,s);
    	}
    }
    public String swap(int from,int to, String s) {
    	char c[]=s.toCharArray();
    	char temp=s.charAt(from);
    	c[from]=c[to];
    	c[to]=temp;
    	return new String(c);
    }
}