//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        Solution obj = new Solution();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String A = read.readLine().trim();
            
            String ans = obj.chooseandswap(A);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    
    String chooseandswap(String A){
        // Code Here
        boolean visited[]=new boolean[26];
        char a[]=A.toCharArray();
        char min=a[0];
        char f='a';
        boolean flag=false;
        for(int i=0;i<a.length;i++){
            min=a[i];
            for(int j=i+1;j<a.length;j++){
               //System.out.print((int)min+" "+ (int)a[j]+" ");
               visited[a[i]-'a']=true;
            if( min>a[j] && !visited[a[j]-'a']){
        
                min=a[j];
                f=a[i];
                //System.out.print(min+" "+ i+" ");
                flag=true;
            }//System.out.print(min+" "+f);
            }if(flag)
            break;
            
            
        }
        if(flag){
        ArrayList<Integer> al=new ArrayList<Integer> ();
        ArrayList<Integer> bl=new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            if(a[i]==min)
            al.add(i);
            if(a[i]==f)
            bl.add(i);
        }
        for(int i=0;i<al.size();i++){
            a[al.get(i)]=f;
            
        }
        for(int i=0;i<bl.size();i++){
            a[bl.get(i)]=min;
        }
    
        }
        //System.out.println(min+" "+ f);
        return new String(a);
    }
    
}