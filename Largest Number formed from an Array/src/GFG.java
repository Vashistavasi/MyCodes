// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(arr);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    //public static int commonPrefix(String s1,String s2){
    //     String temp=s1;
    //     if(s1.length()<s2.length())
    // 		    {
    // 		        s1=s2;
    // 		        s2=temp;
    // 		    }
    		    
    //     for(int i=0;i<s1.length();i++){
    //         if(i>s2.length()-1)
    //         return commonPrefix(s1.substring(i,s1.length()),s2);
    //         	int num1=Integer.valueOf(s1.charAt(i));
    // 				int num2=Integer.valueOf(s2.charAt(i));
    // 				//	System.out.println(" Strings Inside"+ s1+" "+s2+ " sub "+ (num1-num2));
    // 				if(num1>num2)
    // 					return -1;
    // 				if(num1<num2)
    // 					return 1;
    //     }
    //     return 0;
    // }
    // public static int m(String s1,String s2){
    //      String temp=s1;
    // 		    if(s1.length()<s2.length())
    // 		    {
    // 		        s1=s2;
    // 		        s2=temp;
    // 		    }
    // 			for(int i=0;i<s2.length();i++) {
    				
    				
    // 				int num1=Integer.valueOf(s1.charAt(i));
    // 				int num2=Integer.valueOf(s2.charAt(i));
    // 				//System.out.println(" Strings "+ s1+" "+s2+ " sub "+ (num1-num2));
    // 				if(num1-num2>0)
    // 				return -1;
    // 				else if(num1-num2<0)
    // 				return 1;
    // 				else
    // 				continue;
    // 			}
    // 		String combination1=s1+s2;
    // 		String combination2=s2+s1;
    // 		Long c1=Long.valueOf(combination1);
    // 		Long c2=Long.valueOf(combination2);
    // 		if(c1>c2)
    // 		return 1; 
    // 		else 
    // 		return -1;
    		
    // }
    String printLargest(String[] arr) {
        // code here
    Arrays.sort(arr,new Comparator<String>(){
        public int compare(String s1,String s2){
            
            String x=s1+s2;
            String y=s2+s1;
            if(x.compareTo(y)>0)
            return -1;
            else 
            return 1;
        }});
            // if(s1.length()==s2.length()){
            //     long l1=Long.parseLong(s1);
            //     long l2=Long.parseLong(s2);
            //     return (int)(l1-l2);
            // }
            // else if(s1.length>s2.length){
            //     for(int i=0;i<s2.length();i++){
            //     if(s1.charAt(i)>s2.charAt(i))
            //     return 1;
            //     if(s1.charAt(i)<s2.charAt(i))
            //     return -1;    
            // }
            //             if(s1.charAt(s1.length()-1)>s2.charAt(0)){
            //   // System.out.println("here");
            //     return -1;
            // }
            // else{
            //  //   System.out.println("here1 "+s1.charAt(s1.length()-1)+ " "+ s2.charAt(0) );
            //     return 1;
            // }
            
            // }
            // else{
                
            // }
    //         if(s1.equals(s2))
    //         return 0;
    //   else  if(s1.length()>s2.length()){
    //         for(int i=0;i<s2.length();i++){
    //             if(s1.charAt(i)>s2.charAt(i))
    //             return 1;
    //             else if(s1.charAt(i)<s2.charAt(i))
    //             return -1;
    //             else 
    //             continue;
    //         }
    //         if(s1.charAt(s1.length()-1)>s2.charAt(0)){
    //             System.out.println("here");
    //             return -1;
    //         }
    //         else{
    //             System.out.println("here1 "+s1.charAt(s1.length()-1)+ " "+ s2.charAt(0) );
    //             return 1;
    //         }
            
    //     }
    //     else {
    //         for(int i=0;i<s1.length();i++){
    //             if(s2.charAt(i)>s1.charAt(i))
    //             return 1;
    //             else if(s2.charAt(i)<s1.charAt(i))
    //             return -1;
    //             else 
    //             continue;
    //         }
    //         if(s2.charAt(s2.length()-1)>s1.charAt(0)){
    //             System.out.println("here");
    //             return -1;
    //         }
    //         else{
    //             System.out.println("here21");
    //             return 1;
    //         }
            
    //     }
    //     }
     	
    	
    
    	String ans="";
    	for(String s: arr)
    		ans+=s;
    		//System.out.println(Arrays.toString(arr));
    	return ans.trim();
    }
}