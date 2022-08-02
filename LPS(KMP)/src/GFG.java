// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
//         public static int suffixLength(int position,String s){
//         String suffix=s.substring(position,s.length());
// //System.out.println(suffix);
// int length=suffix.length();
// String prefix=s.substring(0,length);

// if(suffix.equals(prefix))
// return length;
// else
// return 0;
    // }
    int lps(String s) {
        
        
        
                int n = s.length();
     
        int lps[] = new int[n];
         
        lps[0] = 0;
     
        int len = 0;
     
        int i = 1;
        while (i < n)
        {
            if (s.charAt(i) == s.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
             
            else
            {
                if (len != 0)
                {
                    len = lps[len-1];
     
                }
                 
    
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
     
        return lps[n-1];
        
        
        
        
        
        
        
        
        
        
        
        
        // code here
    //     int n = s.length();
 
    //   if(n < 2) {
    //       return 0;
    //   }
 
    //   int len = 0;
    //   int i = 0 ;
 
    //   while(i < n)
    //   {
 
    //     if(s.charAt(i) == s.charAt(len))
    //     {
    //       ++len;
    //       ++i;
    //     }
    //     else
    //     {
    //       i = i - len + 1;
    //       len = 0;
    //     }
    //   }
 
      
    //   return len;
      
//       int size=0;
// char c=s.charAt(0);
// int position=0;
// int ans=0;
// int inputLength=s.length();
// // for(int  i=s.length()-1;i>0;i--){
// //     if(s.charAt(i)==c){
// //         position=i;
// //         ans=Math.max(ans,suffixLength(position,s));
// //     }
// // }
// for(int  i=1;i<s.length();i++){
//     if(s.charAt(i)==c ){
//         position=i;
//         ans=Math.max(ans,suffixLength(position,s));
//         if(ans!=0)
//         break;
//     }
// }
// return ans;

        // for(int i=0;i<s.length()-1;i++){
        //      if(s.charAt(i)==s.charAt(s.length()-1)&&s.charAt(s.length()-i-1)==s.charAt(0)
        //      ){
        //          String a=	s.substring(0, i+1);
        //     	String b=s.substring(s.length()-i-1, s.length());
        //     if(a.equals(b)) {
        //     	size= i+1;
        //     }	
        // }
            
       
        // }
        // return size;
      
      
      
//   int length=s.length();
//   int a[]=new int[length];
//   a[0]=0;
//   int len=0;
//   int i=1;
//   while(i<length){
//       if(s.charAt(i)==s.charAt(len)){
//           len++;
//           a[i]=len;
//           i++;
//       }
//       else{
//           if(len!=0){
//               a[i]=a[len-1];
//           }
//           else{
//               a[i]=0;
//               i++;
//           }
//       }
//   }
//   return a[length-1];
    }
}