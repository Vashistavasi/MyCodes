
//{ Driver Code Starts
import java.util.*;
class GFG {
 public static void main(String[] args) {
   
      {
//         String s ="50361";
        String s= "29390885";
         Solution sln = new Solution();
         ArrayList<String> str = sln.genIp(s);
         Collections.sort(str);
         if(str.size() == 0)
             System.out.println(-1);
         else{
             for (String u : str) {
                 System.out.println(u);
             }
         }
     }
 }
}// } Driver Code Ends


/*complete the Function*/

class Solution {
	public static boolean isValid(String s) {
		int n=Integer.parseInt(s);
		if(n>=0&&n<256)
			return true;
		
		return false;
	}
	public static void ips(String s,int index, int count, String temp,ArrayList<String> al ) {
		
		if(count==4&&temp.length()==s.length()+4   ) {
			
          al.add(temp.substring(1,temp.length()));
          System.out.println(temp+" is the ip value" );
          return ;
		}
	    if(index-1>=0) {
	    	String ending1=s.substring(index-1,index);
	    
	    	if(isValid(ending1)) {
				temp="."+ending1+temp;
				ips(s,index-1,count+1,temp,al);
				temp=temp.substring(2,temp.length());
			}
			else {
				return;
			}
	    }
	    if(index-2>=0) {
	    	String ending2=s.substring(index-2,index);
	    	
	    	if(isValid(ending2)) {
				temp="."+ending2+temp;
				ips(s,index-2,count+1,temp,al);
				temp=temp.substring(3,temp.length());
			}
			else {
				return;
			}
	    }
		
	    if(index-3>=0) {
	    	String ending3=s.substring(index-3,index);
	    	
			if(isValid(ending3)) {
				temp="."+ending3+temp;
				ips(s,index-3,count+1,temp,al);
				temp=temp.substring(4,temp.length());
			}
			else {
				return;
			}
	    }
		
		
	}
	
 public ArrayList<String> genIp(String s) {
     // code here
	 if(s.length()<3&&s.length()>12) {
		 return new ArrayList<String>();
	 }
	 ArrayList<String> al=new ArrayList<String>();
	 String temp=new String();
	 ips(s, s.length(), 0, temp, al);
	 ArrayList<String> rm=new ArrayList<String>();
	 for(int i=0;i<al.size();i++) {
		 String a=al.get(i);
		 StringTokenizer st=new StringTokenizer(al.get(i), ".");
		 while(st.hasMoreTokens()) {
			 String tok=st.nextToken();
			 if(tok.charAt(0)=='0'&&tok.length()!=1)
				 if(!rm.contains(a))
				 rm.add(a);
		 }
	 }
	 for(int i=0;i<rm.size();i++) {
		 System.out.println(rm.get(i)+" what ");
	 }
	 return al;
	 
 }
}