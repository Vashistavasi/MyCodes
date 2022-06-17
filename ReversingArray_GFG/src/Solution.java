// { Driver Code Starts
//Initial Template for Java

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {
    public static void main (String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
//        
        //while testcases exist
//        while(t-->0){
            
//            String inputLine1[] = br.readLine().trim().split(" ");
//            int n = Integer.parseInt(inputLine1[0]);
//            int k = Integer.parseInt(inputLine1[1]);
            
            ArrayList<Integer> arr = new ArrayList<Integer>(); 
            List<Integer> brr = new ArrayList<Integer>();  
//            String inputLine2[] = br.readLine().trim().split(" ");
//            for(int i=0; i<n; i++){
//                arr.add(Integer.parseInt(inputLine2[i]));
//            }
            Integer [] a= {1,2,3,4,5};
            brr=Arrays.asList(a);
            for(int i=0;i<brr.size();i++) {
            	arr.add(i,brr.get(i));
            }
            int k=3;
           sn obj = new sn();
            obj.reverseInGroups( arr, arr.size(), k);
            
            StringBuffer str = new StringBuffer();
            for(int i=0; i<arr.size(); i++){
                str.append(arr.get(i) + " ");
            }
            System.out.println(str);
        }
    }


// } Driver Code Ends


//User function Template for Java

class sn {
    //Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
    	 for(int i=0;i<n;i=i+k){
             
             int first=i;
             int end=Math.min(n-1,i+k-1);
             while(first<end){
                 int temp=arr.get(first);
                 //arr.remove(first);
                  arr.set(first,arr.get(end));
                 // arr.remove(end);
                  arr.set(end,temp);
                 first++;
                 end--;
                
             }}
    	
    	
//    	
//    	  Deque<Integer> dq
//          = new ArrayDeque<Integer>();
//          ArrayList <Integer>b=new ArrayList<Integer> ();
//          if(k==1)
//          return ;
//      for(int i=0;i<n;i=i+k){
//          
//          for(int j=i;j<i+k&&j<n;j++){
//              dq.push(arr.get(j));
//      }
//             
//             for(int l=i;l<i+k&&l<n;l++){
//          	   //arr.remove(l);
//              //   arr.add(l,dq.pop());
//              b.add(dq.pop());
//             }
//    	 }
//   arr=(ArrayList<Integer>)b.clone();

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//          Deque<Integer> dq
//            = new ArrayDeque<Integer>();
//            if(k==1)
//            return ;
//        for(int i=0;i<n;i=i+k){
//        	//int temp[]=new int[k];
//        	ArrayList<Integer> al= new ArrayList<Integer>();
//        	for(int j=i;j<i+k&&j<n;j++) {
//        		//temp[j%k]=arr.get(j);
//        		al.add(arr.get(j));
//        	}
//        	//int upper=i+k-1;
////        	if(i+k>=n)
////    			upper=n%k-1;
//        	int size=al.size()-1;
//        	for(int l=i;l<i+k&&l<n;l++) {
//        		arr.remove(l);
//        		
//        		arr.add(l,al.get(size));
//        		//upper--;
//        		size--;
//        	}
//            
////            for(int j=i;j<i+k&&j<n;j++){
////                dq.push(arr.get(j));
////        }
////               
////               for(int l=i;l<i+k&&l<n;l++){
////            	   arr.remove(l);
////                   arr.add(l,dq.pop());
////               }
//    }
    System.out.println();
    for(int i: arr){
        System.out.print(" "+ i+" ");
    }
    System.out.println();
    
    // return arr;
}
}
