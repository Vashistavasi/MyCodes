// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String S = sc.nextLine().trim();
            Solution ob = new Solution();
            if(ob.valid(S))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean valid(String s) 
    { 
        // code here
    	
    	ArrayDeque<Character> stack=new ArrayDeque<Character>();
    	
    	for(int i=0;i<s.length();i++) {
    		char c=s.charAt(i);
    		if(c=='{' ||c=='('||c=='[') {
    			stack.push(c);
    		}
    		char pop;
    		if(stack.isEmpty())
    			return false;
    		switch(c) {
    		case ')':  
    		 pop=stack.pop();
    			if(pop=='{'||pop=='[')
    				return false;
    			break;
    		case '}':  
    			 pop=stack.pop();
    			if(pop=='('||pop=='[')
    				return false;
    			break;
    		case ']':  
    			 pop=stack.pop();
    			if(pop=='{'||pop=='(')
    				return false;
    			break;
    			
    			
    		}
    		
    	}
    	
    	return stack.isEmpty();
    }
} 