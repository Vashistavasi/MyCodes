// { Driver Code Starts
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.stream.Stream;


class GFG {

	public static void main (String[] args) throws IOException {

		    //size of array
		   String a="6 1 8 9 2 7 9 5 4 3";
		   a=a.replace(" ", ",");
		   // int arr[] = {1,1,5,2,7,6,1,4,2,3};
//		    int arr[] = {6,1,8,9,2,7,9,5,4,3};
		   //int arr[]= {7,2,6,0,1,6};
		 // int arr[]= {6 ,1 ,8 ,9 ,2 ,7 ,9 ,5 ,4 ,3};
		   String fileData = new String(Files.readAllBytes(Path.of("C:\\Users\\10683788\\Downloads\\y.txt")));
		   int[] arr = Stream.of(fileData.split(" ")).mapToInt(Integer::parseInt).toArray();


		    int n = arr.length;

		    
//		System.out.println(a);
//		    
		   Solution obj = new Solution();

	    System.out.println(Solution.trappingWater(arr, n));
		}
	}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        long ans=0;
        int start=0;
     
        int temp=0;
        ArrayDeque<Integer> dq=new ArrayDeque<Integer>();
 HashMap<Integer,Integer> memory=new HashMap<Integer,Integer>();
        dq.push(arr[0]);
        int temp_sum=0;
       // int thrice=0;
        for(int i=1;i<n;i++){
        if(dq.peek()>arr[i]){
            temp++;
            temp_sum+=arr[i];
        }
        else{
//        	if(dq.peek()==arr[i]) {
//        		thrice+=ans;
//        		  ans+=temp*dq.pop();
//                  if(temp!=0)
//                 ans-=temp_sum;
//                  thrice+=ans-thrice;
//                 dq.push(arr[i]);
//                 temp=0;
//                 temp_sum=0;	
//        	}
//        	else {
                ans+=temp*dq.pop();
                if(temp!=0)
               ans-=temp_sum;
                if(ans<0) {
                	System.out.println();
                }
               dq.push(arr[i]);
               temp=0;
               temp_sum=0;
               memory.put(i, start);
               start=i;
//        	}

        }
        }
        System.out.println(ans);
        System.out.println("Above result forward ");
      //  long twice=0;
start=n-1;
        ArrayDeque<Integer> dq1=new ArrayDeque<Integer>();
         dq1.push(arr[n-1]);
         int temp1=0;
         int temp_sum1=0;
                for(int i=n-2;i>=0;i--){
        if(dq1.peek()>arr[i]){
            temp1++;
            temp_sum1+=arr[i];
        }
        else{
        	if(memory.get(start)!=null&&memory.get(start)==i) {
        		temp1=0;
        		temp_sum1=0;
        		start=i;
        		continue;
        	}
        		
//        	if(dq1.peek()==arr[i]) {
//        		twice+=ans;
//        		 ans+=temp1*dq1.pop();
//                 if(temp1!=0)
//                 ans-=temp_sum1;
//                 twice+=ans-twice;
//                 ans=ans-twice;
//                 dq1.push(arr[i]);
//                 temp1=0;
//                 temp_sum1=0;
//        		
//        	}
//        	else {
        		  ans+=temp1*dq1.pop();
                  if(temp1!=0)
                  ans-=temp_sum1;
                  dq1.push(arr[i]);
                  temp1=0;
                  temp_sum1=0;	
                  start=i;
       // 	}
        	
          
        }
        }
                System.out.println("Backward "+ ans);
//                System.out.println(twice+" twice ");
//                System.out.println(thrice+" Thrice ");
        return ans;
        
    } 
}


