//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends

class pair{
	Character c;
	int count;
	pair(char c,int count){
		this.c=c;
		this.count=count;
	}
	pair(){
		
	}
	
}
class PairComparator implements Comparator<pair>{

	@Override
	public int compare(pair o1, pair o2) {
		return o2.count-o1.count;
	}
	
	
	
}
class Solution
{
    public static int findMax (int [] count){
        
        int max=Integer.MIN_VALUE;
        int ans=-1;
        for(int i=0;i<count.length;i++)
        {
            if(max<count[i]){
                max=count[i];
                ans=i;
            }
            
        }
        return ans;
    }
	public static String rearrangeCharacters(String str) {
	
		 int[] count = new int[26];
		 int n=str.length();
 
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'a']++;
            
        char [] s=new char[str.length()];
        int max=findMax(count);
        if(count[max]>(n+1)/2)
        return "-1";
        for(int i=0;i<str.length();){
            int temp=count[max];
            while(i<str.length() && temp-->0){
                s[i]=(char)(max+'a');
                i+=2;
            }
            count[max]=temp;
            if(i<n)
            max=findMax(count);
        }
        if(count[max]<=0) {
        	max=findMax(count);
        }
        while(count[max]>0) 
        for(int i=1;i<n;) {
       int temp=count[max];
       while(i<str.length() && temp-->0){
           s[i]=(char)(max+'a');
           i+=2;
       }
       count[max]=temp;
       max=findMax(count);
        }
        
        
        //System.out.println(new String(s));
        return new String(s);
// 		PriorityQueue<pair>pq=new PriorityQueue<pair>(new PairComparator());
// 		  for (char c = 'a'; c <= 'z'; c++) {
//             int val = c - 'a';
//             if (count[val] > 0)
//                 pq.add(new pair(c,count[val]));
//         }
// 		String s="";
		
// 		pair prev=new pair('(',-1);
// 		 while (pq.size() != 0) {
		
// 	            pair k = pq.poll();
// 	            s = s + k.c;
	 
// 	            if (prev.count > 0)
// 	                pq.add(prev);
// 	            (k.count)--;
// 	            prev = k;
	            
// 	        }
	  
// 		if(s.length()==str.length())
// 		return s;
// 		else 
// 		return "-1";
	}
}