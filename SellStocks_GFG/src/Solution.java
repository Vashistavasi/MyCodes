// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
  String a ="886 2777 6915 7793 8335 5386 492 6649 1421 2362 27 8690 59 7763 3926 540 3426 9172 5736 5211 5368 2567 6429 5782 1530 2862 5123 4067 3135 3929 9802 4022 3058 3069 8167 1393 8456 5011 8042 6229 7373 4421 4919 3784 8537 5198 4324 8315 4370 6413 3526 6091 8980 9956 1873 6862 9170 6996 7281 2305 925 7084 6327 336 6505 846 1729 1313 5857 6124 3895 9582 545 8814 3367 5434 364 4043 3750 1087 6808 7276 7178 5788}";
  a=a.replace(" ", ",");
 // System.out.println(a);
//int [] price={ 100, 180, 260, 310, 40, 535, 695 };
//int []price = {
//		886,2777,6915,7793,8335,5386,492,6649,1421,2362,27,8690,59,7763,3926,540,3426,9172,5736,5211,5368,2567,6429,5782,1530,2862,5123,4067,3135,3929,9802,4022,3058,3069,8167,1393,8456,5011,8042,6229,7373,4421,4919,3784,8537,5198,4324,8315,4370,6413,3526,6091,8980,9956,1873,6862,9170,6996,7281,2305,925,7084,6327,336,6505,846,1729,1313,5857,6124,3895,9582,545,8814,3367,5434,364,4043,3750,1087,6808,7276,7178,5788
//};
  int price[]= {267,2};
		int n=price.length;
            GFG sln = new GFG();
            sln.stockBuySell(price, n);
        }
    
}// } Driver Code Ends


// User function Template for Java

class GFG {
    public void stockBuySell(int[] price, int n) {
  
    	StringBuffer sb=new StringBuffer();
        boolean flag=false;
      for(int i=0;i<n-1;i++){
          if(price[i]<price[i+1]){
              flag=true;
              break;
          }
      }
      if(flag){
          boolean start=false;
      for(int i=0;i<n;i++){
          if(i==n-1){
              if(start&&price[i]>price[i-1]){
                   //System.out.print(i+") " );
                   sb.append(i+") " );
              }
              break;
          }
          if(!start){
              if(price[i]<price[i+1]){
                  start=true;
                   //System.out.print("("+i+" " );
                    sb.append("("+i+" " );
              }
            
          }
          else{
              if(price[i]<price[i+1]){
                  continue;
              }
              else{
                  start=false;
                  // System.out.print(i+") " );
                  sb.append(i+") " );
              }
          }
          
      }
       System.out.print(sb);
      }
      else
        System.out.print("No Profit");
      System.out.println();
        
        
    //     if(!flag){
    //          for(int i=0;i<n;i++){
    //         if(i==n-1){
    //              if(diff[i]==1){
    //                 System.out.print(i+") " );
    //             }
    //              break; 
    //         }
    //         if(diff[i]==0){
    //             if(diff[i+1]==1){
    //                  System.out.print("("+i+" " );
    //             }
    //         }
    //         else{
    //             if(diff[i+1]==0){
    //                 System.out.print(i+") " );
    //             }
    //         }
           
    //     }
    //     }
    //   else
    //     System.out.print("No Profit");

    
//    
//        int diff[]=new int[n];
//        for(int i=0;i<n-1;i++){
//            if(price[i+1]>price[i]){
//                diff[i+1]=1;
//            }
//        }
//        for(int i=0;i<n;i++){
//            if(i==n-1){
//                 if(diff[i]==1){
//                    System.out.print(i+") " );
//                 
//                }
//                 break; 
//            }
//            if(diff[i]==0){
//                if(diff[i+1]==1)
//                System.out.print("("+i+" " );
//            }
//            else{
//                if(diff[i+1]==0){
//                    System.out.print(i+") " );
//                }
//                
//            }
//           
//        }
  }
}