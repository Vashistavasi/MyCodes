// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
        // Your code here
            	char[] original=str2.toCharArray();
    	int size=original.length;
    	char[] clockwise=new char[original.length];
    	char[] antiClockwise=new char[original.length];
    	for(int i=0;i<original.length;i++) {
    		clockwise[(i+2)%size]=original[i];
    		antiClockwise[(size-2+i)%size]=original[i];
    	}
        String c=new String(clockwise);
        String ac=new String(antiClockwise);
        // System.out.println(c);
        // System.out.println(ac);
        
        if(str1.equals(c)||str1.equals(ac))
        	return true;
        else
        	return false;
    }
    
}