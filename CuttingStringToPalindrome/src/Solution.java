import java.util.ArrayList;
import java.util.Collections;

public class Solution {
public static boolean isPalindrome(String s) {
	StringBuffer sb= new StringBuffer();
	for(int i=s.length()-1;i>=0;i--) {
		sb.append(s.charAt(i));
	}
	String reverse=new String(sb);
	if(s.equals(reverse))
	return true;
	else 
		return false;
}
public static void main(String[] args) {
	String s="aab";
	
		ArrayList<Integer >a = new ArrayList<Integer>();
		Collections.reverseOrder()
	System.out.println(cuts(s));
	
}
public static int cuts(String s) {
	int count=0;
	int temp=0;
	for(int i=1;i<s.length();i++) {
		String s1=s.substring(0,i);
		String s2=s.substring(i,s.length());
		
		boolean s1b=isPalindrome(s1);
		boolean s2b=isPalindrome(s2);
		if(s1b&&s2b) {
			
			temp=Math.min(count, Integer.MAX_VALUE);
			count=0;
			return temp+1;
		}
			
		else if(s1b&&!s2b)
		{
			count+=1+cuts(s2);

			temp=Math.min(count, Integer.MAX_VALUE);
			count=0;
			
		}
		else if(!s1b&&s2b)
		{
			count+=1+cuts(s1);
			temp=Math.min(count, Integer.MAX_VALUE);
			count=0;
		}
		else
			continue;
			
		
	}
	return temp;
}
}
