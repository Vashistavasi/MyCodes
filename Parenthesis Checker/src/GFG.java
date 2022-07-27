//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
     ArrayDeque<Character> st=new ArrayDeque<Character>();
     if(x==null)
     return true;
     if(x.length()==1)
     return false;
     st.push(x.charAt(0));
     char c=st.peek();
            if(c=='}' || c==']' || c==')')
            return false;
            
        for(int i=1;i<x.length();i++){
            char cur=x.charAt(i);
            if(cur=='{'|| cur=='['|| cur=='('){
            st.push(cur);
            continue;
            }
            else{
                if(st.isEmpty())
                    return false;
                     c=st.pop();
                switch(cur){
                case '}':{
                        
                        if(c=='['||c=='(')
                        return false;
                    
                }break;
                case ')':{
                        if(c=='['||c=='{')
                        return false;
                    
                }break;
                                case ']':{
                        if(c=='{'|| c=='(')
                        return false;
                    
                }break;
            }
            }

            
        }
        if(!st.isEmpty())
        return false;
        return true;
    }
}
