// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.rremove(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
   
public String remove(String s) {
		if(s.length()==0)
			return "";
	 ArrayDeque <Character> stack=new ArrayDeque<Character>();
	 stack.add(s.charAt(0));
	 StringBuffer sb=new StringBuffer();
	 boolean temp=false;
		for(int i=1;i<s.length();i++) {
		
			if(stack.peekLast()==s.charAt(i)) {
				if(i==s.length()-1)
				{
					stack.pollLast();
					temp=false;
					break;
				}
				temp=true;
				continue;
			}
			else {
				if(temp) {
					stack.pollLast();
					stack.add(s.charAt(i));
					temp=false;
				}
				else
					stack.add(s.charAt(i));
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.poll());
		}
		return new String(sb);
	}
	
	
    String rremove(String s) {
        // code here
    	int size=s.length();
    	int currSize=s.length();
    	 do{
    		 size=s.length();
    		s=remove(s);
    		currSize=s.length();
    	}while(size!=currSize);
    	return s;
    	
    }
}