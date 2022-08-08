//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    // public static String fun(HashMap<Character,Integer> parent,HashMap<Character,Integer> child,String s){
    //     int start=0;
    //     int end=s.length()-1;
    //     for(int j=end;j>=0;j--){
    //         parent.put(s.charAt(j),parent.get(s.charAt(j))-1);
    //         if(child.containsKey(s.charAt(j))){
    //         if(parent.get(s.charAt(j))<child.get(s.charAt(j))){
    //             //flag=false;
    //             end=j;
    //             parent.put(s.charAt(j),parent.get(s.charAt(j))+1);
    //             break;
    //         }    
    //         }
    //     }
    //     //flag=true;
    //     for(int j=start;j<end;j++){
    //         parent.put(s.charAt(j),parent.get(s.charAt(j))-1);
    //         if(child.containsKey(s.charAt(j))){
    //             if(parent.get(s.charAt(j))<child.get(s.charAt(j))){
    //             //flag=false;
    //             start=j;
    //             parent.put(s.charAt(j),parent.get(s.charAt(j))-1);
    //             break;    
    //             }
    //         }
            
    //     }
        
    //     return s.substring(start,end+1);
    // }
    
    
    //     public static String fun1(HashMap<Character,Integer> parent,HashMap<Character,Integer> child,String s){
    //     int start=0;
    //     int end=s.length()-1;

    //     //flag=true;
    //     for(int j=start;j<s.length();j++){
    //         parent.put(s.charAt(j),parent.get(s.charAt(j))-1);
    //         if(child.containsKey(s.charAt(j))){
    //             if(parent.get(s.charAt(j))<child.get(s.charAt(j))){
    //           // flag=false;
    //             start=j;
    //             parent.put(s.charAt(j),parent.get(s.charAt(j))-1);
    //             break;    
    //             }
    //         }
            
    //     }
    //             for(int j=end;j>=0;j--){
    //         parent.put(s.charAt(j),parent.get(s.charAt(j))-1);
    //         if(child.containsKey(s.charAt(j))){
    //         if(parent.get(s.charAt(j))<child.get(s.charAt(j))){
    //             //flag=false;
    //             end=j;
    //             parent.put(s.charAt(j),parent.get(s.charAt(j))+1);
    //             break;
    //         }    
    //         }
    //     }
        
    //     return s.substring(start,end+1);
    // }
    
    
    
    
    
    
    
    
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        
        int parent[]=new int[26];
        int child[]=new int[26];
        if(p.length()>s.length()){
            return "-1";
        }
        for(int i=0;i<p.length();i++){
            child[p.charAt(i)-'a']++;
        }
        int count=0;
        int start=0;
        int start_index=-1;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            
            parent[s.charAt(i)-'a']++;
            
            if(parent[s.charAt(i)-'a']<=child[s.charAt(i)-'a'])
            count++;
            if(count==p.length()){
                while(parent[s.charAt(start)-'a']>child[s.charAt(start)-'a']|| child[s.charAt(start)-'a']==0){
                    parent[s.charAt(start)-'a']--;
                    start++;
                }
                int len=i-start+1;
            //System.out.println(start);
            if(ans>len){
                //System.out.println(len);
                ans=len;
                start_index=start;
            }
            }
            
         
        }
       // System.out.println(start_index);
        if(start_index==-1)
        return "-1";
        else
         return s.substring(start_index,start_index+ans);
        
        
        
        // HashMap<Character,Integer> parent=new HashMap<Character,Integer>();
        // HashMap<Character,Integer> child=new HashMap<Character,Integer>();
        // for(int i=0;i<s.length();i++){
        //     if(!parent.containsKey(s.charAt(i))){
        //         parent.put(s.charAt(i),1);
        //     }
        //     else
        //     parent.put(s.charAt(i),parent.get(s.charAt(i))+1);
        // }
        // for(int i=0;i<p.length();i++){
        //     if(!child.containsKey(p.charAt(i))){
        //         child.put(p.charAt(i),1);
        //     }
        //     else
        //     child.put(p.charAt(i),child.get(p.charAt(i))+1);
        // }
        // boolean flag=true;
        //         for(int i=0;i<p.length();i++){
        //             if(parent.get(p.charAt(i))==null)
        //             return "-1";
        //     if(parent.get(p.charAt(i))<child.get(p.charAt(i))){
        //         flag=false;
        //         break;
        //     }
        // }
        // if(!flag)
        // return "-1";
        // //         System.out.println(parent.keySet());
        // // Set<Character> ll=parent.keySet();
        // // for(char c:ll)
        // // System.out.print(" "+parent.get(c)+" ");
        // HashMap<Character,Integer> parent2=new HashMap<Character,Integer> (parent);
        // HashMap<Character,Integer> child2=new HashMap<Character,Integer> (child);
        // String s1=fun(parent,child,s);
        // String s2=fun1(parent2,child2,s);
        // // System.out.println(parent.keySet());
        // // Set<Character> l=parent.keySet();
        // // for(char c:l)
        // // System.out.print(" "+parent.get(c)+" ");
        
        // // System.out.println(parent.keySet());
        // // System.out.println(s1+ " is the s1");
        // // System.out.println(s2+" is the s2");
        // if(s1.length()==s2.length())
        // return s1;
        // else if(s1.length()>s2.length())
        // return s2;
        // else
        // return s1;

        
        
        
        
        // HashSet<Character>hs=new HashSet<Character>();
        // int min=s.length();
        // String ans="-1";
        // for(int i=0;i<p.length();i++){
        //     hs.add(p.charAt(i));
        // }
        // if(p.length()==1)
        // for(int i=0;i<s.length();i++){
        //     if(s.charAt(i)==p.charAt(0))
        //     return p;
        // }
        // for(int i=0;i<s.length();i++){
        //     if(hs.contains(s.charAt(i))){
        //     for(int j=i+1;j<s.length();j++){
        //      if(hs.contains(s.charAt(j))){
        //          int temp=check(s.substring(i,j+1),p);
        //          if(temp!=Integer.MAX_VALUE){
        //             if(min>temp){
        //               ans=s.substring(i,j+1);
        //               min=temp;
        //               break;
        //             }
        //          }
                 
        //      }
        //     }    
        //     }
            
        // }
        // return ans;
    }
    // public static int check(String s, String p){
    //     HashSet<Character>hs=new HashSet<Character>();
    //     for(int i=0;i<s.length();i++)
    //     hs.add(s.charAt(i));
    //     for(int i=0;i<p.length();i++){
    //         if(!hs.contains(p.charAt(i)))
    //         return Integer.MAX_VALUE;
    //     }
    //     return s.length();
    // }  
}