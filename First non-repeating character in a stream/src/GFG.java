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
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
           	HashMap<Character,Integer>hs=new HashMap<Character,Integer>();
    	ArrayDeque<Character>que=new ArrayDeque<Character>();
    	StringBuilder sb=new StringBuilder();
//    	sb.append(A.charAt(0));
//    	que.addFirst(A.charAt(0));
//    	hs.add(A.charAt(0));
    	for(int i=0;i<A.length();i++) {
    		char ch=A.charAt(i);
    		if(hs.containsKey(ch)) {
    		    hs.put(ch,hs.get(ch)+1);
    		    if(que.isEmpty()){
    		           sb.append('#');
    		    }
    		 else{
    			Character c=que.getFirst();
    			if(c==null) {
    				sb.append('#');
    			}
    			if(c==ch) {
    				que.poll();
    				if(que.isEmpty())
    					sb.append('#');
    				else{
    				    while(!que.isEmpty()&&hs.get(que.getFirst())>1)
    				    que.poll();
    				    if(que.isEmpty())
    				    sb.append('#');
    				    else
    				    sb.append(que.getFirst());
    				}
    					
    			}
    			else{
    			      while(!que.isEmpty()&&hs.get(que.getFirst())>1)
    				    que.poll();
    				    sb.append(que.getFirst());
    			}
    		
    		 }
    			
    		}
    		else {
    			hs.put(ch,1);
    			que.add(ch);
    			 while(!que.isEmpty()&&hs.get(que.getFirst())>1)
    				    que.poll();
    			sb.append(que.getFirst());
    			
    		}
	
    	}
        return new String(sb);
    }
}